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

    @Override
    public Subject getBySubjectCode(String subjectCode) {
        return subjectRepository.findBySubjectCode(subjectCode).orElse(null);
    }

    @Override
    public boolean existsBySubjectCode(String subjectCode) {
        return subjectRepository.existsBySubjectCode(subjectCode);
    }

    @Override
    public boolean existsBySubjectName(String subjectName) {
        return subjectRepository.existsBySubjectName(subjectName);
    }

    @Override
    public List<Subject> getAllByDepartment(String department) {
        return subjectRepository.findAllByDepartment(department);
    }

    @Override
    public List<Subject> searchByName(String keyword) {
        return subjectRepository.findAllBySubjectNameContainingIgnoreCase(keyword);
    }
}