package za.ac.cput.domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

/*
    Availability.java
    Availability model class
    Author: Charlton Solomons (220483418)
    Date: 17 July 2026
*/

@Data
@Builder
@Entity
@Table(name = "availability")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availibilityId;

    private TutorProfile tutorProfile;
    private DayOfWeek dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isRecurring;

}
