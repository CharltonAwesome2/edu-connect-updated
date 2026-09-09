package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;

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

    private TutorReview tutorReview = TutorReviewFactory.createTutorReview(
            tutoringSession,
            student,
            tutorProfile,
            5,
            "Excellent tutoring session.",
            "Clear explanations and good communication.",
            "Provision of  more practice exercises.",
            LocalDateTime.now(),
            true);

    @Test
    void createTutorReview() {
        System.out.println(tutorReview);
    }
}