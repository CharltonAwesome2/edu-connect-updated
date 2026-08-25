package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.TutorReview;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/* TutorReviewFactoryTest.java
   TutorReviewFactoryTest class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date:  24 August 2026
*/
class TutorReviewFactoryTest {

    private TutorReview tutorReview = TutorReviewFactory.createTutorReview(
            1L,
            2L,
            3L,
            5,
            "Excellent tutoring session.",
            "Clear explanations and good communication.",
            "Provision of  more practice exercises.",
            LocalDateTime.now(),
            true
    );

    @Test
    void createTutorReview() {
        System.out.println(tutorReview);
    }
}