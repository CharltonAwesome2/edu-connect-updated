// SubjectService.java
// Subject service class
// Author: Reotshepile Stock (230875807)
// Date: 21 Oct 2026


package za.ac.cput.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.Subject;
import za.ac.cput.repository.SubjectRepository;
import za.ac.cput.service.IService.ISubjectService;

@Service
public class SubjectService implements ISubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject read(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }
}
