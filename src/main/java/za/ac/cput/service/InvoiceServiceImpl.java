package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.InvoiceRepository;

import java.time.LocalDateTime;
import java.util.List;

/* InvoiceServiceImpl.java
    InvoiceServiceImpl class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/

@Service
public class InvoiceServiceImpl implements IInvoiceService {

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
}