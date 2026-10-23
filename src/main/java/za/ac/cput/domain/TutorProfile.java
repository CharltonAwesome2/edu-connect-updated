package za.ac.cput.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TutorProfile.java
 * TutorProfile model class
 * Author: Esaile Siani Djiakeng
 * Date: 30 July 2026
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tutor_profile")
public class TutorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tutorProfileId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String bio;
    private int yearsExperience;
    private BigDecimal hourlyRate;
    private double averageRating;
    private LocalDateTime createdAt;
    private boolean isVerified;

}