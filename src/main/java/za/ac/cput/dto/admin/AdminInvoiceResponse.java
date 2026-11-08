package za.ac.cput.dto.admin;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AdminInvoiceResponse(
        Long invoiceId,
        String invoiceNumber,
        LocalDateTime issuedDate,
        LocalDateTime dueDate,
        BigDecimal totalAmount,
        BigDecimal taxAmount) {
}
