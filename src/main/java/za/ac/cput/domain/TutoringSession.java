package za.ac.cput.domain;

import java.time.LocalDateTime;

import za.ac.cput.enums.SessionStatus;

/**
 * TutoringSession.java
 * TutoringSession model class
 * Author: Esaile Siani Djiakeng
 * Date: 30 July 2026
 */
public class TutoringSession {
    private Long sessionId;
    private BookingRequest bookingRequest;
    private User student;
    private TutorProfile tutorProfile;
    private Subject subject;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private SessionStatus status;
    private String sessionNotes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TutoringSession() {
    }

    private TutoringSession(Builder builder) {
        this.sessionId = builder.sessionId;
        this.bookingRequest = builder.bookingRequest;
        this.student = builder.student;
        this.tutorProfile = builder.tutorProfile;
        this.subject = builder.subject;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.status = builder.status;
        this.sessionNotes = builder.sessionNotes;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public BookingRequest getBookingRequest() {
        return bookingRequest;
    }

    public User getStudent() {
        return student;
    }

    public TutorProfile getTutorProfile() {
        return tutorProfile;
    }

    public Subject getSubject() {
        return subject;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public String getSessionNotes() {
        return sessionNotes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "TutoringSession [sessionId=" + sessionId + ", bookingRequest=" + bookingRequest + ", student=" + student
                + ", tutorProfile=" + tutorProfile + ", subject=" + subject + ", startTime=" + startTime + ", endTime="
                + endTime + ", status=" + status + ", sessionNotes=" + sessionNotes + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }

    public static class Builder {
        private Long sessionId;
        private BookingRequest bookingRequest;
        private User student;
        private TutorProfile tutorProfile;
        private Subject subject;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private SessionStatus status;
        private String sessionNotes;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder setSessionId(Long sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public Builder setBookingRequest(BookingRequest bookingRequest) {
            this.bookingRequest = bookingRequest;
            return this;
        }

        public Builder setStudent(User student) {
            this.student = student;
            return this;
        }

        public Builder setTutorProfile(TutorProfile tutorProfile) {
            this.tutorProfile = tutorProfile;
            return this;
        }

        public Builder setSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public Builder setStartTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setStatus(SessionStatus status) {
            this.status = status;
            return this;
        }

        public Builder setSessionNotes(String sessionNotes) {
            this.sessionNotes = sessionNotes;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder copy(TutoringSession tutoringSession) {
            this.sessionId = tutoringSession.sessionId;
            this.bookingRequest = tutoringSession.bookingRequest;
            this.student = tutoringSession.student;
            this.tutorProfile = tutoringSession.tutorProfile;
            this.subject = tutoringSession.subject;
            this.startTime = tutoringSession.startTime;
            this.endTime = tutoringSession.endTime;
            this.status = tutoringSession.status;
            this.sessionNotes = tutoringSession.sessionNotes;
            this.createdAt = tutoringSession.createdAt;
            this.updatedAt = tutoringSession.updatedAt;
            return this;
        }

        public TutoringSession build() {
            return new TutoringSession(this);
        }
    }
}