/*
    ReportFactoryTest.java
    Report Factory Test class
    Author: Nolwazi Zulu (220118876)
    Date: 09 September 2026
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Report;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.ReportStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReportFactoryTest {

    User reporter = new User.Builder()
            .setUserId(1L)
            .setName("Nolwazi")
            .setSurname("Zulu")
            .setStudentNumber("220118876")
            .setEmail("nolwazi@example.com")
            .setContactNumber("0712345678")
            .setCreatedAt(LocalDateTime.now())
            .setIsTutor(false)
            .setIsStudent(true)
            .build();

    User reportedUser = new User.Builder()
            .setUserId(2L)
            .setName("Test")
            .setSurname("User")
            .setStudentNumber("220118877")
            .setEmail("test@example.com")
            .setContactNumber("0723456789")
            .setCreatedAt(LocalDateTime.now())
            .setIsTutor(true)
            .setIsStudent(false)
            .build();

    TutoringSession session =  new TutoringSession.Builder().setSessionId(1L).build();
    
    String reason = "Inappropriate behaviour";
    String description = "Inappropriate conduct";
    ReportStatus status = ReportStatus.INVESTIGATING;
    LocalDateTime reportedAt = LocalDateTime.now();
    LocalDateTime resolvedAt = reportedAt.plusHours(2);
    LocalDateTime reportDate = LocalDateTime.now();

    @Test
    void createReport() {

        Report report = ReportFactory.createReport(reporter,
                reportedUser,
                session,
                reason,
                description,
                status,
                reportDate,
                resolvedAt);

        assertNotNull(report);
        assertNotNull(report.getReportId());
        assertEquals(reporter, report.getReporter());
        assertEquals(reportedUser, report.getReportedUser());
        assertEquals(session, report.getSession());
        assertEquals(reason, report.getReason());
        assertEquals(description, report.getDescription());
        assertEquals(reportDate, report.getReportAt());
        assertEquals(resolvedAt, report.getResolvedAt());
    }

    @Test
    void createReportWithNullReporter() {
        Report report = ReportFactory.createReport(null,
                reportedUser,
                session,
                reason,
                description,
                status,
                reportDate,
                resolvedAt);
        assertNull(report);
    }

    @Test
    void createReportWithNullReportedUser() {
        Report report = ReportFactory.createReport(reporter,
                null,
                session,
                reason,
                description,
                status,
                reportDate,
                resolvedAt);
        assertNull(report);
    }

    @Test
    void createReportWithNullTutoringSession() {
        Report report = ReportFactory.createReport(reporter,
                reportedUser,
                null,
                reason,
                description,
                status,
                reportDate,
                resolvedAt);
        assertNull(report);
    }

    @Test
    void createReportWithNullReason() {
        Report report = ReportFactory.createReport(reporter,
                reportedUser,
                session,
                null,
                description,
                status,
                reportDate,
                resolvedAt);
        assertNull(report);
    }

    @Test
    void createReportWithEmptyReason() {
        Report report = ReportFactory.createReport(reporter,
                reportedUser,
                session,
                "",
                description,
                status,
                reportDate,
                resolvedAt);
        assertNull(report);
    }

    @Test
    void createReportWithNullDescription() {
        Report report = ReportFactory.createReport(reporter,
                reportedUser,
                session,
                reason,
                null,
                status,
                reportDate,
                resolvedAt);
        assertNull(report);
    }

    @Test
    void createReportWithEmptyDescription() {
        Report report = ReportFactory.createReport(reporter,
                reportedUser,
                session,
                reason,
                "",
                status,
                reportDate,
                resolvedAt);
        assertNull(report);
    }

    @Test
    void createReportWithNullStatus() {
        Report report = ReportFactory.createReport(reporter,
                reportedUser,
                session,
                reason,
                description,
                null,
                reportDate,
                resolvedAt);
        assertNull(report);
    }

    @Test
    void createReportWithNullReportedAt() {
        Report report = ReportFactory.createReport(reporter,
                reportedUser,
                session,
                reason,
                description,
                status,
                null,
                resolvedAt);
        assertNull(report);
    }
}