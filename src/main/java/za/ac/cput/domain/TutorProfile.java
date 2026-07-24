package za.ac.cput.domain;

public class TutorProfile {

    private long tutorProfileId;
    private Long userId;
    private String bio;
    private int yearsExperience;
    private double hourlyRate;
    private double averageRating;
    private LocalDateTime createdAt;

    public long getTutorProfileId() {

        return tutorProfileId;
    }

    public Long getUserId() {
        return userId;
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

    public static class Builder {
        private long tutorProfileId;
        private Long userId;
        private String bio;
        private int yearsExperience;
        private double hourlyRate;
        private double averageRating;
        private LocalDateTime createdAt;

        public Builder setTutorProfileId(long tutorProfileId) {
            this.tutorProfileId = tutorProfileId;
            return this;
        }

        public Builder setUserId(Long userId) {
            this.userId = userId;
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
            this.userId = tutorProfile.userId;
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
