package za.ac.cput.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class TutorProfile {

    private Long tutorProfileId;
    private User user;
    private String bio;
    private int yearsExperience;
    private BigDecimal hourlyRate;
    private double averageRating;
    private LocalDateTime createdAt;
    
}