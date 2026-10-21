package za.ac.cput.service;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;

import java.util.List;

        /**
         * ITutoringSessionService.java
         * TutoringSession model class
         * Author: Esaile Siani Djiakeng
         * Date: 21 October 2026
         */

public interface ITutoringSessionService extends service <TutoringSession, Long> {

    List<TutoringSession> findByTutoringSessionId(Long tutoringSessionId);
    List<TutoringSession> findByTutorProfile(TutorProfile tutorProfile);
    List<TutoringSession> findByStudent(User student);

}
