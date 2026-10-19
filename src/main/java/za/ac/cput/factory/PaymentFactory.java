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
    public static Payment createPayment(TutoringSession session,
            BigDecimal amount,
            BigDecimal tutorEarnings,
            BigDecimal platformFee,
            PaymentStatus status,
            LocalDateTime paidAt,
            PaymentMethod paymentMethod) {

        Long paymentId = HelperUtil.generateId();
        if (session == null
                || !HelperUtil.isZeroOrPositiveBigDecimal(amount)
                || !HelperUtil.isZeroOrPositiveBigDecimal(tutorEarnings)
                || !HelperUtil.isZeroOrPositiveBigDecimal(platformFee)
                || status == null
                || paidAt == null
                || paymentMethod == null) {
            return null;
        }

        return Payment.builder()
                .paymentId(paymentId)
                .session(session)
                .amount(amount)
                .tutorEarnings(tutorEarnings)
                .platformFee(platformFee)
                .status(status)
                .paidAt(paidAt)
                .paymentMethod(paymentMethod)
                .build();
    }
}
