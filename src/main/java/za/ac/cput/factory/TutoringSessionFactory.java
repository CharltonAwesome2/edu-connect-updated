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

    public TutoringSession createTutoringSession(
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
                status == null ||
                HelperUtil.isNullOrEmpty(sessionNotes)) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return new TutoringSession.Builder()
                .setSessionId(id)
                .setStudent(student)
                .setTutorProfile(tutorProfile)
                .setSubject(subject)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setStatus(status)
                .setSessionNotes(sessionNotes)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .build();
    }
}