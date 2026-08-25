package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Invoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/* InvoiceFactoryTest.java
   InvoiceFactoryTest class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date:  22 August 2026
*/

class InvoiceFactoryTest {

    private Invoice invoice = InvoiceFactory.createInvoice(
            1L,
            "INV-001",
            LocalDateTime.now(),
            LocalDateTime.now().plusDays(30),
            new BigDecimal("25000.00"),
            new BigDecimal("3750.00")


    );

    @Test
    void createInvoice() {
        System.out.println(invoice);
    }
}