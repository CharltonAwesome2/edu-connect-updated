package za.ac.cput.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Payment;

/* InvoiceRepository.java
    InvoiceRepository interface
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Optional<Invoice> findByInvoiceNumber(String invoiceNumber);

    boolean existsByInvoiceNumber(String invoiceNumber);

    Optional<Invoice> findByPayment(Payment payment);

    List<Invoice> findAllByIssuedDateBetween(LocalDateTime start, LocalDateTime end);

    List<Invoice> findAllByDueDateBefore(LocalDateTime date);
}
