package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.SessionStatus;

public class TutoringSessionFactoryTest {

    BookingRequest bookingRequest = new BookingRequest.Builder().build();
    User student = new User.Builder().build();
    TutorProfile tutorProfile = new TutorProfile.Builder().build();
    Subject subject = new Subject.Builder().build();
    LocalDateTime startTime = LocalDateTime.now();
    LocalDateTime endTime = LocalDateTime.now().plusMinutes(90);
    SessionStatus status = SessionStatus.SCHEDULED;
    String sessionNote = "Session scheduled";
    LocalDateTime createdAt = LocalDateTime.now();
    LocalDateTime updatedAt = LocalDateTime.now();

    @Test
    void createTutoringSession() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
                student,
                tutorProfile,
                subject,
                startTime,
                endTime,
                status,
                sessionNote,
                createdAt,
                updatedAt);

        assertNotNull(tutoringSession);
        assertNotNull(tutoringSession.getSessionId());

        assertEquals(bookingRequest, tutoringSession.getBookingRequest());
        assertEquals(student, tutoringSession.getStudent());
        assertEquals(tutorProfile, tutoringSession.getTutorProfile());
        assertEquals(subject, tutoringSession.getSubject());
        assertEquals(startTime, tutoringSession.getStartTime());
        assertEquals(endTime, tutoringSession.getEndTime());
        assertEquals(status, tutoringSession.getStatus());
        assertEquals(sessionNote, tutoringSession.getSessionNotes());
        assertEquals(createdAt, tutoringSession.getCreatedAt());
        assertEquals(updatedAt, tutoringSession.getUpdatedAt());
    }

    @Test
    void createTutoringSessionWithNullBookingRequest() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(null,
                student,
                tutorProfile,
                subject,
                startTime,
                endTime,
                status,
                sessionNote,
                createdAt,
                updatedAt);
        assertNull(tutoringSession);

    }

    @Test
    void createTutoringSessionWithNullStudent() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
                null,
                tutorProfile,
                subject,
                startTime,
                endTime,
                status,
                sessionNote,
                createdAt,
                updatedAt);
        assertNull(tutoringSession);

    }

    @Test
    void createTutoringSessionWithNullTutorProfile() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
                student,
                null,
                subject,
                startTime,
                endTime,
                status,
                sessionNote,
                createdAt,
                updatedAt);
        assertNull(tutoringSession);

    }

    @Test
    void createTutoringSessionWithNullSubject() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
                student,
                tutorProfile,
                null,
                startTime,
                endTime,
                status,
                sessionNote,
                createdAt,
                updatedAt);
        assertNull(tutoringSession);

    }

    @Test
    void createTutoringSessionWithNullStartTime() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
                student,
                tutorProfile,
                subject,
                null,
                endTime,
                status,
                sessionNote,
                createdAt,
                updatedAt);
        assertNull(tutoringSession);

    }

    @Test
    void createTutoringSessionWithNullEndTime() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
                student,
                tutorProfile,
                subject,
                startTime,
                null,
                status,
                sessionNote,
                createdAt,
                updatedAt);
        assertNull(tutoringSession);

    }

    @Test
    void createTutoringSessionWithNullStatus() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
                student,
                tutorProfile,
                subject,
                startTime,
                endTime,
                null,
                sessionNote,
                createdAt,
                updatedAt);
        assertNull(tutoringSession);

    }

    @Test
    void createTutoringSessionWithNullSessionNote() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
                student,
                tutorProfile,
                subject,
                startTime,
                endTime,
                status,
                null,
                createdAt,
                updatedAt);
        assertNull(tutoringSession);

    }

    @Test
    void createTutoringSessionWithEmptySessionNote() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
                student,
                tutorProfile,
                subject,
                startTime,
                endTime,
                status,
                "",
                createdAt,
                updatedAt);
        assertNull(tutoringSession);

    }

    @Test
    void createTutoringSessionWithNullCreatedAt() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
                student,
                tutorProfile,
                subject,
                startTime,
                endTime,
                status,
                sessionNote,
                null,
                updatedAt);
        assertNull(tutoringSession);

    }

    @Test
    void createTutoringSessionWithNullUpdatedAt() {
        TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
                student,
                tutorProfile,
                subject,
                startTime,
                endTime,
                status,
                sessionNote,
                createdAt,
                null);
        assertNull(tutoringSession);

    }

}