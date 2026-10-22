
/*
ReportServiceTest.java
Report Service Test Class
Author: Nolwazi Zulu (220118876)
Date: 22 October 2026
*/

package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Report;

import static org.junit.jupiter.api.Assertions.*;

class ReportServiceTest {

    private ReportService service;
    private Report report;

    @BeforeEach
    void setUp() {
        service = ReportService.getService();

        report = new Report.Builder()
                .setReportId(1001L)
                .setReason("Test report reason")
                .setDescription("Test report description")
                .build();
    }

    @Test
    void create() {
        Report result = service.create(report);

        assertNotNull(result);
        assertEquals(
                report.getReportId(),
                result.getReportId()
        );
    }

    @Test
    void read() {
        service.create(report);

        Report result = service.read(report.getReportId());

        assertNotNull(result);
        assertEquals(
                "Test report reason",
                result.getReason()
        );
    }

    @Test
    void update() {
        service.create(report);

        Report updated = new Report.Builder()
                .setReportId(report.getReportId())
                .setReason("Updated report reason")
                .setDescription("Updated report description")
                .build();

        Report result = service.update(updated);

        assertNotNull(result);
        assertEquals(
                "Updated report reason",
                result.getReason()
        );
        assertEquals(
                "Updated report description",
                result.getDescription()
        );
    }

    @Test
    void delete() {
        service.create(report);

        Long id = report.getReportId();

        assertTrue(service.delete(id));
        assertNull(service.read(id));
    }
}
