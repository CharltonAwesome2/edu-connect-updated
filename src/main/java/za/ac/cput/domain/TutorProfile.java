package za.ac.cput.domain;

import java.time.LocalDateTime;

/**
 * TutorProfile.java
 * TutorProfile model class
 * Author: Esaile Siani Djiakeng
 * Date: 30 July 2026
 */
public class TutorProfile {
    private Long tutorProfileId;
    private User user;
    private String bio;
    private int yearsExperience;
    private double hourlyRate;
    private double averageRating;
    private LocalDateTime createdAt;

    public TutorProfile() {
    }

    private TutorProfile(Builder builder) {
        this.tutorProfileId = builder.tutorProfileId;
        this.user = builder.user;
        this.bio = builder.bio;
        this.yearsExperience = builder.yearsExperience;
        this.hourlyRate = builder.hourlyRate;
        this.averageRating = builder.averageRating;
        this.createdAt = builder.createdAt;
    }

    public Long getTutorProfileId() {
        return tutorProfileId;
    }

    public User getUser() {
        return user;
    }

    public String getBio() {
        return bio;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "TutorProfile [tutorProfileId=" + tutorProfileId + ", user=" + user + ", bio=" + bio
                + ", yearsExperience=" + yearsExperience + ", hourlyRate=" + hourlyRate + ", averageRating="
                + averageRating + ", createdAt=" + createdAt + "]";
    }

    public static class Builder {
        private Long tutorProfileId;
        private User user;
        private String bio;
        private int yearsExperience;
        private double hourlyRate;
        private double averageRating;
        private LocalDateTime createdAt;

        public Builder setTutorProfileId(Long tutorProfileId) {
            this.tutorProfileId = tutorProfileId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setBio(String bio) {
            this.bio = bio;
            return this;
        }

        public Builder setYearsExperience(int yearsExperience) {
            this.yearsExperience = yearsExperience;
            return this;
        }

        public Builder setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        public Builder setAverageRating(double averageRating) {
            this.averageRating = averageRating;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder copy(TutorProfile tutorProfile) {
            this.tutorProfileId = tutorProfile.tutorProfileId;
            this.user = tutorProfile.user;
            this.bio = tutorProfile.bio;
            this.yearsExperience = tutorProfile.yearsExperience;
            this.hourlyRate = tutorProfile.hourlyRate;
            this.averageRating = tutorProfile.averageRating;
            this.createdAt = tutorProfile.createdAt;
            return this;
        }

        public TutorProfile build() {
            return new TutorProfile(this);
        }
    }
}