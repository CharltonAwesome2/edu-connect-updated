package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.IService.IInvoiceService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    private final IInvoiceService invoiceService;

    public InvoiceController(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/create")
    public ResponseEntity<Invoice> create(@RequestBody Invoice invoice) {
        Invoice createdInvoice = invoiceService.create(invoice);
        return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Invoice> read(@PathVariable Long id) {
        Invoice invoice = invoiceService.read(id);
        if (invoice == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Invoice> update(@RequestBody Invoice invoice) {
        Invoice updatedInvoice = invoiceService.update(invoice);
        if (updatedInvoice == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        invoiceService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<Invoice> getAll() {
        return invoiceService.getAll();
    }

    @GetMapping("/by-invoice-number")
    public ResponseEntity<Invoice> getByInvoiceNumber(@RequestParam String invoiceNumber) {
        Invoice invoice = invoiceService.getByInvoiceNumber(invoiceNumber);
        if (invoice == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @GetMapping("/exists-by-invoice-number")
    public ResponseEntity<Boolean> existsByInvoiceNumber(@RequestParam String invoiceNumber) {
        return new ResponseEntity<>(invoiceService.existsByInvoiceNumber(invoiceNumber), HttpStatus.OK);
    }

    @PostMapping("/by-payment")
    public ResponseEntity<Invoice> getByPayment(@RequestBody Payment payment) {
        Invoice invoice = invoiceService.getByPayment(payment);
        if (invoice == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @GetMapping("/by-issued-date-between")
    public List<Invoice> getAllByIssuedDateBetween(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return invoiceService.getAllByIssuedDateBetween(start, end);
    }

    @GetMapping("/due-before")
    public List<Invoice> getAllDueBefore(@RequestParam LocalDateTime date) {
        return invoiceService.getAllDueBefore(date);
    }

    @GetMapping("/by-student-id/{userId}")
    public List<Invoice> getAllByStudentId(@PathVariable Long userId) {
        return invoiceService.getAllByStudentId(userId);
    }
}
