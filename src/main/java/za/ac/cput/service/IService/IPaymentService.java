package za.ac.cput.service.IService;

import za.ac.cput.domain.Payment;

/* IPaymentService.java
    IPaymentService interface
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/

import java.time.LocalDateTime;
import java.util.List;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;

public interface IPaymentService extends service<Payment, Long> {

    Payment getBySession(TutoringSession session);

    Payment getByTransactionReference(String transactionReference);

    boolean existsByTransactionReference(String transactionReference);

    List<Payment> getAllByStatus(PaymentStatus status);

    List<Payment> getAllByPaymentMethod(PaymentMethod paymentMethod);

    List<Payment> getAllByPaidAtBetween(LocalDateTime start, LocalDateTime end);

    Payment updateStatus(Long id, PaymentStatus status);
}
