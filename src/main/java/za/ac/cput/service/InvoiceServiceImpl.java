package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.InvoiceRepository;
import za.ac.cput.service.IService.IInvoiceService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/* InvoiceServiceImpl.java
    InvoiceServiceImpl class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/

@Service
public class InvoiceServiceImpl implements IInvoiceService {

    private static final int DUE_DAYS = 7;

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice create(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice read(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public Invoice update(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getByInvoiceNumber(String invoiceNumber) {
        return invoiceRepository.findByInvoiceNumber(invoiceNumber).orElse(null);
    }

    @Override
    public boolean existsByInvoiceNumber(String invoiceNumber) {
        return invoiceRepository.existsByInvoiceNumber(invoiceNumber);
    }

    @Override
    public Invoice getByPayment(Payment payment) {
        return invoiceRepository.findByPayment(payment).orElse(null);
    }

    @Override
    public List<Invoice> getAllByIssuedDateBetween(LocalDateTime start, LocalDateTime end) {
        return invoiceRepository.findAllByIssuedDateBetween(start, end);
    }

    @Override
    public List<Invoice> getAllDueBefore(LocalDateTime date) {
        return invoiceRepository.findAllByDueDateBefore(date);
    }

    @Override
    @Transactional
    public Invoice createForPayment(Payment payment) {
        if (payment == null || payment.getPaymentId() == null)
            return null;

        // Idempotent — return existing invoice if one already exists for this payment
        return invoiceRepository.findByPayment(payment).orElseGet(() -> {
            BigDecimal subtotal = payment.getAmount() != null
                    ? payment.getAmount().setScale(2, RoundingMode.HALF_UP)
                    : BigDecimal.ZERO.setScale(2);
            BigDecimal tax = BigDecimal.ZERO.setScale(2);
            BigDecimal total = subtotal.add(tax).setScale(2, RoundingMode.HALF_UP);

            LocalDateTime issued = LocalDateTime.now();
            LocalDateTime due = issued.plusDays(DUE_DAYS);

            Invoice invoice = Invoice.builder()
                    .payment(payment)
                    .invoiceNumber(nextInvoiceNumber())
                    .issuedDate(issued)
                    .dueDate(due)
                    .taxAmount(tax)
                    .totalAmount(total)
                    .build();

            return invoiceRepository.save(invoice);
        });
    }

    private String nextInvoiceNumber() {
        String year = String.valueOf(LocalDate.now().getYear());
        String prefix = "INV-" + year + "-";
        String max = invoiceRepository.findMaxInvoiceNumberByPrefix(prefix);
        int seq = 1;
        if (max != null && max.startsWith(prefix)) {
            try {
                seq = Integer.parseInt(max.substring(prefix.length())) + 1;
            } catch (NumberFormatException ignored) {
                /* keep seq = 1 */ }
        }
        return String.format("%s%06d", prefix, seq);
    }

    @Override
    public List<Invoice> getAllByStudentId(Long userId) {
        return invoiceRepository.findAllByPayment_Session_Student_UserId(userId);
    }
}