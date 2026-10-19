package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Payment;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void createInvoice() {
        Invoice invoice = InvoiceFactory.createInvoice(payment,
                invoiceNumber,
                issuedDate,
                dueDate,
                totalAmount,
                taxAmount);

        assertNotNull(invoice);
        assertNotNull(invoice.getInvoiceId());

        assertEquals(payment, invoice.getPayment());
        assertEquals(issuedDate, invoice.getIssuedDate());
        assertEquals(invoiceNumber, invoice.getInvoiceNumber());
        assertEquals(dueDate, invoice.getDueDate());
        assertEquals(totalAmount, invoice.getTotalAmount());
        assertEquals(taxAmount, invoice.getTaxAmount());
    }

    

    
    @Test
    void createInvoiceWithNullPayment() {
        Invoice invoice = InvoiceFactory.createInvoice(null,
                invoiceNumber,
                issuedDate,
                dueDate,
                totalAmount,
                taxAmount);

        assertNull(invoice);
    }

       @Test
    void createInvoiceWithNullIssuedDate() {
        Invoice invoice = InvoiceFactory.createInvoice(payment,
                invoiceNumber,
                null,
                dueDate,
                totalAmount,
                taxAmount);

        assertNull(invoice);
    }

       @Test
    void createInvoiceWithNullInvoiceNumber() {
        Invoice invoice = InvoiceFactory.createInvoice(payment,
                null,
                issuedDate,
                dueDate,
                totalAmount,
                taxAmount);

        assertNull(invoice);
    }

       @Test
    void createInvoiceWithNullDueDate() {
        Invoice invoice = InvoiceFactory.createInvoice(payment,
                invoiceNumber,
                issuedDate,
                null,
                totalAmount,
                taxAmount);

        assertNull(invoice);
    }

       @Test
    void createInvoiceWithNullTotalAmount() {
        Invoice invoice = InvoiceFactory.createInvoice(payment,
                invoiceNumber,
                issuedDate,
                dueDate,
                null,
                taxAmount);

        assertNull(invoice);
    }

       @Test
    void createInvoiceWithNulltaxAmount() {
        Invoice invoice = InvoiceFactory.createInvoice(payment,
                invoiceNumber,
                issuedDate,
                dueDate,
                totalAmount,
                null);

        assertNull(invoice);
    }
}