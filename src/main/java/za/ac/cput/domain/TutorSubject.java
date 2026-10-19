package za.ac.cput.domain;

import lombok.Builder;
import lombok.Data;

/**
 * TutorSubject.java
 * TutorSubject model class
 * Author: Edu Connect Team
 * Date: 30 July 2026
 */

@Data 
@Builder
public class TutorSubject {

    private Long tutorSubjectId;
    private TutorProfile tutorProfile;
    private Subject subject;
    
}