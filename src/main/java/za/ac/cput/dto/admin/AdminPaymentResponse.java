package za.ac.cput.dto.admin;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;

public record AdminPaymentResponse(
        Long paymentId,
        BigDecimal amount,
        BigDecimal tutorEarnings,
        BigDecimal platformFee,
        PaymentStatus status,
        PaymentMethod paymentMethod,
        LocalDateTime paidAt) {
}
