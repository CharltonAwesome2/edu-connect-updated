package za.ac.cput.domain;

import za.ac.cput.enums.BookingStatus;

import java.time.LocalDateTime;

// BookingRequest.java
// Booking Request model class
// Author: Reotshepile Stock (230875807)
// Date: 23 July 2026

public class BookingRequest {

    private Long requestId;
    private LocalDateTime requestedStartTime;
    private int durationMinutes;
    private BookingStatus status;
    private User student;
    private TutorProfile tutorProfile;
    private Subject subject;
    private String studentNotes;

    public BookingRequest() {
    }

    private BookingRequest(Builder builder) {
        this.requestId = builder.requestId;
        this.requestedStartTime = builder.requestedStartTime;
        this.durationMinutes = builder.durationMinutes;
        this.status = builder.status;
        this.student = builder.student;
        this.tutorProfile = builder.tutorProfile;
        this.subject = builder.subject;
        this.studentNotes = builder.studentNotes;
    }

    public Long getRequestId() {
        return requestId;
    }

    public LocalDateTime getRequestedStartTime() {
        return requestedStartTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public BookingStatus getStatus() {
        return status;
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

    public String getStudentNotes() {
        return studentNotes;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "requestId=" + requestId +
                ", requestedStartTime=" + requestedStartTime +
                ", durationMinutes=" + durationMinutes +
                ", status=" + status +
                ", student=" + student +
                ", tutorProfile=" + tutorProfile +
                ", subject=" + subject +
                ", studentNotes='" + studentNotes + '\'' +
                '}';
    }

    public static class Builder {

        private Long requestId;
        private LocalDateTime requestedStartTime;
        private int durationMinutes;
        private BookingStatus status;
        private User student;
        private TutorProfile tutorProfile;
        private Subject subject;
        private String studentNotes;

        public Builder setRequestId(Long requestId) {
            this.requestId = requestId;
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

        public Builder setStatus(BookingStatus status) {
            this.status = status;
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

        public Builder setStudentNotes(String studentNotes) {
            this.studentNotes = studentNotes;
            return this;
        }

        public Builder copy(BookingRequest bookingRequest) {
            this.requestId = bookingRequest.requestId;
            this.requestedStartTime = bookingRequest.requestedStartTime;
            this.durationMinutes = bookingRequest.durationMinutes;
            this.status = bookingRequest.status;
            this.student = bookingRequest.student;
            this.tutorProfile = bookingRequest.tutorProfile;
            this.subject = bookingRequest.subject;
            this.studentNotes = bookingRequest.studentNotes;
            return this;
        }

        public BookingRequest build() {
            return new BookingRequest(this);
        }
    }
}
