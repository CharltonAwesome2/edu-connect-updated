package za.ac.cput.domain;

import java.time.LocalDateTime;
// import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

/* TutorReview.java
    TutorReview class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

@Data
@Builder
@Entity
@Table(name = "tutor_review")
public class TutorReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tutorReviewId;

    private TutoringSession session;
    private User student;
    private TutorProfile tutorProfile;
    private int rating;
    private String comment;
    private String strengths;
    private String improvements;
    private LocalDateTime reviewedAt;
    private boolean isPublic;

}