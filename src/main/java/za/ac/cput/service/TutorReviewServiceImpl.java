package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
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

    @Autowired
    public TutorReviewServiceImpl(TutorReviewRepository tutorReviewRepository) {
        this.tutorReviewRepository = tutorReviewRepository;
    }

    @Override
    public TutorReview create(TutorReview tutorReview) {
        return tutorReviewRepository.save(tutorReview);
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByStudentId'");
    }

    @Override
    public List<TutorReview> findByTutorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByTutorId'");
    }
}
