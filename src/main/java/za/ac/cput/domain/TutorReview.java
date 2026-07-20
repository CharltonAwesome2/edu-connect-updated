package za.ac.cput.domain;

import java.time.LocalDateTime;
import java.util.Objects;

/* TutorReview.java
    TutorReview class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

public class TutorReview {
    private Long reviewId;
    private Long sessionId;
    private Long studentId;
    private Long tutorProfileId;
    private int rating;
    private String comment;
    private String strengths;
    private String improvements;
    private LocalDateTime reviewedAt;
    private boolean isPublic;

    private TutorReview(Builder builder) {
        this.reviewId = builder.reviewId;
        this.sessionId = builder.sessionId;
        this.studentId = builder.studentId;
        this.tutorProfileId = builder.tutorProfileId;
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

    public Long getSessionId() {
        return sessionId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getTutorProfileId() {
        return tutorProfileId;
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
                ", sessionId=" + sessionId +
                ", studentId=" + studentId +
                ", tutorProfileId=" + tutorProfileId +
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
        private Long sessionId;
        private Long studentId;
        private Long tutorProfileId;
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

        public Builder setSessionId(Long sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public Builder setStudentId(Long studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setTutorProfileId(Long tutorProfileId) {
            this.tutorProfileId = tutorProfileId;
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
            this.sessionId = review.sessionId;
            this.studentId = review.studentId;
            this.tutorProfileId = review.tutorProfileId;
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