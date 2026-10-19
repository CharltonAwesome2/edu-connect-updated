package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

/* TutorReviewFactoryTest.java
   TutorReviewFactoryTest class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date:  24 August 2026
*/
class TutorReviewFactoryTest {

    TutoringSession tutoringSession = new TutoringSession.Builder().build();
    User student = new User.Builder().build();
    TutorProfile tutorProfile = new TutorProfile.Builder().build();
    int rating = 5;
    String comment = "Excellent tutoring session.";
    String strengths = "Clear explanations and good communication.";
    String improvements = "Provision of  more practice exercises.";
    LocalDateTime reviewedAt = LocalDateTime.now();
    boolean isPublic = false;

    @Test
    void createTutorReview() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(tutoringSession,
                student,
                tutorProfile,
                rating,
                comment,
                strengths,
                improvements,
                reviewedAt,
                isPublic);

        assertNotNull(tutorReview);
        assertNotNull(tutorReview.getReviewId());

        assertEquals(tutoringSession, tutorReview.getSession());
        assertEquals(student, tutorReview.getStudent());
        assertEquals(tutorProfile, tutorReview.getTutorProfile());
        assertEquals(rating, tutorReview.getRating());
        assertEquals(comment, tutorReview.getComment());
        assertEquals(strengths, tutorReview.getStrengths());
        assertEquals(improvements, tutorReview.getImprovements());
        assertEquals(reviewedAt, tutorReview.getReviewedAt());
        assertFalse(tutorReview.isPublic());
    }

    @Test
    void createTutorReviewWithNullTutoringSession() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(null,
                student,
                tutorProfile,
                rating,
                comment,
                strengths,
                improvements,
                reviewedAt,
                isPublic);

        assertNull(tutorReview);
    }

        @Test
    void createTutorReviewWithNullStudent() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(tutoringSession,
                null,
                tutorProfile,
                rating,
                comment,
                strengths,
                improvements,
                reviewedAt,
                isPublic);

        assertNull(tutorReview);
    }

    @Test
    void createTutorReviewWithNullTutorProfile() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(tutoringSession,
                student,
                null,
                rating,
                comment,
                strengths,
                improvements,
                reviewedAt,
                isPublic);

        assertNull(tutorReview);
    }

    @Test
    void createTutorReviewWithZeroRating() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(tutoringSession,
                student,
                tutorProfile,
                0,
                comment,
                strengths,
                improvements,
                reviewedAt,
                isPublic);

        assertNull(tutorReview);
    }

    @Test
    void createTutorReviewWithNullComment() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(tutoringSession,
                student,
                tutorProfile,
                rating,
                null,
                strengths,
                improvements,
                reviewedAt,
                isPublic);

        assertNull(tutorReview);
    }

    @Test
    void createTutorReviewWithEmptyComment() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(tutoringSession,
                student,
                tutorProfile,
                rating,
                "",
                strengths,
                improvements,
                reviewedAt,
                isPublic);

        assertNull(tutorReview);
    }

    @Test
    void createTutorReviewWithNullStrengths() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(tutoringSession,
                student,
                tutorProfile,
                rating,
                comment,
                null,
                improvements,
                reviewedAt,
                isPublic);

        assertNull(tutorReview);
    }

    @Test
    void createTutorReviewWithEmptyStrengths() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(tutoringSession,
                student,
                tutorProfile,
                rating,
                comment,
                "",
                improvements,
                reviewedAt,
                isPublic);

        assertNull(tutorReview);
    }

    @Test
    void createTutorReviewWithNullImprovements() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(tutoringSession,
                student,
                tutorProfile,
                rating,
                comment,
                strengths,
                null,
                reviewedAt,
                isPublic);

        assertNull(tutorReview);
    }

    @Test
    void createTutorReviewWithEmptyImprovements() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(tutoringSession,
                student,
                tutorProfile,
                rating,
                comment,
                strengths,
                "",
                reviewedAt,
                isPublic);

        assertNull(tutorReview);
    }

    @Test
    void createTutorReviewWithNullReviewedAt() {
        TutorReview tutorReview = TutorReviewFactory.createTutorReview(tutoringSession,
                student,
                tutorProfile,
                rating,
                comment,
                strengths,
                improvements,
                null,
                isPublic);

        assertNull(tutorReview);
    }

}