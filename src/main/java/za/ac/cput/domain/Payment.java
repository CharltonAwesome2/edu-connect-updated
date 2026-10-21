package za.ac.cput.domain;

import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
// import java.util.Objects;

import lombok.Builder;
import lombok.Data;

/* Payment.java
    Payment class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

@Data 
@Builder
public class Payment {

    private Long paymentId;
    private TutoringSession session;
    private BigDecimal amount;
    private BigDecimal tutorEarnings;
    private BigDecimal platformFee;
    private PaymentStatus status;
    private LocalDateTime paidAt;
    private PaymentMethod paymentMethod;

}
