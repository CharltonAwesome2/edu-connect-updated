package za.ac.cput.factory;

import java.time.LocalDateTime;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.enums.BookingStatus;
import za.ac.cput.util.HelperUtil;

public class BookingRequestFactory {

    public static BookingRequest createBookingRequest(
            LocalDateTime requestedStartTime,
            int durationMinutes,
            BookingStatus status,
            User student,
            TutorProfile tutorProfile,
            Subject subject,
            String studentNotes) {

        if (status == null |
                student == null ||
                tutorProfile == null ||
                subject == null ||
                HelperUtil.isNullOrEmpty(studentNotes)) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return new BookingRequest.Builder()
                .setRequestId(id)
                .setDurationMinutes(durationMinutes)
                .setStatus(status)
                .setStudent(student)
                .setTutorProfile(tutorProfile)
                .setSubject(subject)
                .setStudentNotes(studentNotes)
                .build();
    }
}