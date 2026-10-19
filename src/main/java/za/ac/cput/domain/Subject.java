package za.ac.cput.domain;

import lombok.Builder;
import lombok.Data;

// Subject.java
// Subject model class
// Author: Reotshepile Stock (230875807)
// Date: 23 July 2026

@Data 
@Builder
public class Subject {

    private Long subjectId;
    private String subjectName;
    private String subjectCode;
    private String department;
    
}
