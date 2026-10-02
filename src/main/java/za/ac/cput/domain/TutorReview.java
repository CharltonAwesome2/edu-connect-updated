package za.ac.cput.domain;

import java.time.LocalDateTime;
// import java.util.Objects;

/* TutorReview.java
    TutorReview class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

public class TutorReview {
    private Long reviewId;
    private TutoringSession session;
    private User student;
    private TutorProfile tutorProfile;
    private int rating;
    private String comment;
    private String strengths;
    private String improvements;
    private LocalDateTime reviewedAt;
    private boolean isPublic;

    private TutorReview(Builder builder) {
        this.reviewId = builder.reviewId;
        this.session = builder.session;
        this.student = builder.student;
        this.tutorProfile = builder.tutorProfile;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.strengths = builder.strengths;
        this.improvements = builder.improvements;
        this.reviewedAt = builder.reviewedAt;
        this.isPublic = builder.isPublic;

    }

    public Long getReviewId() {
        return reviewId;
    }

    public TutoringSession getSession() {
        return session;
    }

    public User getStudent() {
        return student;
    }

    public TutorProfile getTutorProfile() {
        return tutorProfile;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getStrengths() {
        return strengths;
    }

    public String getImprovements() {
        return improvements;
    }

    public LocalDateTime getReviewedAt() {
        return reviewedAt;
    }

    public boolean isPublic() {
        return isPublic;
    }


    @Override
    public String toString() {
        return "TutorReviewFactory{" +
                "reviewId=" + reviewId +
                ", sessionId=" + session +
                ", studentId=" + student +
                ", tutorProfile=" + tutorProfile +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", strengths='" + strengths + '\'' +
                ", improvements='" + improvements + '\'' +
                ", reviewedAt=" + reviewedAt +
                ", isPublic=" + isPublic +
                '}';
    }


    public static class Builder {
        private Long reviewId;
        private TutoringSession session;
        private User student;
        private TutorProfile tutorProfile;
        private int rating;
        private String comment;
        private String strengths;
        private String improvements;
        private LocalDateTime reviewedAt;
        private boolean isPublic;

        public Builder setReviewId(Long reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setSession(TutoringSession session) {
            this.session = session;
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

        public Builder setRating(int rating) {
            if (rating < 1 || rating > 5) {
                throw new IllegalArgumentException("Rating must be between 1 and 5.");
            }
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setStrengths(String strengths) {
            this.strengths = strengths;
            return this;
        }

        public Builder setImprovements(String improvements) {
            this.improvements = improvements;
            return this;
        }

        public Builder setReviewedAt(LocalDateTime reviewedAt) {
            this.reviewedAt = reviewedAt;
            return this;
        }

        public Builder setIsPublic(boolean isPublic) {
            this.isPublic = isPublic;
            return this;
        }

        public Builder copy(TutorReview review) {
            this.reviewId = review.reviewId;
            this.session = review.session;
            this.student = review.student;
            this.tutorProfile = review.tutorProfile;
            this.rating = review.rating;
            this.comment = review.comment;
            this.strengths = review.strengths;
            this.improvements = review.improvements;
            this.reviewedAt = review.reviewedAt;
            this.isPublic = review.isPublic;

            return this;
        }

        public TutorReview build() {
            return new TutorReview(this);
        }
    }
}