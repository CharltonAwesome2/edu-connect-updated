package za.ac.cput.domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    Availability.java
    Availability model class
    Author: Charlton Solomons (220483418)
    Date: 17 July 2026
*/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "availability")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availabilityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_profile_id")
    private TutorProfile tutorProfile;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isRecurring;

}
