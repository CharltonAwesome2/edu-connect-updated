// BookingRequestService.java
// BookingRequest service class
// Author: Reotshepile Stock (230875807)
// Date: 21 October 2026

package za.ac.cput.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.BookingStatus;
import za.ac.cput.enums.NotificationType;
import za.ac.cput.enums.SessionStatus;
import za.ac.cput.repository.BookingRequestRepository;
import za.ac.cput.repository.TutoringSessionRepository;
import za.ac.cput.service.IService.IBookingRequestService;

@Service
public class BookingRequestService implements IBookingRequestService {

    private final BookingRequestRepository bookingRequestRepository;
    private final TutoringSessionRepository tutoringSessionRepository;
    private final NotificationService notificationService;

    @Autowired
    public BookingRequestService(
            BookingRequestRepository bookingRequestRepository,
            TutoringSessionRepository tutoringSessionRepository,
            NotificationService notificationService) {
        this.bookingRequestRepository = bookingRequestRepository;
        this.tutoringSessionRepository = tutoringSessionRepository;
        this.notificationService = notificationService;
    }

    @Override
    @Transactional
    public BookingRequest create(BookingRequest bookingRequest) {
        return bookingRequestRepository.save(bookingRequest);
    }

    @Override
    public BookingRequest read(Long id) {
        return bookingRequestRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public BookingRequest update(BookingRequest bookingRequest) {
        BookingRequest saved = bookingRequestRepository.save(bookingRequest);
        createSessionIfApproved(saved);
        notifyStudentOfBookingOutcome(saved);
        return saved;
    }

    @Override
    public void delete(Long id) {
        bookingRequestRepository.deleteById(id);
    }

    @Override
    public List<BookingRequest> getAll() {
        return bookingRequestRepository.findAll();
    }

    @Override
    public List<BookingRequest> getAllByStudent(User student) {
        return bookingRequestRepository.findAllByStudent(student);
    }

    @Override
    public List<BookingRequest> getAllByStudentId(Long userId) {
        return bookingRequestRepository.findAllByStudent_UserId(userId);
    }

    @Override
    public List<BookingRequest> getAllByTutorProfile(TutorProfile tutorProfile) {
        return bookingRequestRepository.findAllByTutorProfile(tutorProfile);
    }

    @Override
    public List<BookingRequest> getAllBySubject(Subject subject) {
        return bookingRequestRepository.findAllBySubject(subject);
    }

    @Override
    public List<BookingRequest> getAllByStatus(BookingStatus status) {
        return bookingRequestRepository.findAllByStatus(status);
    }

    @Override
    public List<BookingRequest> getAllByStudentAndStatus(User student, BookingStatus status) {
        return bookingRequestRepository.findAllByStudentAndStatus(student, status);
    }

    @Override
    public List<BookingRequest> getAllByTutorProfileAndStatus(TutorProfile tutorProfile, BookingStatus status) {
        return bookingRequestRepository.findAllByTutorProfileAndStatus(tutorProfile, status);
    }

    @Override
    public List<BookingRequest> getAllByStartTimeBetween(LocalDateTime start, LocalDateTime end) {
        return bookingRequestRepository.findAllByRequestedStartTimeBetween(start, end);
    }

    @Override
    @Transactional
    public BookingRequest updateStatus(Long id, BookingStatus status) {
        BookingRequest bookingRequest = bookingRequestRepository.findById(id).orElse(null);
        if (bookingRequest == null) {
            return null;
        }
        bookingRequest.setStatus(status);
        BookingRequest saved = bookingRequestRepository.save(bookingRequest);
        createSessionIfApproved(saved);
        notifyStudentOfBookingOutcome(saved);
        return saved;
    }

    private void createSessionIfApproved(BookingRequest bookingRequest) {
        if (bookingRequest.getStatus() != BookingStatus.APPROVED) {
            return;
        }
        if (tutoringSessionRepository
                .existsByBookingRequest_BookingRequestId(bookingRequest.getBookingRequestId())) {
            return;
        }

        LocalDateTime start = bookingRequest.getRequestedStartTime();
        LocalDateTime end = start.plusMinutes(bookingRequest.getDurationMinutes());
        LocalDateTime now = LocalDateTime.now();

        TutoringSession session = TutoringSession.builder()
                .bookingRequest(bookingRequest)
                .student(bookingRequest.getStudent())
                .tutorProfile(bookingRequest.getTutorProfile())
                .subject(bookingRequest.getSubject())
                .startTime(start)
                .endTime(end)
                .status(SessionStatus.SCHEDULED)
                .createdAt(now)
                .updatedAt(now)
                .build();

        tutoringSessionRepository.save(session);
    }

    private void notifyStudentOfBookingOutcome(BookingRequest bookingRequest) {
        if (bookingRequest.getStudent() == null) {
            return;
        }

        NotificationType type;
        String title;
        String message;

        if (bookingRequest.getStatus() == BookingStatus.APPROVED) {
            type = NotificationType.BOOKING_CONFIRMATION;
            title = "Booking approved";
            message = "Your tutoring request was approved. Check your dashboard for the scheduled session.";
        } else if (bookingRequest.getStatus() == BookingStatus.DECLINED) {
            type = NotificationType.SYSTEM_ALERT;
            title = "Booking declined";
            message = "Your tutoring request was declined. You can request another time slot.";
        } else {
            return;
        }

        notificationService.create(Notification.builder()
                .user(bookingRequest.getStudent())
                .title(title)
                .message(message)
                .type(type)
                .isRead(false)
                .build());
    }
}