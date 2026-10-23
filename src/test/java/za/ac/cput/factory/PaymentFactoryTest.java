package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/* PaymentFactoryTest.java
   PaymentFactoryTest class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date:  24 August 2026
*/
class PaymentFactoryTest {

    TutoringSession session = TutoringSession.builder().build();

    BigDecimal amount = new BigDecimal("3750.00");
    BigDecimal tutorEarnings = new BigDecimal("25000.00");
    BigDecimal platformFee = new BigDecimal("21250.00");
    PaymentStatus status = PaymentStatus.PENDING;
    LocalDateTime paidAt = LocalDateTime.now();
    PaymentMethod paymentMethod = PaymentMethod.PAYPAL;
    String transactionReference = "PAY-01";

    @Test
    void createPayment() {
        Payment payment = PaymentFactory.createPayment(session,
                amount,
                tutorEarnings,
                platformFee,
                status,
                paidAt,
                paymentMethod,
                transactionReference);

        assertNotNull(payment);
        assertNotNull(payment.getPaymentId());

        assertEquals(amount, payment.getAmount());
        assertEquals(tutorEarnings, payment.getTutorEarnings());
        assertEquals(status, payment.getStatus());
        assertEquals(paidAt, payment.getPaidAt());
        assertEquals(paymentMethod, payment.getPaymentMethod());
        assertEquals(transactionReference, payment.getTransactionReference());
    }

    @Test
    void createPaymentWithNullSession() {
        Payment payment = PaymentFactory.createPayment(null,
                amount,
                tutorEarnings,
                platformFee,
                status,
                paidAt,
                paymentMethod,
                transactionReference);

        assertNull(payment);

    }

    @Test
    void createPaymentWithNullAmount() {
        Payment payment = PaymentFactory.createPayment(session,
                null,
                tutorEarnings,
                platformFee,
                status,
                paidAt,
                paymentMethod,
                transactionReference);

        assertNull(payment);

    }

    @Test
    void createPaymentWithNullTutorEarnings() {
        Payment payment = PaymentFactory.createPayment(session,
                amount,
                null,
                platformFee,
                status,
                paidAt,
                paymentMethod,
                transactionReference);

        assertNull(payment);

    }

    @Test
    void createPaymentWithNullPlatformFee() {
        Payment payment = PaymentFactory.createPayment(session,
                amount,
                tutorEarnings,
                null,
                status,
                paidAt,
                paymentMethod,
                transactionReference);

        assertNull(payment);

    }

    @Test
    void createPaymentWithNullStatus() {
        Payment payment = PaymentFactory.createPayment(session,
                amount,
                tutorEarnings,
                platformFee,
                null,
                paidAt,
                paymentMethod,
                transactionReference);

        assertNull(payment);

    }

    @Test
    void createPaymentWithNullPaidAt() {
        Payment payment = PaymentFactory.createPayment(session,
                amount,
                tutorEarnings,
                platformFee,
                status,
                null,
                paymentMethod,
                transactionReference);

        assertNull(payment);

    }

    @Test
    void createPaymentWithNullPaymentMethod() {
        Payment payment = PaymentFactory.createPayment(session,
                amount,
                tutorEarnings,
                platformFee,
                status,
                paidAt,
                null,
                transactionReference);

        assertNull(payment);

    }

    @Test
    void createPaymentWithNullTransactionReference() {
        Payment payment = PaymentFactory.createPayment(session,
                amount,
                tutorEarnings,
                platformFee,
                status,
                paidAt,
                paymentMethod,
                null);

        assertNull(payment);

    }

    @Test
    void createPaymentWithEmptyTransactionReference() {
        Payment payment = PaymentFactory.createPayment(session,
                amount,
                tutorEarnings,
                platformFee,
                status,
                paidAt,
                paymentMethod,
                "");

        assertNull(payment);

    }
}