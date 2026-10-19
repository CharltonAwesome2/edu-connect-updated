package za.ac.cput.domain;

import za.ac.cput.enums.BookingStatus;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

// BookingRequest.java
// Booking Request model class
// Author: Reotshepile Stock (230875807)
// Date: 23 July 2026

@Data 
@Builder
public class BookingRequest {

    private Long bookingRequestId;
    private LocalDateTime requestedStartTime;
    private int durationMinutes;
    private BookingStatus status;
    private User student;
    private TutorProfile tutorProfile;
    private Subject subject;
    private String studentNotes;

}
