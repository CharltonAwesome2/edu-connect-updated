package za.ac.cput.service.IService;

import za.ac.cput.domain.TutorReview;

import java.util.List;

/* ITutorReviewService.java
    ITutorReviewService interface
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 22 July 2026
*/

public interface ITutorReviewService extends service<TutorReview, Long> {

    List<TutorReview> findByTutorId(Long id);
    List<TutorReview> findByStudentId(Long id);
}
