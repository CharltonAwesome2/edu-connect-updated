package za.ac.cput.factory;

import za.ac.cput.domain.Invoice;
import za.ac.cput.util.HelperUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/* InvoiceFactory.java
    InvoiceFactory class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

public class InvoiceFactory {
    public static Invoice createInvoice(Long paymentId,
                                        String invoiceNumber,
                                        LocalDateTime issuedDate,
                                        LocalDateTime dueDate,
                                        BigDecimal totalAmount,
                                        BigDecimal taxAmount){

        Long invoiceId = HelperUtil.generateId();
        if (paymentId == null
                || invoiceNumber == null
                || issuedDate == null
                || dueDate == null
                || totalAmount == null
                || taxAmount == null) {
            return null;
        }

        return new Invoice.Builder()
                .setPaymentId(paymentId)
                .setInvoiceNumber(invoiceNumber)
                .setIssuedDate(issuedDate)
                .setDueDate(dueDate)
                .setTotalAmount(totalAmount)
                .setTaxAmount(taxAmount)
                .build();

    }
}
