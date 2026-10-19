package za.ac.cput.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
// import java.util.Objects;

import lombok.Builder;
import lombok.Data;

/* Invoice.java
    Invoice class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

@Data 
@Builder
public class Invoice {
    
    private Long invoiceId;
    private Payment payment;
    private String invoiceNumber;
    private LocalDateTime issuedDate;
    private LocalDateTime dueDate;
    private BigDecimal totalAmount;
    private BigDecimal taxAmount;

}
