package za.ac.cput.service.IService;

import java.time.LocalDateTime;
import java.util.List;

import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Payment;


/* IInvoiceService.java
    IInvoiceService interface
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/


public interface IInvoiceService extends service<Invoice, Long> {

    Invoice getByInvoiceNumber(String invoiceNumber);

    boolean existsByInvoiceNumber(String invoiceNumber);

    Invoice getByPayment(Payment payment);

    List<Invoice> getAllByIssuedDateBetween(LocalDateTime start, LocalDateTime end);

    List<Invoice> getAllDueBefore(LocalDateTime date);

    Invoice createForPayment(Payment payment);

    List<Invoice> getAllByStudentId(Long userId);
}