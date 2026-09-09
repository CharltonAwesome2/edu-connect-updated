package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;
import za.ac.cput.util.HelperUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/* PaymentFactory.java
    PaymentFactory class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

public class PaymentFactory {
    public static Payment createPayment(TutoringSession session, BigDecimal amount, BigDecimal tutorEarnings,
            BigDecimal platformFee, PaymentStatus status, LocalDateTime paidAt, PaymentMethod paymentMethod) {

        Long paymentId = HelperUtil.generateId();
        if (session == null
                || amount == null
                || tutorEarnings == null
                || platformFee == null
                || status == null
                || paidAt == null
                || paymentMethod == null) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setSession(session)
                .setAmount(amount)
                .setTutorEarnings(tutorEarnings)
                .setPlatformFee(platformFee)
                .setStatus(status)
                .setPaidAt(paidAt)
                .setPaymentMethod(paymentMethod)
                .build();
    }
}
