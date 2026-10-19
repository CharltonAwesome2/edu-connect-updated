package za.ac.cput.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
// import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

/* Invoice.java
    Invoice class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

@Data
@Builder
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    private Payment payment;
    private String invoiceNumber;
    private LocalDateTime issuedDate;
    private LocalDateTime dueDate;
    private BigDecimal totalAmount;
    private BigDecimal taxAmount;

}
