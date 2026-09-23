package za.ac.cput.factory;

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
    User student = new User.Builder().build();
    TutorProfile tutorProfile = new TutorProfile.Builder().build();
    Subject subject = new Subject.Builder().build();
    String studentNotes = "Student note";

    private BookingRequest bookingRequest = BookingRequestFactory.createBookingRequest(requestedStartTime,
            durationMinutes,
            status,
            student,
            tutorProfile,
            subject,
            studentNotes);

    @Test
    void createBookingRequest() {
        System.out.println(bookingRequest);
    }
}