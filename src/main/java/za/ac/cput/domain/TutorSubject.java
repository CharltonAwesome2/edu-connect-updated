package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

/**
 * TutorSubject.java
 * TutorSubject model class
 * Author: Esaile Siani Djiakeng
 * Date: 30 July 2026
 */

@Data
@Builder
@Entity
@Table(name = "tutor_subject")
public class TutorSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tutorSubjectId;

    private TutorProfile tutorProfile;
    private Subject subject;

}