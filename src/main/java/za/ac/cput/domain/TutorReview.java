package za.ac.cput.domain;

import java.time.LocalDateTime;
// import java.util.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* TutorReview.java
    TutorReview class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 19 July 2026
*/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tutor_review")
public class TutorReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tutorReviewId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private TutoringSession session;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_profile_id")
    private TutorProfile tutorProfile;

    private int rating;
    private String comment;
    private String strengths;
    private String improvements;
    private LocalDateTime reviewedAt;
    private boolean isPublic;

}