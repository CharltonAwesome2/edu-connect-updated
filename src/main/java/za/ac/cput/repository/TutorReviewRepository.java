package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

/*
    TutorReviewRepository.java
    TutorReviewRepository interface
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/

public interface TutorReviewRepository extends JpaRepository<TutorReview, Long> {

    List<TutorReview> findAllByTutorProfile_TutorProfileId(Long id);

    List<TutorReview> findAllByStudent_UserId(Long id);

    Optional<TutorReview> findBySession(TutoringSession session);

    boolean existsBySession(TutoringSession session);

    List<TutorReview> findAllByStudent(User student);

    List<TutorReview> findAllByTutorProfile(TutorProfile tutorProfile);

    List<TutorReview> findAllPublicByTutorProfile(TutorProfile tutorProfile);

    List<TutorReview> findAllByTutorProfileAndRatingGreaterThanEqual(
            TutorProfile tutorProfile, int minRating);

    Double findAverageRatingByTutorProfile(TutorProfile tutorProfile);

    long countByTutorProfile(TutorProfile tutorProfile);
}