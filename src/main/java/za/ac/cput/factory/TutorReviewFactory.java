package za.ac.cput.factory;

import za.ac.cput.domain.TutorProfile;
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

    public static TutorReview createTutorReview(TutoringSession session,
            User student,
            TutorProfile tutorProfile,
            int rating,
            String comment,
            String strengths,
            String improvements,
            LocalDateTime reviewedAt,
            boolean isPublic) {

        Long reviewId = HelperUtil.generateId();

        if (session == null
                || student == null
                || tutorProfile == null
                || comment == null
                || strengths == null
                || improvements == null ||
                reviewedAt == null) {
            return null;
        }

        return new TutorReview.Builder()
                .setReviewId(reviewId)
                .setSession(session)
                .setStudent(student)
                .setTutorProfile(tutorProfile)
                .setRating(rating)
                .setComment(comment)
                .setStrengths(strengths)
                .setImprovements(improvements)
                .setReviewedAt(reviewedAt)
                .setIsPublic(isPublic)
                .build();
    }
}
