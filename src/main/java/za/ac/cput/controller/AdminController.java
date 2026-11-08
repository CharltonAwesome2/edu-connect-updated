package za.ac.cput.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.User;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Report;
import za.ac.cput.dto.admin.AdminInvoiceResponse;
import za.ac.cput.dto.admin.AdminPaymentResponse;
import za.ac.cput.dto.admin.AdminReportResponse;
import za.ac.cput.dto.admin.AdminUserResponse;
import za.ac.cput.dto.auth.AuthResponse;
import za.ac.cput.dto.auth.AccountType;
import za.ac.cput.service.IAuthService;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.repository.InvoiceRepository;
import za.ac.cput.repository.PaymentRepository;
import za.ac.cput.repository.ReportRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private static final String SESSION_USER_ID = "eduConnectUserId";

    private final IAuthService authService;
    private final UserRepository userRepository;
    private final InvoiceRepository invoiceRepository;
    private final PaymentRepository paymentRepository;
    private final ReportRepository reportRepository;

    @Autowired
    public AdminController(
            IAuthService authService,
            UserRepository userRepository,
            InvoiceRepository invoiceRepository,
            PaymentRepository paymentRepository,
            ReportRepository reportRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.invoiceRepository = invoiceRepository;
        this.paymentRepository = paymentRepository;
        this.reportRepository = reportRepository;
    }

    @GetMapping("/users")
    public List<AdminUserResponse> getUsers(HttpSession session) {
        requireAdmin(session);

        return userRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/payments")
    public List<AdminPaymentResponse> getPayments(HttpSession session) {
        requireAdmin(session);
        return paymentRepository.findAll().stream().map(this::toPaymentResponse).toList();
    }

    @GetMapping("/invoices")
    public List<AdminInvoiceResponse> getInvoices(HttpSession session) {
        requireAdmin(session);
        return invoiceRepository.findAll().stream().map(this::toInvoiceResponse).toList();
    }

    @GetMapping("/reports")
    public List<AdminReportResponse> getReports(HttpSession session) {
        requireAdmin(session);
        return reportRepository.findAllByOrderByReportAtDesc().stream().map(this::toReportResponse).toList();
    }

    private void requireAdmin(HttpSession session) {
        Object userId = session.getAttribute(SESSION_USER_ID);
        if (!(userId instanceof Long id)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Please log in.");
        }

        AuthResponse currentUser = authService.findUser(id);
        if (currentUser.accountType() != AccountType.ADMIN) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Admin access is required.");
        }
    }

    private AdminPaymentResponse toPaymentResponse(Payment payment) {
        return new AdminPaymentResponse(
                payment.getPaymentId(),
                payment.getAmount(),
                payment.getTutorEarnings(),
                payment.getPlatformFee(),
                payment.getStatus(),
                payment.getPaymentMethod(),
                payment.getPaidAt());
    }

    private AdminInvoiceResponse toInvoiceResponse(Invoice invoice) {
        return new AdminInvoiceResponse(
                invoice.getInvoiceId(),
                invoice.getInvoiceNumber(),
                invoice.getIssuedDate(),
                invoice.getDueDate(),
                invoice.getTotalAmount(),
                invoice.getTaxAmount());
    }

    private AdminReportResponse toReportResponse(Report report) {
        return new AdminReportResponse(
                report.getReportId(),
                report.getReporter() == null ? null : report.getReporter().getUserId(),
                report.getReportedUser() == null ? null : report.getReportedUser().getUserId(),
                report.getStatus(),
                report.getDescription(),
                report.getReportAt(),
                report.getResolvedAt());
    }

    private AdminUserResponse toResponse(User user) {
        return new AdminUserResponse(
                user.getUserId(),
                user.getName(),
                user.getSurname(),
                user.getStudentNumber(),
                user.getEmail(),
                user.getCreatedAt(),
                Boolean.TRUE.equals(user.getIsTutor()),
                Boolean.TRUE.equals(user.getIsStudent()));
    }
}
