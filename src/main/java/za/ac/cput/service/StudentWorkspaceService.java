/*
    StudentWorkspaceService.java
    Student Workspace Service class
    Author: Nolwazi Zulu (220118876)
    Date: 10 November 2026
*/

package za.ac.cput.service;

import org.springframework.stereotype.Service;

import za.ac.cput.domain.User;
import za.ac.cput.dto.StudentWorkspaceResponseDTO;

import za.ac.cput.service.IService.IUserService;
import za.ac.cput.service.IService.IBookingRequestService;
import za.ac.cput.service.IService.ITutoringSessionService;
import za.ac.cput.service.IService.INotificationService;
import za.ac.cput.service.IService.IPaymentService;
import za.ac.cput.service.IService.IInvoiceService;
import za.ac.cput.service.IService.ITutorReviewService;

@Service
public class StudentWorkspaceService {

    private final IUserService userService;
    private final IBookingRequestService bookingRequestService;
    private final ITutoringSessionService tutoringSessionService;
    private final INotificationService notificationService;
    private final IPaymentService paymentService;
    private final IInvoiceService invoiceService;
    private final ITutorReviewService tutorReviewService;

    public StudentWorkspaceService(
            IUserService userService,
            IBookingRequestService bookingRequestService,
            ITutoringSessionService tutoringSessionService,
            INotificationService notificationService,
            IPaymentService paymentService,
            IInvoiceService invoiceService,
            ITutorReviewService tutorReviewService) {

        this.userService = userService;
        this.bookingRequestService = bookingRequestService;
        this.tutoringSessionService = tutoringSessionService;
        this.notificationService = notificationService;
        this.paymentService = paymentService;
        this.invoiceService = invoiceService;
        this.tutorReviewService = tutorReviewService;
    }

    public StudentWorkspaceResponseDTO getStudentWorkspace(Long studentId) {

        User student = userService.read(studentId);

        if (student == null || !Boolean.TRUE.equals(student.getIsStudent())) {
            return null;
        }

        return StudentWorkspaceResponseDTO.builder()
                .student(student)
                .bookingRequests(bookingRequestService.getAllByStudentId(studentId))
                .tutoringSessions(tutoringSessionService.findByStudentId(studentId))
                .notifications(notificationService.getAllByUserId(studentId))
                .unreadNotificationCount(notificationService.countUnreadByUserId(studentId))
                .payments(paymentService.getAllByStudentId(studentId))
                .invoices(invoiceService.getAllByStudentId(studentId))
                .tutorReviews(tutorReviewService.getAllByStudentId(studentId))
                .build();
    }
}
