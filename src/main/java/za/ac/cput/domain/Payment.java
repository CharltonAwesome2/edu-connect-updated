package za.ac.cput.domain;

import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
// import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* Payment.java
    Payment class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

@Entity
@Table(name = "payment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    @NotNull
    private TutoringSession session;

    @Column(name = "amount", nullable = false)
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal amount;

    @Column(name = "tutor_earnings", nullable = false)
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal tutorEarnings;

    @Column(name = "platform_fee", nullable = false)
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal platformFee;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @NotNull
    private PaymentStatus status;

    @Column(name = "paid_at", nullable = false)
    @NotNull
    private LocalDateTime paidAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    @NotNull
    private PaymentMethod paymentMethod;

}
