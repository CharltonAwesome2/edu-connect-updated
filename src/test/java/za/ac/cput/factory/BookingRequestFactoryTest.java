/*
    BookingRequestFactoryTest.java
    Booking Request Factory Test class
    Author: Reotshepile Stock
    Date: 02 October 2026
*/
package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.enums.BookingStatus;

class BookingRequestFactoryTest {

    LocalDateTime requestedStartTime = LocalDateTime.now();
    int durationMinutes = 90;
    BookingStatus status = BookingStatus.APPROVED;

    User student = User.builder()
            .userId(1L)
            .name("Reotshepile")
            .surname("Stock")
            .studentNumber("230875807")
            .email("reotshepile@example.com")
            .contactNumber("0712345678")
            .createdAt(LocalDateTime.now())
            .isTutor(false)
            .isStudent(true)
            .build();

    TutorProfile tutorProfile = TutorProfile.builder()
            .tutorProfileId(2L)
            .user(student)
            .build();

    Subject subject = Subject.builder()
            .subjectId(3L)
            .subjectName("Software Development")
            .department("ICT")
            .build();
            
    String studentNotes = "I need help with Java.";

    @Test
    void createBookingRequest() {
        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(requestedStartTime,
                durationMinutes,
                status,
                student,
                tutorProfile,
                subject,
                studentNotes);

        assertNotNull(bookingRequest);
        assertNotNull(bookingRequest.getBookingRequestId());

        assertEquals(requestedStartTime, bookingRequest.getRequestedStartTime());
        assertEquals(durationMinutes, bookingRequest.getDurationMinutes());
        assertEquals(status, bookingRequest.getStatus());
        assertEquals(student, bookingRequest.getStudent());
        assertEquals(tutorProfile, bookingRequest.getTutorProfile());
        assertEquals(subject, bookingRequest.getSubject());
        assertEquals(studentNotes, bookingRequest.getStudentNotes());
    }

    @Test
    void createBookingRequestWithNullStartTime() {
        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(null,
                durationMinutes,
                status,
                student,
                tutorProfile,
                subject,
                studentNotes);

        assertNull(bookingRequest);
    }

    @Test
    void createBookingRequestWithNegativeDuration() {
        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(requestedStartTime,
                -1,
                status,
                student,
                tutorProfile,
                subject,
                studentNotes);
        assertNull(bookingRequest);

    }

    @Test
    void createBookingRequestWithNullStatus() {
        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(requestedStartTime,
                durationMinutes,
                null,
                student,
                tutorProfile,
                subject,
                studentNotes);
        assertNull(bookingRequest);

    }

    @Test
    void createBookingRequestWithNullStudent() {
        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(requestedStartTime,
                durationMinutes,
                status,
                null,
                tutorProfile,
                subject,
                studentNotes);
        assertNull(bookingRequest);

    }

    @Test
    void createBookingRequestWithNullTutorProfile() {
        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(requestedStartTime,
                durationMinutes,
                status,
                student,
                null,
                subject,
                studentNotes);
        assertNull(bookingRequest);

    }

    @Test
    void createBookingRequestWithNullSubject() {

        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(requestedStartTime,
                durationMinutes,
                status,
                student,
                tutorProfile,
                null,
                studentNotes);
        assertNull(bookingRequest);

    }
}
