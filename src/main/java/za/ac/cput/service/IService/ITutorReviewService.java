package za.ac.cput.service.IService;

import za.ac.cput.domain.TutorReview;

import java.util.List;

/* ITutorReviewService.java
    ITutorReviewService interface
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/


import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;

public interface ITutorReviewService extends service<TutorReview, Long> {

    TutorReview getBySession(TutoringSession session);

    boolean existsBySession(TutoringSession session);

    List<TutorReview> getAllByStudent(User student);

    List<TutorReview> getAllByStudentId(Long userId);

    List<TutorReview> getAllByTutorProfile(TutorProfile tutorProfile);

    List<TutorReview> getAllPublicByTutorProfile(TutorProfile tutorProfile);

    List<TutorReview> getAllByTutorProfileWithMinRating(TutorProfile tutorProfile, int minRating);

    double getAverageRating(TutorProfile tutorProfile);

    long countByTutorProfile(TutorProfile tutorProfile);
}
