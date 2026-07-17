package za.ac.cput.domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Availability {
    private Long id;
    private TutorProfile tutorProfile;
    private DayOfWeek dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isRecurring;

    private Availability(Builder builder) {
        this.id = builder.id;
        this.tutorProfile = builder.tutorProfile;
        this.dayOfWeek = builder.dayOfWeek;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.isRecurring = builder.isRecurring;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TutorProfile getTutorProfile() {
        return tutorProfile;
    }

    public void setTutorProfile(TutorProfile tutorProfile) {
        this.tutorProfile = tutorProfile;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        this.isRecurring = recurring;
    }

    @Override
    public String toString() {
        return "Availability [id=" + id + ", tutorProfile=" + tutorProfile + ", dayOfWeek=" + dayOfWeek + ", startTime="
                + startTime + ", endTime=" + endTime + ", isRecurring=" + isRecurring + "]";
    }

    public static class Builder {
        private Long id;
        private TutorProfile tutorProfile;
        private DayOfWeek dayOfWeek;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private boolean isRecurring;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setTutorProfile(TutorProfile tutorProfile) {
            this.tutorProfile = tutorProfile;
            return this;
        }

        public Builder setDayOfWeek(DayOfWeek dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
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

        public Builder setRecurring(boolean isRecurring) {
            this.isRecurring = isRecurring;
            return this;
        }

        public Builder copy(Availability availability) {
            this.id = availability.id;
            this.tutorProfile = availability.tutorProfile;
            this.dayOfWeek = availability.dayOfWeek;
            this.startTime = availability.startTime;
            this.endTime = availability.endTime;
            this.isRecurring = availability.isRecurring;
            return this;
        }

        public Availability build() {
            return new Availability(this);
        }

    }
}
