package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/* PaymentFactoryTest.java
   PaymentFactoryTest class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date:  24 August 2026
*/
class PaymentFactoryTest {

    TutoringSession session = new TutoringSession.Builder().build();

    BigDecimal amount = new BigDecimal("3750.00");
    BigDecimal tutorEarnings = new BigDecimal("25000.00");
    BigDecimal platformFee = new BigDecimal("21250.00");
    PaymentStatus status = PaymentStatus.PENDING;
    LocalDateTime paidAt = LocalDateTime.now();
    PaymentMethod paymentMethod = PaymentMethod.PAYPAL;

    private Payment payment = PaymentFactory.createPayment(session,
            amount,
            tutorEarnings,
            platformFee,
            status,
            paidAt,
            paymentMethod);

    @Test
    void createPayment() {
        System.out.println(payment);
    }
}