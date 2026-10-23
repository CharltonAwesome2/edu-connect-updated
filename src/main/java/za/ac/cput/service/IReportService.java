/*
IReportService.java
Report Service interface
Author: Nolwazi Zulu (220118876)
Date: 22 October 2026
*/

package za.ac.cput.service;

import java.time.LocalDateTime;
import java.util.List;

import za.ac.cput.domain.Report;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.ReportStatus;

public interface IReportService extends service<Report, Long> {

    List<Report> getAllByReporter(User reporter);

    List<Report> getAllByReporterId(Long userId);

    List<Report> getAllByReportedUser(User reportedUser);

    List<Report> getAllByReportedUserId(Long userId);

    List<Report> getAllBySession(TutoringSession session);

    List<Report> getAllByStatus(ReportStatus status);

    List<Report> getAllByReportedAtBetween(LocalDateTime start, LocalDateTime end);

    long countByReportedUserId(Long userId);

    Report updateStatus(Long id, ReportStatus status);

    Report resolveReport(Long id, ReportStatus finalStatus);
}
