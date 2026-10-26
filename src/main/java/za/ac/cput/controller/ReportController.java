package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Report;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.ReportStatus;
import za.ac.cput.service.IService.IReportService;

import java.time.LocalDateTime;
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

    @PostMapping("/by-reporter")
    public List<Report> getAllByReporter(@RequestBody User reporter) {
        return reportService.getAllByReporter(reporter);
    }

    @GetMapping("/by-reporter-id/{userId}")
    public List<Report> getAllByReporterId(@PathVariable Long userId) {
        return reportService.getAllByReporterId(userId);
    }

    @PostMapping("/by-reported-user")
    public List<Report> getAllByReportedUser(@RequestBody User reportedUser) {
        return reportService.getAllByReportedUser(reportedUser);
    }

    @GetMapping("/by-reported-user-id/{userId}")
    public List<Report> getAllByReportedUserId(@PathVariable Long userId) {
        return reportService.getAllByReportedUserId(userId);
    }

    @PostMapping("/by-session")
    public List<Report> getAllBySession(@RequestBody TutoringSession session) {
        return reportService.getAllBySession(session);
    }

    @GetMapping("/by-status/{status}")
    public List<Report> getAllByStatus(@PathVariable ReportStatus status) {
        return reportService.getAllByStatus(status);
    }

    @GetMapping("/by-reported-at-between")
    public List<Report> getAllByReportedAtBetween(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return reportService.getAllByReportedAtBetween(start, end);
    }

    @GetMapping("/count-by-reported-user-id/{userId}")
    public ResponseEntity<Long> countByReportedUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(reportService.countByReportedUserId(userId), HttpStatus.OK);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Report> updateStatus(
            @PathVariable Long id,
            @RequestParam ReportStatus status) {
        Report updated = reportService.updateStatus(id, status);
        if (updated == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PatchMapping("/{id}/resolve")
    public ResponseEntity<Report> resolveReport(
            @PathVariable Long id,
            @RequestParam ReportStatus finalStatus) {
        Report resolved = reportService.resolveReport(id, finalStatus);
        if (resolved == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(resolved, HttpStatus.OK);
    }
}
