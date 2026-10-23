package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.TutorReview;

import java.util.List;

/* TutorReviewRepository.java
    TutorReviewRepository interface
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/

public interface TutorReviewRepository extends JpaRepository<TutorReview, Long> {

    List<TutorReview> findByTutorId(Long id);
    List<TutorReview> findByStudentId(Long id);
}
