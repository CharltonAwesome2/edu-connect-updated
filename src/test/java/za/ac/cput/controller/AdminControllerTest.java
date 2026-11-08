package za.ac.cput.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.User;
import za.ac.cput.dto.auth.AccountType;
import za.ac.cput.dto.auth.AuthResponse;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.repository.InvoiceRepository;
import za.ac.cput.repository.PaymentRepository;
import za.ac.cput.repository.ReportRepository;
import za.ac.cput.service.IAuthService;

class AdminControllerTest {

    private IAuthService authService;
    private UserRepository userRepository;
    private InvoiceRepository invoiceRepository;
    private PaymentRepository paymentRepository;
    private ReportRepository reportRepository;
    private AdminController controller;

    @BeforeEach
    void setUp() {
        authService = mock(IAuthService.class);
        userRepository = mock(UserRepository.class);
        invoiceRepository = mock(InvoiceRepository.class);
        paymentRepository = mock(PaymentRepository.class);
        reportRepository = mock(ReportRepository.class);
        controller = new AdminController(authService, userRepository, invoiceRepository, paymentRepository, reportRepository);
    }

    @Test
    void adminCanViewUserSummariesWithoutCredentials() {
        HttpSession session = adminSession(9L);
        User user = User.builder()
                .userId(1L)
                .name("Amina")
                .surname("Ndlovu")
                .studentNumber("STU-1001")
                .email("student@example.com")
                .createdAt(LocalDateTime.of(2026, 10, 24, 7, 25))
                .isStudent(true)
                .isTutor(false)
                .build();
        when(authService.findUser(9L)).thenReturn(
                new AuthResponse(9L, "Admin", "User", "admin@example.com", AccountType.ADMIN));
        when(userRepository.findAll()).thenReturn(List.of(user));

        var users = controller.getUsers(session);

        assertEquals(1, users.size());
        assertEquals("Amina", users.get(0).name());
        assertEquals("student@example.com", users.get(0).email());
        assertEquals("STU-1001", users.get(0).studentNumber());
        assertEquals(true, users.get(0).isStudent());
        verify(userRepository).findAll();
    }

    @Test
    void studentCannotViewAllUsers() {
        HttpSession session = adminSession(3L);
        when(authService.findUser(3L)).thenReturn(
                new AuthResponse(3L, "Amina", "Ndlovu", "student@example.com", AccountType.STUDENT));

        ResponseStatusException error = assertThrows(ResponseStatusException.class,
                () -> controller.getUsers(session));

        assertEquals(HttpStatus.FORBIDDEN, error.getStatusCode());
        verifyNoInteractions(userRepository);
    }

    @Test
    void unauthenticatedUserCannotViewUsers() {
        ResponseStatusException error = assertThrows(ResponseStatusException.class,
                () -> controller.getUsers(new MockHttpSession()));

        assertEquals(HttpStatus.UNAUTHORIZED, error.getStatusCode());
        verifyNoInteractions(authService, userRepository);
    }

    private HttpSession adminSession(Long userId) {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("eduConnectUserId", userId);
        return session;
    }
}
