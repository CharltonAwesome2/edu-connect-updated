package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Subject.java
// Subject model class
// Author: Reotshepile Stock (230875807)
// Date: 23 July 2026

@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    
    private String subjectName;
    private String subjectCode;
    private String department;
    
}
