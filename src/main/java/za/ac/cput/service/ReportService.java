
/*
ReportService.java
Report Service Class
Author: Nolwazi Zulu (220118876)
Date: 22 October 2026
*/

package za.ac.cput.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import za.ac.cput.domain.Report;
import za.ac.cput.repository.ReportRepository;

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
}
