package za.ac.cput.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;

/* PaymentRepository.java
    PaymentRepository interface
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findBySession(TutoringSession session);

    Optional<Payment> findByTransactionReference(String transactionReference);

    boolean existsByTransactionReference(String transactionReference);

    List<Payment> findAllByStatus(PaymentStatus status);

    List<Payment> findAllByPaymentMethod(PaymentMethod paymentMethod);

    List<Payment> findAllByPaidAtBetween(LocalDateTime start, LocalDateTime end);
}
