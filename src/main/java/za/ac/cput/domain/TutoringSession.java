package za.ac.cput.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
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
@Entity
@Table(name = "tutoring_session")
public class TutoringSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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