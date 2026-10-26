package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.IService.IPaymentService;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.enums.PaymentMethod;
import za.ac.cput.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final IPaymentService paymentService;

    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.create(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Payment> read(@PathVariable Long id) {
        Payment payment = paymentService.read(id);
        if (payment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Payment> update(@RequestBody Payment payment) {
        Payment updatedPayment = paymentService.update(payment);
        if (updatedPayment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paymentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    @PostMapping("/by-session")
    public ResponseEntity<Payment> getBySession(@RequestBody TutoringSession session) {
        Payment payment = paymentService.getBySession(session);
        if (payment == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @GetMapping("/by-transaction-reference/{reference}")
    public ResponseEntity<Payment> getByTransactionReference(@PathVariable String reference) {
        Payment payment = paymentService.getByTransactionReference(reference);
        if (payment == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @GetMapping("/exists-by-transaction-reference")
    public ResponseEntity<Boolean> existsByTransactionReference(@RequestParam String reference) {
        return new ResponseEntity<>(paymentService.existsByTransactionReference(reference), HttpStatus.OK);
    }

    @GetMapping("/by-status/{status}")
    public List<Payment> getAllByStatus(@PathVariable PaymentStatus status) {
        return paymentService.getAllByStatus(status);
    }

    @GetMapping("/by-payment-method/{paymentMethod}")
    public List<Payment> getAllByPaymentMethod(@PathVariable PaymentMethod paymentMethod) {
        return paymentService.getAllByPaymentMethod(paymentMethod);
    }

    @GetMapping("/by-paid-at-between")
    public List<Payment> getAllByPaidAtBetween(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return paymentService.getAllByPaidAtBetween(start, end);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Payment> updateStatus(
            @PathVariable Long id,
            @RequestParam PaymentStatus status) {
        Payment updated = paymentService.updateStatus(id, status);
        if (updated == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
