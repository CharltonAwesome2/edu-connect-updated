package za.ac.cput.service.IService;

import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;

import java.util.List;

        /**
         * ITutorSubjectService.java
         * TutoringSession model class
         * Author: Esaile Siani Djiakeng
         * Date: 21 October 2026
         */

public interface ITutorSubjectService extends service<TutorSubject, Long> {

    List<TutorSubject> findByTutorSubjectId(Long tutorSubjectId);
    List<TutorSubject> findByTutorProfile(TutorProfile tutorProfile);
    List<TutorSubject> findByTutorProfileId(Long tutorProfileId);
    List<TutorSubject> findBySubject(Subject subject);
    List<TutorSubject> findBySubjectId(Long subjectId);
}
