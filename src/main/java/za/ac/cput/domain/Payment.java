package za.ac.cput.domain;

import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
// import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

/* Payment.java
    Payment class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

@Data 
@Builder
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private TutoringSession session;
    private BigDecimal amount;
    private BigDecimal tutorEarnings;
    private BigDecimal platformFee;
    private PaymentStatus status;
    private LocalDateTime paidAt;
    private PaymentMethod paymentMethod;

}
