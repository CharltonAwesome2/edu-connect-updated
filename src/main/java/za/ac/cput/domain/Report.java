package za.ac.cput.domain;

import java.time.LocalDateTime;

import za.ac.cput.enums.ReportStatus;

public class Report {

    private Long reportId;
    private Long reporterId;
    private Long reportedUserId;
    private Long sessionId;
    private String reason;
    private String description;
    private ReportStatus status;
    private LocalDateTime reportAt;
    private LocalDateTime resolvedAt;

    private Report(Builder builder) {
        this.reportId = builder.reportId;
        this.reporterId = builder.reporterId;
        this.reportedUserId = builder.reportedUserId;
        this.sessionId = builder.sessionId;
        this.reason = builder.reason;
        this.description = builder.description;
        this.status = builder.status;
        this.reportAt = builder.reportAt;
        this.resolvedAt = builder.resolvedAt;
    }

    public Long getReportId() {
        return reportId;
    }

    public Long getReporterId() {
        return reporterId;
    }

    public Long getReportedUserId() {
        return reportedUserId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public String getReason() {
        return reason;
    }

    public String getDescription() {
        return description;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public LocalDateTime getReportAt() {
        return reportAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public static class Builder {

        private Long reportId;
        private Long reporterId;
        private Long reportedUserId;
        private Long sessionId;
        private String reason;
        private String description;
        private ReportStatus status;
        private LocalDateTime reportAt;
        private LocalDateTime resolvedAt;

        public Builder setReportId(Long reportId) {
            this.reportId = reportId;
            return this;
        }

        public Builder setReporterId(Long reporterId) {
            this.reporterId = reporterId;
            return this;
        }

        public Builder setReportedUserId(Long reportedUserId) {
            this.reportedUserId = reportedUserId;
            return this;
        }

        public Builder setSessionId(Long sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public Builder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setStatus(ReportStatus status) {
            this.status = status;
            return this;
        }

        public Builder setReportAt(LocalDateTime reportAt) {
            this.reportAt = reportAt;
            return this;
        }

        public Builder setResolvedAt(LocalDateTime resolvedAt) {
            this.resolvedAt = resolvedAt;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }
}
