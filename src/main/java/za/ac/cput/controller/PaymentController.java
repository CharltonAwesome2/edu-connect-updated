package za.ac.cput.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.dto.frontend.PaymentResponse;
import za.ac.cput.service.IPaymentService;

import java.util.List;

/* PaymentController.java
    PaymentController class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 August 2026
*/

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final IPaymentService paymentService;

    @Autowired
    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse createPayment(@Valid @RequestBody Payment payment) {
        return toResponse(paymentService.create(payment));
    }

    @GetMapping("/{id}")
    public PaymentResponse getPaymentById(@PathVariable Long id) {
        return toResponse(paymentService.read(id));
    }

    @PutMapping("/{id}")
    public PaymentResponse updatePayment(
            @PathVariable Long id,
            @Valid @RequestBody Payment payment) {
        payment.setPaymentId(id);
        return toResponse(paymentService.update(payment));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePayment(@PathVariable Long id) {
        paymentService.delete(id);
    }

    @GetMapping
    public List<PaymentResponse> getAllPayments() {
        return paymentService.getAll().stream().map(this::toResponse).toList();
    }

    private PaymentResponse toResponse(Payment payment) {
        if (payment == null) {
            return null;
        }
        return new PaymentResponse(
                payment.getPaymentId(),
                payment.getAmount(),
                payment.getTutorEarnings(),
                payment.getPlatformFee(),
                payment.getStatus(),
                payment.getPaymentMethod(),
                payment.getPaidAt());
    }
}
