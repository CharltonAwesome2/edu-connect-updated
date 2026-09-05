/*
    ReportFactoryTest.java
    Report Factory Test class
    Author: Nolwazi Zulu (220118876)
    Date: 05 September 2026
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Report;
import za.ac.cput.domain.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReportFactoryTest {

    private final User reporter = new User.Builder()
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

    private final User reportedUser = new User.Builder()
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

   @Test
void createReport() {
    LocalDateTime reportDate = LocalDateTime.now();

    Report report = ReportFactory.createReport(
            "Inappropriate behaviour",
            reportDate,
            reporter,
            reportedUser
    );

    assertNotNull(report);
    assertNotNull(report.getReportId());
    assertEquals("Inappropriate behaviour", report.getReason());
    assertEquals(reportDate, report.getReportAt());
    assertEquals(reporter, report.getReporter());
    assertEquals(reportedUser, report.getReportedUser());
 }

}