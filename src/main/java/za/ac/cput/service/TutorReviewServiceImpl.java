package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.repository.TutorReviewRepository;

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
}
