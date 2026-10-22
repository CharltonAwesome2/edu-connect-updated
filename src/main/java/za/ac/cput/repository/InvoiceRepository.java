package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Invoice;

/* InvoiceRepository.java
    InvoiceRepository interface
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
