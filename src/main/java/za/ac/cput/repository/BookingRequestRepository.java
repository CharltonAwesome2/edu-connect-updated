// BookingRequestRepository.java
// Booking Request repository class
// Author: Reotshepile Stock (230875807)
// Date: 21 October 2026

package za.ac.cput.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.enums.BookingStatus;

public interface BookingRequestRepository extends JpaRepository<BookingRequest, Long> {

    List<BookingRequest> findAllByRequestedStartTimeBetween(LocalDateTime start, LocalDateTime end);

    List<BookingRequest> findAllByTutorProfileAndStatus(TutorProfile tutorProfile, BookingStatus status);

    List<BookingRequest> findAllByStudentAndStatus(User student, BookingStatus status);

    List<BookingRequest> findAllByStatus(BookingStatus status);

    List<BookingRequest> findAllBySubject(Subject subject);

    List<BookingRequest> findAllByTutorProfile(TutorProfile tutorProfile);

    List<BookingRequest> findAllByStudent_UserId(Long userId);

    List<BookingRequest> findAllByStudent(User student);

}
