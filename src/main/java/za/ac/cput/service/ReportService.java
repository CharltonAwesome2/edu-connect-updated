
/*
ReportService.java
Report Service Class
Author: Nolwazi Zulu (220118876)
Date: 22 October 2026
*/

package za.ac.cput.service;

import za.ac.cput.domain.Report;
import za.ac.cput.repository.ReportRepository;
import za.ac.cput.repository.ReportRepositoryImpl;

public class ReportService {

    private final ReportRepository repository;

    private static final ReportService SERVICE =
            new ReportService();

    private ReportService() {
        repository = ReportRepositoryImpl.getRepository();
    }

    public static ReportService getService() {
        return SERVICE;
    }

    public Report create(Report report) {
        return repository.create(report);
    }

    public Report read(Long id) {
        return repository.read(id);
    }

    public Report update(Report report) {
        return repository.update(report);
    }

    public boolean delete(Long id) {
        return repository.delete(id);
    }
}

