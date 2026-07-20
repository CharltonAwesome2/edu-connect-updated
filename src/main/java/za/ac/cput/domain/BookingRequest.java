package za.ac.cput.domain;

import za.ac.cput.enums.BookingStatus;
// BookingRequest.java
//Booking Request model class
//Author:Reotshepile Stock (230875807)
//Date:17 March 2026

import java.time.LocalDateTime;

public class BookingRequest {

    private Long tutoringSessionId;
    private LocalDateTime requestedStartTime;
    private int durationMinutes;
    private LocalDateTime createdAt;
    private BookingStatus status;
    private User user;
    private TutorProfile tutorProfile;
    private Subject subject;

    private BookingRequest(Builder builder) {
        this.tutoringSessionId = builder.tutoringSessionId;
        this.requestedStartTime = builder.requestedStartTime;
        this.durationMinutes = builder.durationMinutes;
        this.createdAt = builder.createdAt;
        this.status = builder.status;
        this.user = builder.user;
        this.tutorProfile = builder.tutorProfile;
        this.subject = builder.subject;
    }

    public Long getTutoringSessionId() {
        return tutoringSessionId;
    }

    public LocalDateTime getRequestedStartTime() {
        return requestedStartTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public TutorProfile getTutorProfile() {
        return tutorProfile;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "BookingRequest [tutoringSessionId=" + tutoringSessionId + ", requestedStartTime=" + requestedStartTime
                + ", durationMinutes=" + durationMinutes + ", createdAt=" + createdAt + ", status=" + status
                + ", user=" + user + ", tutorProfile=" + tutorProfile + ", subject=" + subject + "]";
    }

    public static class Builder {

        private Long tutoringSessionId;
        private LocalDateTime requestedStartTime;
        private int durationMinutes;
        private LocalDateTime createdAt;
        private BookingStatus status;
        private User user;
        private TutorProfile tutorProfile;
        private Subject subject;

        public Builder setTutoringSessionId(Long tutoringSessionId) {
            this.tutoringSessionId = tutoringSessionId;
            return this;
        }

        public Builder setRequestedStartTime(LocalDateTime requestedStartTime) {
            this.requestedStartTime = requestedStartTime;
            return this;
        }

        public Builder setDurationMinutes(int durationMinutes) {
            this.durationMinutes = durationMinutes;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public Builder setStatus(BookingStatus status) {
            this.status = status;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
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

        public Builder copy(BookingRequest bookingRequest) {
            this.tutoringSessionId = bookingRequest.tutoringSessionId;
            this.requestedStartTime = bookingRequest.requestedStartTime;
            this.durationMinutes = bookingRequest.durationMinutes;
            this.createdAt = bookingRequest.createdAt;
            this.status = bookingRequest.status;
            this.user = bookingRequest.user;
            this.tutorProfile = bookingRequest.tutorProfile;
            this.subject = bookingRequest.subject;
            return this;
        }

        public BookingRequest build() {
            return new BookingRequest(this);
        }
    }
}
