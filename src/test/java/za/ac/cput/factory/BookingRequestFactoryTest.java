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

public class BookingRequestFactoryTest {

    LocalDateTime requestedStartTime = LocalDateTime.now();
    int durationMinutes = 90;
    BookingStatus status = BookingStatus.APPROVED;
    User student = User.builder().build();
    TutorProfile tutorProfile = TutorProfile.builder().build();
    Subject subject = Subject.builder().build();
    String studentNotes = "Student note";

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