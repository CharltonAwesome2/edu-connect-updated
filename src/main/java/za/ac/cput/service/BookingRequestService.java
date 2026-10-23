// BookingRequestService.java
// BookingRequest service class
// Author: Reotshepile Stock (230875807)
// Date: 21 October 2026


package za.ac.cput.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.enums.BookingStatus;
import za.ac.cput.repository.BookingRequestRepository;


@Service
public class BookingRequestService implements IBookingRequestService {

    private final BookingRequestRepository bookingRequestRepository;

    @Autowired
    public BookingRequestService(
            BookingRequestRepository bookingRequestRepository) {
        this.bookingRequestRepository = bookingRequestRepository;
    }

    @Override
    public BookingRequest create(BookingRequest bookingRequest) {
        return bookingRequestRepository.save(bookingRequest);
    }

    @Override
    public BookingRequest read(Long id) {
        return bookingRequestRepository.findById(id).orElse(null);
    }

    @Override
    public BookingRequest update(BookingRequest bookingRequest) {
        return bookingRequestRepository.save(bookingRequest);
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
    public BookingRequest updateStatus(Long id, BookingStatus status) {
        BookingRequest bookingRequest = bookingRequestRepository.findById(id).orElse(null);
        if (bookingRequest == null) {
            return null;
        }
        bookingRequest.setStatus(status);
        return bookingRequestRepository.save(bookingRequest);
    }
}
