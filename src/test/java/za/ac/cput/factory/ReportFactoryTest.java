/*
    ReportFactoryTest.java
    Report Factory Test class
    Author: Nolwazi Zulu (220118876)
    Date: 05 September 2026
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

    private User reporter = new User.Builder()
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

    private User reportedUser = new User.Builder()
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

    String reason = "Inappropriate behaviour";
    String description = "Description of Report";

    LocalDateTime reportDate = LocalDateTime.now();
    LocalDateTime reportedAt = LocalDateTime.now();
    LocalDateTime resolvedAt = LocalDateTime.now();
    ReportStatus status = ReportStatus.PENDING;
    TutoringSession session = new TutoringSession.Builder().build();

    private Report report = ReportFactory.createReport(reporter,
            reportedUser,
            session,
            reason,
            description,
            status,
            reportedAt, resolvedAt);

    @Test
    void createReport() {

        assertNotNull(report);
        assertNotNull(report.getReportId());
        assertEquals("Inappropriate behaviour", report.getReason());
        assertEquals(reportDate, report.getReportAt());
        assertEquals(reporter, report.getReporter());
        assertEquals(reportedUser, report.getReportedUser());
    }

}