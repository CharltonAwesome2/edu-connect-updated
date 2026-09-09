package za.ac.cput.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
// import java.util.Objects;

/* Invoice.java
    Invoice class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/
public class Invoice {
    private Long invoiceId;
    // private Long paymentId;
    private Payment payment;
    private String invoiceNumber;
    private LocalDateTime issuedDate;
    private LocalDateTime dueDate;
    private BigDecimal totalAmount;
    private BigDecimal taxAmount;

    private Invoice(Builder builder) {
        this.invoiceId = builder.invoiceId;
        this.payment = builder.payment;
        this.invoiceNumber = builder.invoiceNumber;
        this.issuedDate = builder.issuedDate;
        this.dueDate = builder.dueDate;
        this.totalAmount = builder.totalAmount;
        this.taxAmount = builder.taxAmount;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public Payment getPayment() {
        return payment;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDateTime getIssuedDate() {
        return issuedDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    @Override
    public String toString() {
        return "invoice{" +
                "invoiceId=" + invoiceId +
                ", payment=" + payment +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", issuedDate=" + issuedDate +
                ", dueDate=" + dueDate +
                ", totalAmount=" + totalAmount +
                ", taxAmount=" + taxAmount +
                '}';
    }

    public static class Builder {
        private Long invoiceId;
        private Payment payment;
        private String invoiceNumber;
        private LocalDateTime issuedDate;
        private LocalDateTime dueDate;
        private BigDecimal totalAmount;
        private BigDecimal taxAmount;

        public Builder setInvoiceId(Long invoiceId) {
            this.invoiceId = invoiceId;
            return this;
        }

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder setIssuedDate(LocalDateTime issuedDate) {
            this.issuedDate = issuedDate;
            return this;
        }

        public Builder setDueDate(LocalDateTime dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder setTotalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setTaxAmount(BigDecimal taxAmount) {
            this.taxAmount = taxAmount;
            return this;
        }

        public Builder Copy(Invoice invoice) {
            this.invoiceId = invoice.invoiceId;
            this.payment = invoice.payment;
            this.invoiceNumber = invoice.invoiceNumber;
            this.issuedDate = invoice.issuedDate;
            this.dueDate = invoice.dueDate;
            this.totalAmount = invoice.totalAmount;
            this.taxAmount = invoice.taxAmount;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }
}
