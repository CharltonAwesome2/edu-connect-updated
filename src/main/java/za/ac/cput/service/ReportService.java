/*
ReportService.java
Report Service Class
Author: Nolwazi Zulu (220118876)
Date: 22 October 2026
*/

package za.ac.cput.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.Report;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.ReportStatus;
import za.ac.cput.repository.ReportRepository;

@Service
public class ReportService implements IReportService {

    private final ReportRepository reportRepository;

    @Autowired
    ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report create(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report read(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public Report update(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void delete(Long id) {
        reportRepository.deleteById(id);
    }

    @Override
    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> getAllByReporter(User reporter) {
        return reportRepository.findAllByReporter(reporter);
    }

    @Override
    public List<Report> getAllByReporterId(Long userId) {
        return reportRepository.findAllByReporter_UserId(userId);
    }

    @Override
    public List<Report> getAllByReportedUser(User reportedUser) {
        return reportRepository.findAllByReportedUser(reportedUser);
    }

    @Override
    public List<Report> getAllByReportedUserId(Long userId) {
        return reportRepository.findAllByReportedUser_UserId(userId);
    }

    @Override
    public List<Report> getAllBySession(TutoringSession session) {
        return reportRepository.findAllBySession(session);
    }

    @Override
    public List<Report> getAllByStatus(ReportStatus status) {
        return reportRepository.findAllByStatus(status);
    }

    @Override
    public List<Report> getAllByReportedAtBetween(LocalDateTime start, LocalDateTime end) {
        return reportRepository.findAllByReportedAtBetween(start, end);
    }

    @Override
    public long countByReportedUserId(Long userId) {
        return reportRepository.countByReportedUser_UserId(userId);
    }

    @Override
    public Report updateStatus(Long id, ReportStatus status) {
        Report report = reportRepository.findById(id).orElse(null);
        if (report == null) {
            return null;
        }
        report.setStatus(status);
        return reportRepository.save(report);
    }

    @Override
    public Report resolveReport(Long id, ReportStatus finalStatus) {
        Report report = reportRepository.findById(id).orElse(null);
        if (report == null) {
            return null;
        }
        report.setStatus(finalStatus);
        report.setResolvedAt(LocalDateTime.now());
        return reportRepository.save(report);
    }
}
