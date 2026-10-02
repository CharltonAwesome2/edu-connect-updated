/*
    BookingRequestFactoryTest.java
    Booking Request Factory Test class
    Author: Reotshepile Stock
    Date: 02 October 2026
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.enums.BookingStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingRequestFactoryTest {

    LocalDateTime requestedStartTime = LocalDateTime.now();
    int durationMinutes = 60;
    BookingStatus status = BookingStatus.PENDING;

    User student = new User.Builder()
            .setUserId(1L)
            .setName("Reotshepile")
            .setSurname("Stock")
            .setStudentNumber("230875807")
            .setEmail("reotshepile@example.com")
            .setContactNumber("0712345678")
            .setCreatedAt(LocalDateTime.now())
            .setIsTutor(false)
            .setIsStudent(true)
            .build();

    TutorProfile tutorProfile = new TutorProfile.Builder()
            .setTutorId(2L)
            .setUser(student)
            .build();

    Subject subject = new Subject.Builder()
            .setSubjectId(3L)
            .setSubjectName("Software Development")
            .setDepartment("ICT")
            .build();

    String studentNotes = "I need help with Java.";

    @Test
    void createBookingRequest() {

        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(
                requestedStartTime,
                durationMinutes,
                status,
                student,
                tutorProfile,
                subject,
                studentNotes);

        assertNotNull(bookingRequest);
        assertNotNull(bookingRequest.getRequestId());
        assertEquals(durationMinutes, bookingRequest.getDurationMinutes());
        assertEquals(status, bookingRequest.getStatus());
        assertEquals(student, bookingRequest.getStudent());
        assertEquals(tutorProfile, bookingRequest.getTutorProfile());
        assertEquals(subject, bookingRequest.getSubject());
        assertEquals(studentNotes, bookingRequest.getStudentNotes());
    }

    @Test
    void createBookingRequestWithNullStatus() {

        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(
                requestedStartTime,
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

        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(
                requestedStartTime,
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

        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(
                requestedStartTime,
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

        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(
                requestedStartTime,
                durationMinutes,
                status,
                student,
                tutorProfile,
                null,
                studentNotes);

        assertNull(bookingRequest);
    }

    @Test
    void createBookingRequestWithNullStudentNotes() {

        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(
                requestedStartTime,
                durationMinutes,
                status,
                student,
                tutorProfile,
                subject,
                null);

        assertNull(bookingRequest);
    }

    @Test
    void createBookingRequestWithEmptyStudentNotes() {

        BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(
                requestedStartTime,
                durationMinutes,
                status,
                student,
                tutorProfile,
                subject,
                "");

        assertNull(bookingRequest);
    }
}
```
