package za.ac.cput.domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

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
public class Availability {

    private Long availibilityId;
    private TutorProfile tutorProfile;
    private DayOfWeek dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isRecurring;
    
}
