package za.ac.cput.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Report;
import za.ac.cput.enums.ReportStatus;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByReporter_UserIdOrderByReportAtDesc(Long userId);

    @EntityGraph(attributePaths = { "reporter", "reportedUser" })
    List<Report> findAllByOrderByReportAtDesc();

    Optional<Report> findByReportIdAndReporter_UserId(Long reportId, Long userId);

    long countByStatusIn(List<ReportStatus> statuses);
}
