package za.ac.cput.factory;

import java.time.LocalDateTime;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.SessionStatus;
import za.ac.cput.util.HelperUtil;

public class TutoringSessionFactory {

    public static TutoringSession createTutoringSession(
            BookingRequest bookingRequest,
            User student,
            TutorProfile tutorProfile,
            Subject subject,
            LocalDateTime startTime,
            LocalDateTime endTime,
            SessionStatus status,
            String sessionNotes,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {

        if (bookingRequest == null ||
                student == null ||
                tutorProfile == null ||
                subject == null ||
                startTime == null ||
                endTime == null ||
                status == null ||
                HelperUtil.isNullOrEmpty(sessionNotes) ||
                createdAt == null ||
                updatedAt == null) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return TutoringSession.builder()
                .tutoringSessionId(id)
                .bookingRequest(bookingRequest)
                .student(student)
                .tutorProfile(tutorProfile)
                .subject(subject)
                .startTime(startTime)
                .endTime(endTime)
                .status(status)
                .sessionNotes(sessionNotes)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}