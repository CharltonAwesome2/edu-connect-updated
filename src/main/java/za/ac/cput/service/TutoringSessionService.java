package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.NotificationType;
import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;
import za.ac.cput.enums.SessionStatus;
import za.ac.cput.repository.PaymentRepository;
import za.ac.cput.repository.TutoringSessionRepository;
import za.ac.cput.service.IService.IInvoiceService;
import za.ac.cput.service.IService.ITutoringSessionService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.List;

/**
 * TutoringSessionService.java
 * TutoringSession model class
 * Author: Esaile Siani Djiakeng
 * Date: 21 October 2026
 */

@Service
public class TutoringSessionService implements ITutoringSessionService {

    private static final BigDecimal PLATFORM_FEE_RATE = new BigDecimal("0.10");

    private final TutoringSessionRepository tutoringSessionRepository;
    private final PaymentRepository paymentRepository;
    private final NotificationService notificationService;
    private final IInvoiceService invoiceService;

    @Autowired
    public TutoringSessionService(
            TutoringSessionRepository tutoringSessionRepository,
            PaymentRepository paymentRepository,
            NotificationService notificationService,
            IInvoiceService invoiceService) {
        this.tutoringSessionRepository = tutoringSessionRepository;
        this.paymentRepository = paymentRepository;
        this.notificationService = notificationService;
        this.invoiceService = invoiceService;
    }

    @Override
    public TutoringSession create(TutoringSession session) {
        return tutoringSessionRepository.save(session);
    }

    @Override
    public TutoringSession read(Long id) {
        return tutoringSessionRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public TutoringSession update(TutoringSession session) {
        TutoringSession saved = tutoringSessionRepository.save(session);

        if (saved.getStatus() == SessionStatus.COMPLETED) {
            Payment payment = createPaymentIfMissing(saved);
            if (payment != null) {
                invoiceService.createForPayment(payment);
            }
            notifyStudentOfCompletion(saved);
        }
        return saved;
    }

    private Payment createPaymentIfMissing(TutoringSession session) {
        if (session.getTutoringSessionId() == null) return null;

        var existing = paymentRepository.findBySession(session);
        if (existing.isPresent()) return existing.get();

        if (session.getTutorProfile() == null) return null;

        BigDecimal hourlyRate = session.getTutorProfile().getHourlyRate();
        if (hourlyRate == null) hourlyRate = BigDecimal.ZERO;

        BigDecimal hours = computeDurationHours(session);
        BigDecimal amount = hourlyRate.multiply(hours).setScale(2, RoundingMode.HALF_UP);
        BigDecimal fee = amount.multiply(PLATFORM_FEE_RATE).setScale(2, RoundingMode.HALF_UP);
        BigDecimal earnings = amount.subtract(fee).setScale(2, RoundingMode.HALF_UP);

        Payment payment = Payment.builder()
                .session(session)
                .amount(amount)
                .platformFee(fee)
                .tutorEarnings(earnings)
                .status(PaymentStatus.PENDING)
                .paymentMethod(PaymentMethod.CARD)   // placeholder; overwritten on pay
                .build();

        return paymentRepository.save(payment);
    }

    private BigDecimal computeDurationHours(TutoringSession session) {
        if (session.getStartTime() == null || session.getEndTime() == null) {
            return BigDecimal.ZERO;
        }
        long minutes = Duration.between(session.getStartTime(), session.getEndTime()).toMinutes();
        if (minutes <= 0) return BigDecimal.ZERO;
        return BigDecimal.valueOf(minutes)
                .divide(BigDecimal.valueOf(60), 4, RoundingMode.HALF_UP);
    }

    private void notifyStudentOfCompletion(TutoringSession session) {
        if (session.getStudent() == null) return;
        notificationService.create(Notification.builder()
                .user(session.getStudent())
                .title("Session completed")
                .message("Your tutoring session has been marked complete. " +
                         "An invoice has been generated — settle it from the Payments page.")
                .type(NotificationType.SESSION_UPDATE)
                .isRead(false)
                .build());
    }

    @Override public void delete(Long id) { tutoringSessionRepository.deleteById(id); }
    @Override public List<TutoringSession> getAll() { return tutoringSessionRepository.findAll(); }
    @Override public List<TutoringSession> findByTutoringSessionId(Long id) {
        return tutoringSessionRepository.findByTutoringSessionId(id);
    }
    @Override public List<TutoringSession> findByTutorProfile(TutorProfile tp) {
        return tutoringSessionRepository.findByTutorProfile(tp);
    }
    @Override public List<TutoringSession> findByTutorProfileId(Long id) {
        return tutoringSessionRepository.findByTutorProfile_TutorProfileId(id);
    }
    @Override public List<TutoringSession> findByStudent(User s) {
        return tutoringSessionRepository.findByStudent(s);
    }
    @Override public List<TutoringSession> findByStudentId(Long id) {
        return tutoringSessionRepository.findByStudent_UserId(id);
    }
}