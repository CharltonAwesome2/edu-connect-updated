package za.ac.cput.domain;

import za.ac.cput.enums.BookingStatus;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

// BookingRequest.java
// Booking Request model class
// Author: Reotshepile Stock (230875807)
// Date: 23 July 2026

@Data
@Builder
@Entity
@Table(name = "booking_requests")
public class BookingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingRequestId;

    private LocalDateTime requestedStartTime;
    private int durationMinutes;
    private BookingStatus status;
    private User student;
    private TutorProfile tutorProfile;
    private Subject subject;
    private String studentNotes;

}
