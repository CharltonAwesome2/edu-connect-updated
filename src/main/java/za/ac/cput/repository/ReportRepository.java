
/*
ReportRepository.java
Report Repository Interface
Author: Nolwazi Zulu (220118876)
Date: 22 October 2026
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
