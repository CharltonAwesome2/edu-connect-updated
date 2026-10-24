package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;

import java.util.List;

        /**
         * ITutorProfileRepository.java
         * TutoringSession model class
         * Author: Esaile Siani Djiakeng
         * Date: 21 October 2026
         */
public interface TutorProfileRepository extends JpaRepository<TutorProfile, Long> {

    List<TutorProfile> findByTutorProfileId(Long tutorProfileId);
    List<TutorProfile> findByUser(User user);
    List<TutorProfile> findByUser_UserId(Long userId);
}
