package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;

import java.util.List;

        /**
         * ITutorSubjectRepository.java
         * TutoringSession model class
         * Author: Esaile Siani Djiakeng
         * Date: 21 October 2026
         */
public interface TutorSubjectRepository  extends JpaRepository<TutorSubject, Long> {

    List<TutorSubject> findByTutorSubjectId(Long tutorSubjectId);
    List<TutorSubject> findByTutorProfile(TutorProfile tutorProfile);
    List<TutorSubject> findByTutorProfile_TutorProfileId(Long tutorProfileId);
    List<TutorSubject> findBySubject(Subject subject);
    List<TutorSubject> findBySubject_SubjectId(Long subjectId);
}
