package za.ac.cput.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    boolean existsByPayment(Payment payment);

    List<Invoice> findAllByIssuedDateBetween(LocalDateTime start, LocalDateTime end);

    List<Invoice> findAllByDueDateBefore(LocalDateTime date);

    @Query ("SELECT COALESCE(MAX(i.invoiceNumber), '') FROM Invoice i " +
           "WHERE i.invoiceNumber LIKE CONCAT(:prefix, '%')")
    String findMaxInvoiceNumberByPrefix(@Param ("prefix") String prefix);

    List<Invoice> findAllByPayment_Session_Student_UserId(Long userId);
}