// IBookingRequestService.java
// BookingRequest service interface
// Author: Reotshepile Stock (230875807)
// Date: 21 October 2026

package za.ac.cput.service;

import java.time.LocalDateTime;
import java.util.List;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.enums.BookingStatus;

public interface IBookingRequestService extends service<BookingRequest, Long> {

    List<BookingRequest> getAllByStudent(User student);

    List<BookingRequest> getAllByStudentId(Long userId);

    List<BookingRequest> getAllByTutorProfile(TutorProfile tutorProfile);

    List<BookingRequest> getAllBySubject(Subject subject);

    List<BookingRequest> getAllByStatus(BookingStatus status);

    List<BookingRequest> getAllByStudentAndStatus(User student, BookingStatus status);

    List<BookingRequest> getAllByTutorProfileAndStatus(TutorProfile tutorProfile, BookingStatus status);

    List<BookingRequest> getAllByStartTimeBetween(LocalDateTime start, LocalDateTime end);

    BookingRequest updateStatus(Long id, BookingStatus status);
}