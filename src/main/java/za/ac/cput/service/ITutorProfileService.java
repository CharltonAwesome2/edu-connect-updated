package za.ac.cput.service;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;

import java.util.List;

        /**
         * ITutorProfileService.java
         * TutoringSession model class
         * Author: Esaile Siani Djiakeng
         * Date: 21 October 2026
         */

public interface ITutorProfileService extends service <TutorProfile, Long> {

    List<TutorProfile> findByTutorProfileId(Long tutorProfileId);
    List<TutorProfile> findByUser(User user);

}
