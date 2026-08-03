package za.ac.cput.domain;

import java.time.LocalDateTime;

import za.ac.cput.enums.ReportStatus;

public class Report {

    private Long reportId;
    private User reporter;
    private User reportedUser;
    private TutoringSession session;
    private String reason;
    private String description;
    private ReportStatus status;
    private LocalDateTime reportAt;
    private LocalDateTime resolvedAt;

    private Report(Builder builder) {
        this.reportId = builder.reportId;
        this.reporter = builder.reporter;
        this.reportedUser = builder.reportedUser;
        this.session = builder.session;
        this.reason = builder.reason;
        this.description = builder.description;
        this.status = builder.status;
        this.reportAt = builder.reportAt;
        this.resolvedAt = builder.resolvedAt;
    }

    public Long getReportId() {
        return reportId;
    }

    public User getReporter() {
        return reporter;
    }

    public User getReportedUser() {
        return reportedUser;
    }

    public TutoringSession getSession() {
        return session;
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

    @Override
    public String toString() {
        return "Report [reportId=" + reportId + ", reporter=" + reporter + ", reportedUser=" + reportedUser
                + ", session=" + session + ", reason=" + reason + ", description=" + description + ", status=" + status
                + ", reportAt=" + reportAt + ", resolvedAt=" + resolvedAt + "]";
    }

    public static class Builder {

        private Long reportId;
        private User reporter;
        private User reportedUser;
        private TutoringSession session;
        private String reason;
        private String description;
        private ReportStatus status;
        private LocalDateTime reportAt;
        private LocalDateTime resolvedAt;

        public Builder setReportId(Long reportId) {
            this.reportId = reportId;
            return this;
        }

        public Builder setReporter(User reporter) {
            this.reporter = reporter;
            return this;
        }

        public Builder setReportedUser(User reportedUser) {
            this.reportedUser = reportedUser;
            return this;
        }

        public Builder setSession(TutoringSession session) {
            this.session = session;
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
