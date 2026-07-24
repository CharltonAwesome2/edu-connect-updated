package za.ac.cput.domain;

public class TutoringSession {

    private long sessionId;
    private long bookingRequestId;
    private long studentId;
    private long tutorProfileId;
    private long subjectId;
    private LocalDate startTime;
    private LocalDate endTime;
    private SessionStatus status;
    private String sessionNotes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TutoringSession() {}

    public TutoringSession(Builder builder) {
        this.sessionId = builder.sessionId;
        this.bookingRequestId = builder.bookingRequestId;
        this.studentId = builder.studentId;
        this.tutorProfileId = builder.tutorProfileId;
        this.subjectId = builder.subjectId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.status = builder.status;
        this.sessionNotes = builder.sessionNotes;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public long getSessionId() {}

    public long getBookingRequestId() {
        return bookingRequestId;
    }

    public long getStudentId() {
        return studentId;
    }

    public long getTutorProfileId() {
        return tutorProfileId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getEndTime() {
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

    public static class Builder {
        private long sessionId;
        private long bookingRequestId;
        private long studentId;
        private long tutorProfileId;
        private long subjectId;
        private LocalDate startTime;
        private LocalDate endTime;
        private SessionStatus status;
        private String sessionNotes;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder setSessionId(long sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public Builder setBookingRequestId(long bookingRequestId) {
            this.bookingRequestId = bookingRequestId;
            return this;
        }

        public Builder setStudentId(long studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setTutorProfileId(long tutorProfileId) {
            this.tutorProfileId = tutorProfileId;
            return this;
        }

        public Builder setSubjectId(long subjectId) {
            this.subjectId = subjectId;
            return this;
        }

        public Builder setStartTime(LocalDate startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(LocalDate endTime) {
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
            this.bookingRequestId = tutoringSession.bookingRequestId;
            this.studentId = tutoringSession.studentId;
            this.tutorProfileId = tutoringSession.tutorProfileId;
            this.subjectId = tutoringSession.subjectId;
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
};


