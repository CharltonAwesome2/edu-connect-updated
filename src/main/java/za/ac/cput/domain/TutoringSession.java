package za.ac.cput.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import za.ac.cput.enums.SessionStatus;

/**
 * TutoringSession.java
 * TutoringSession model class
 * Author: Esaile Siani Djiakeng
 * Date: 30 July 2026
 */

@Data 
@Builder
public class TutoringSession {

    private Long tutoringSessionId;
    private BookingRequest bookingRequest;
    private User student;
    private TutorProfile tutorProfile;
    private Subject subject;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private SessionStatus status;
    private String sessionNotes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}