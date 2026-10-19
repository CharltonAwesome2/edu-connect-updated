package za.ac.cput.factory;

import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Payment;
import za.ac.cput.util.HelperUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/* InvoiceFactory.java
    InvoiceFactory class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

public class InvoiceFactory {
    public static Invoice createInvoice(Payment payment,
            String invoiceNumber,
            LocalDateTime issuedDate,
            LocalDateTime dueDate,
            BigDecimal totalAmount,
            BigDecimal taxAmount) {

        Long invoiceId = HelperUtil.generateId();
        if (payment == null
                || HelperUtil.isNullOrEmpty(invoiceNumber)
                || issuedDate == null
                || dueDate == null
                || !HelperUtil.isZeroOrPositiveBigDecimal(totalAmount)
                || !HelperUtil.isZeroOrPositiveBigDecimal(taxAmount)) {
            return null;
        }

        return Invoice.builder()
                .invoiceId(invoiceId)
                .payment(payment)
                .invoiceNumber(invoiceNumber)
                .issuedDate(issuedDate)
                .dueDate(dueDate)
                .totalAmount(totalAmount)
                .taxAmount(taxAmount)
                .build();

    }
}
