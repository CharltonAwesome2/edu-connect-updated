package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.repository.TutoringSessionRepository;

import java.util.List;

        /**
         * TutoringSessionService.java
         * TutoringSession model class
         * Author: Esaile Siani Djiakeng
         * Date: 21 October 2026
         */

@Service
public class TutoringSessionService implements ITutoringSessionService{

    private final TutoringSessionRepository tutoringSessionRepository;

    @Autowired
    public TutoringSessionService(TutoringSessionRepository tutoringSessionRepository) {
        this.tutoringSessionRepository = tutoringSessionRepository;
    }

    @Override
    public TutoringSession create(TutoringSession session) {

        return tutoringSessionRepository.save(session);
    }

    @Override
    public TutoringSession read(Long aLong) {
        return tutoringSessionRepository.findById(aLong).orElse(null);
    }

    @Override
    public TutoringSession update(TutoringSession session) {
        return tutoringSessionRepository.save(session);
    }

    @Override
    public void delete(Long aLong) {
        tutoringSessionRepository.deleteById(aLong);
    }

    @Override
    public List<TutoringSession> getAll() {
        return tutoringSessionRepository.findAll();
    }

    @Override
    public List<TutoringSession> findByTutoringSessionId(Long tutoringSessionId) {
        return tutoringSessionRepository.findByTutoringSessionId(tutoringSessionId);
    }

    @Override
    public List<TutoringSession> findByTutorProfile(TutorProfile tutorProfile) {
        return tutoringSessionRepository.findByTutorProfile(tutorProfile);
    }

    @Override
    public List<TutoringSession> findByStudent(User student) {
        return  tutoringSessionRepository.findByStudent(student);
    }
}
