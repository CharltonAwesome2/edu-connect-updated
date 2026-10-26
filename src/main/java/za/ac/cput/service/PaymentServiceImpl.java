package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;
import za.ac.cput.repository.PaymentRepository;
import za.ac.cput.service.IService.IPaymentService;

import java.time.LocalDateTime;
import java.util.List;

/* PaymentServiceImpl.java
    PaymentServiceImpl class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/

@Service
public class PaymentServiceImpl implements IPaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment read(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getBySession(TutoringSession session) {
        return paymentRepository.findBySession(session).orElse(null);
    }

    @Override
    public Payment getByTransactionReference(String transactionReference) {
        return paymentRepository.findByTransactionReference(transactionReference).orElse(null);
    }

    @Override
    public boolean existsByTransactionReference(String transactionReference) {
        return paymentRepository.existsByTransactionReference(transactionReference);
    }

    @Override
    public List<Payment> getAllByStatus(PaymentStatus status) {
        return paymentRepository.findAllByStatus(status);
    }

    @Override
    public List<Payment> getAllByPaymentMethod(PaymentMethod paymentMethod) {
        return paymentRepository.findAllByPaymentMethod(paymentMethod);
    }

    @Override
    public List<Payment> getAllByPaidAtBetween(LocalDateTime start, LocalDateTime end) {
        return paymentRepository.findAllByPaidAtBetween(start, end);
    }

    @Override
    public Payment updateStatus(Long id, PaymentStatus status) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment == null) {
            return null;
        }
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllByStudentId(Long userId) {
        return paymentRepository.findAllBySession_Student_UserId(userId);
    }

    @Override
    public List<Payment> getAllByTutorProfileId(Long tutorProfileId) {
        return paymentRepository.findAllBySession_TutorProfile_TutorProfileId(tutorProfileId);
    }
}