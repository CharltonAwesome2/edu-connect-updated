
/*
ReportRepository.java
Report Repository Interface
Author: Nolwazi Zulu (220118876)
Date: 22 October 2026
*/

package za.ac.cput.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Report;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.ReportStatus;

public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllByReporter(User reporter);

    List<Report> findAllByReporter_UserId(Long userId);

    List<Report> findAllByReportedUser(User reportedUser);

    List<Report> findAllByReportedUser_UserId(Long userId);

    List<Report> findAllBySession(TutoringSession session);

    List<Report> findAllByStatus(ReportStatus status);

    List<Report> findAllByReportedAtBetween(LocalDateTime start, LocalDateTime end);

    long countByReportedUser_UserId(Long userId);
}
