package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Report;
import za.ac.cput.service.IService.IReportService;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final IReportService reportService;

    public ReportController(IReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/create")
    public ResponseEntity<Report> create(@RequestBody Report report) {
        Report createdReport = reportService.create(report);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Report> read(@PathVariable Long id) {
        Report report = reportService.read(id);
        if (report == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Report> update(@RequestBody Report report) {
        Report updatedReport = reportService.update(report);
        if (updatedReport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedReport, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reportService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<Report> getAll() {
        return reportService.getAll();
    }
}
