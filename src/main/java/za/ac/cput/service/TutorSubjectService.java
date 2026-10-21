package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;
import za.ac.cput.repository.TutorSubjectRepository;

import java.util.List;

        /**
         * TutorSubjectService.java
         * TutoringSession model class
         * Author: Esaile Siani Djiakeng
         * Date: 21 October 2026
         */

@Service
public class TutorSubjectService implements ITutorSubjectService {

    public TutorSubjectRepository tutorSubjectRepository;

    @Autowired
    public TutorSubjectService(TutorSubjectRepository tutorSubjectRepository) {
        this.tutorSubjectRepository = tutorSubjectRepository;
    }

    @Override
    public TutorSubject create(TutorSubject tutorSubject) {
        return tutorSubjectRepository.save(tutorSubject);
    }

    @Override
    public TutorSubject read(Long aLong) {
        return tutorSubjectRepository.findById(aLong).orElse(null);
    }

    @Override
    public TutorSubject update(TutorSubject tutorSubject) {
        return tutorSubjectRepository.save(tutorSubject);
    }

    @Override
    public void delete(Long aLong) {
        tutorSubjectRepository.deleteById(aLong);
    }

    @Override
    public List<TutorSubject> getAll() {
        return tutorSubjectRepository.findAll();
    }

    @Override
    public List<TutorSubject> findByTutorSubjectId(Long tutorSubjectId) {
        return tutorSubjectRepository.findByTutorSubjectId(tutorSubjectId);
    }

    @Override
    public List<TutorSubject> findByTutorProfile(TutorProfile tutorProfile) {
        return tutorSubjectRepository.findByTutorProfile(tutorProfile);
    }

    @Override
    public List<TutorSubject> findBySubject(Subject subject) {
        return tutorSubjectRepository.findBySubject(subject);
    }
}
