
/*
ReportServiceTest.java
Report Service Test Class
Author: Nolwazi Zulu (220118876)
Date: 10 November 2026
*/

package za.ac.cput.service;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Report;
import za.ac.cput.repository.ReportRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReportServiceTest {

    private ReportService service;
    private ReportRepository reportRepository;
    private Report report;

    @BeforeEach
    void setUp() {

        reportRepository = mock(ReportRepository.class);
        service = new ReportService(reportRepository);

        report = Report.builder()
                .reportId(1001L)
                .reason("Test report reason")
                .description("Test report description")
                .build();
    }

    @Test
    void create() {

        when(reportRepository.save(report)).thenReturn(report);

        Report result = service.create(report);

        assertNotNull(result);
        assertEquals(report.getReportId(), result.getReportId());

        verify(reportRepository).save(report);
    }

    @Test
    void read() {

        when(reportRepository.findById(1001L))
                .thenReturn(Optional.of(report));

        Report result = service.read(1001L);

        assertNotNull(result);
        assertEquals("Test report reason", result.getReason());

        verify(reportRepository).findById(1001L);
    }

    @Test
    void update() {

        when(reportRepository.save(report)).thenReturn(report);

        Report result = service.update(report);

        assertNotNull(result);
        assertEquals("Test report reason", result.getReason());

        verify(reportRepository).save(report);
    }

    @Test
    void delete() {

        service.delete(1001L);

        verify(reportRepository).deleteById(1001L);
    }
}