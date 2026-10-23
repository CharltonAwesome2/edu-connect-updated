package za.ac.cput.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

/**
 * TutorProfile.java
 * TutorProfile model class
 * Author: Esaile Siani Djiakeng
 * Date: 30 July 2026
 */

@Data
@Builder
@Entity
@Table(name = "tutor_profile")
public class TutorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tutorProfileId;

    private User user;
    private String bio;
    private int yearsExperience;
    private BigDecimal hourlyRate;
    private double averageRating;
    private LocalDateTime createdAt;

}