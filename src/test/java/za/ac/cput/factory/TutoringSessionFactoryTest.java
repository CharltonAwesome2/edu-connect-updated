package za.ac.cput.factory;

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
    LocalDateTime endTime = LocalDateTime.now();
    SessionStatus status = SessionStatus.SCHEDULED;
    String sessionNote = "Session scheduled";
    LocalDateTime createdAt = LocalDateTime.now();
    LocalDateTime updatedAt = LocalDateTime.now();

    private TutoringSession tutoringSession = TutoringSessionFactory.createTutoringSession(bookingRequest,
            student,
            tutorProfile,
            subject,
            startTime,
            endTime,
            status,
            sessionNote,
            createdAt,
            updatedAt);

    @Test
    void createTutoringSession() {
        System.out.println(tutoringSession);
    }

}