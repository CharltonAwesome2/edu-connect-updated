package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.enums.NotificationType;
import za.ac.cput.repository.TutorReviewRepository;
import za.ac.cput.service.IService.ITutorReviewService;

import java.util.List;

/* TutorReviewServiceImpl.java
    TutorReviewServiceImpl class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/

@Service
public class TutorReviewServiceImpl implements ITutorReviewService {

    private final TutorReviewRepository tutorReviewRepository;
    private final NotificationService notificationService;

    @Autowired
    public TutorReviewServiceImpl(TutorReviewRepository tutorReviewRepository,
                                  NotificationService notificationService) {
        this.tutorReviewRepository = tutorReviewRepository;
        this.notificationService = notificationService;
    }

    @Override
    @Transactional
    public TutorReview create(TutorReview tutorReview) {
        TutorReview saved = tutorReviewRepository.save(tutorReview);

        if (saved.getTutorProfile() != null && saved.getTutorProfile().getUser() != null) {
            notificationService.create(Notification.builder()
                    .user(saved.getTutorProfile().getUser())
                    .title("New review received")
                    .message("A student left you a " + saved.getRating() + "-star review.")
                    .type(NotificationType.REVIEW_RECEIVED)
                    .isRead(false)
                    .build());
        }

        return saved;
    }

    @Override
    public TutorReview read(Long id) {
        return tutorReviewRepository.findById(id).orElse(null);
    }

    @Override
    public TutorReview update(TutorReview tutorReview) {
        return tutorReviewRepository.save(tutorReview);
    }

    @Override
    public void delete(Long id) {
        tutorReviewRepository.deleteById(id);
    }

    @Override
    public List<TutorReview> getAll() {
        return tutorReviewRepository.findAll();
    }

    @Override
    public TutorReview getBySession(TutoringSession session) {
        return tutorReviewRepository.findBySession(session).orElse(null);
    }

    @Override
    public boolean existsBySession(TutoringSession session) {
        return tutorReviewRepository.existsBySession(session);
    }

    @Override
    public List<TutorReview> getAllByStudent(User student) {
        return tutorReviewRepository.findAllByStudent(student);
    }

    @Override
    public List<TutorReview> getAllByStudentId(Long userId) {
        return tutorReviewRepository.findAllByStudent_UserId(userId);
    }

    @Override
    public List<TutorReview> getAllByTutorProfile(TutorProfile tutorProfile) {
        return tutorReviewRepository.findAllByTutorProfile(tutorProfile);
    }

    @Override
    public List<TutorReview> getAllPublicByTutorProfile(TutorProfile tutorProfile) {
        return tutorReviewRepository.findAllPublicByTutorProfile(tutorProfile);
    }

    @Override
    public List<TutorReview> getAllByTutorProfileWithMinRating(TutorProfile tutorProfile, int minRating) {
        return tutorReviewRepository.findAllByTutorProfileAndRatingGreaterThanEqual(tutorProfile, minRating);
    }

    @Override
    public double getAverageRating(TutorProfile tutorProfile) {
        Double average = tutorReviewRepository.findAverageRatingByTutorProfile(tutorProfile);
        return average == null ? 0.0 : average;
    }

    @Override
    public long countByTutorProfile(TutorProfile tutorProfile) {
        return tutorReviewRepository.countByTutorProfile(tutorProfile);
    }

    @Override
    public List<TutorReview> findByStudentId(Long id) {
        return tutorReviewRepository.findAllByStudent_UserId(id);
    }

    @Override
    public List<TutorReview> findByTutorId(Long id) {
        return tutorReviewRepository.findAllByTutorProfile_TutorProfileId(id);
    }
}