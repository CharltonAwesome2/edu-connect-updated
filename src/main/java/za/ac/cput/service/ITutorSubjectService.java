package za.ac.cput.service;

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

public interface ITutorSubjectService extends service<TutorSubject, Long>{

    List<TutorSubject> findByTutorSubjectId(Long tutorSubjectId);
    List<TutorSubject> findByTutorProfile(TutorProfile tutorProfile);
    List<TutorSubject> findBySubject(Subject subject);
}
