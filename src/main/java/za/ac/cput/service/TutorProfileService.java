package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.repository.ITutorProfileRepository;
import za.ac.cput.repository.ITutoringSessionRepository;

import java.util.List;

        /**
         * TutorProfileService.java
         * TutoringSession model class
         * Author: Esaile Siani Djiakeng
         * Date: 21 October 2026
         */

@Service
public class TutorProfileService implements ITutorProfileService{

    private final ITutorProfileRepository tutorProfileRepository;

    @Autowired
    public TutorProfileService(ITutorProfileRepository tutorProfileRepository) {
        this.tutorProfileRepository = tutorProfileRepository;
    }

    @Override
    public TutorProfile create(TutorProfile tutorProfile) {
        return tutorProfileRepository.save(tutorProfile);
    }

    @Override
    public TutorProfile read(Long aLong) {
        return tutorProfileRepository.findById(aLong).orElse(null);
    }

    @Override
    public TutorProfile update(TutorProfile tutorProfile) {
        return tutorProfileRepository.save(tutorProfile);
    }

    @Override
    public void delete(Long aLong) {
        tutorProfileRepository.deleteById(aLong);
    }

    @Override
    public List<TutorProfile> getAll() {
        return tutorProfileRepository.findAll();
    }

    @Override
    public List<TutorProfile> findByTutorProfileId(Long tutorProfileId) {
        return tutorProfileRepository.findByTutorProfileId(tutorProfileId);
    }

    @Override
    public List<TutorProfile> findByUser(User user) {
        return tutorProfileRepository.findByUser(user);
    }
}
