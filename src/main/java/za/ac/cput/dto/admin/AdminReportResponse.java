package za.ac.cput.dto.admin;

import java.time.LocalDateTime;

import za.ac.cput.enums.ReportStatus;

public record AdminReportResponse(
        Long reportId,
        Long reporterId,
        Long reportedUserId,
        ReportStatus status,
        String description,
        LocalDateTime reportedAt,
        LocalDateTime resolvedAt) {
}
