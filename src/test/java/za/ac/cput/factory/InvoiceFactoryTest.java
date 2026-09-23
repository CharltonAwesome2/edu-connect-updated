package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/* InvoiceFactoryTest.java
   InvoiceFactoryTest class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date:  22 August 2026
*/

class InvoiceFactoryTest {

    Payment payment = new Payment.Builder().build();
    LocalDateTime issuedDate = LocalDateTime.now();
    String invoiceNumber = "INV-001";
    LocalDateTime dueDate = LocalDateTime.now().plusDays(30);
    BigDecimal totalAmount = new BigDecimal("25000.00");
    BigDecimal taxAmount = new BigDecimal("3750.00");

    private Invoice invoice = InvoiceFactory.createInvoice(payment,
            invoiceNumber,
            issuedDate,
            dueDate,
            totalAmount,
            taxAmount);

    @Test
    void createInvoice() {
        System.out.println(invoice);
    }
}