package za.ac.cput.factory;

import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;

/* TutorReviewFactory.java
    TutorReviewFactory class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

public class TutorReviewFactory {

    public static TutorReview createTutorReview(Long sessionId, Long studentId, Long tutorProfileId, int rating, String comment, String strengths, String improvements, LocalDateTime reviewedAt, boolean isPublic) {
        Long reviewId = HelperUtil.generateId();

        if (sessionId == null
                || studentId == null
                || tutorProfileId == null
                || comment == null
                || strengths == null
                || improvements == null) {
            return null;
        }

        if (reviewedAt == null) {
            reviewedAt = LocalDateTime.now();
        }

        return new TutorReview.Builder()
                .setReviewId(reviewId)
                .setSessionId(sessionId)
                .setStudentId(studentId)
                .setTutorProfileId(tutorProfileId)
                .setRating(rating)
                .setComment(comment)
                .setStrengths(strengths)
                .setImprovements(improvements)
                .setReviewedAt(reviewedAt)
                .setIsPublic(isPublic)
                .build();
    }
}







