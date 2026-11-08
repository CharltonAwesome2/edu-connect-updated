package za.ac.cput.dto.frontend;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;

public record PaymentResponse(
        Long paymentId,
        BigDecimal amount,
        BigDecimal tutorEarnings,
        BigDecimal platformFee,
        PaymentStatus status,
        PaymentMethod paymentMethod,
        LocalDateTime paidAt) {
}
