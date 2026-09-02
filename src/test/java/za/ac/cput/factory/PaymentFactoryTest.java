package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/* PaymentFactoryTest.java
   PaymentFactoryTest class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date:  24 August 2026
*/
class PaymentFactoryTest {


    private Payment payment = PaymentFactory.createPayment(
            1L,
            new BigDecimal("25000.00"),
            new BigDecimal("21250.00"),
            new BigDecimal("3750.00"),
            PaymentStatus.PENDING,
            LocalDateTime.now(),
            PaymentMethod.PAYPAL
    );
    @Test
    void createPayment() {
        System.out.println(payment);
    }
}