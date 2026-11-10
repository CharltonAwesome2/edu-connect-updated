/*
    StudentWorkspaceResponseDTO.java
    Student Workspace Response DTO class
    Author: Nolwazi Zulu (220118876)
    Date: 10 November 2026
*/
package za.ac.cput.dto;

import java.util.List;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentWorkspaceResponseDTO {

    private User student;

    private List<BookingRequest> bookingRequests;

    private List<TutoringSession> tutoringSessions;

    private List<Notification> notifications;

    private long unreadNotificationCount;

    private List<Payment> payments;

    private List<Invoice> invoices;

    private List<TutorReview> tutorReviews;
}
