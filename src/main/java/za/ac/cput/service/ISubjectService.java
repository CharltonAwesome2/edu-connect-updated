package za.ac.cput.service;

import java.util.List;

import za.ac.cput.domain.Subject;

public interface ISubjectService extends service<Subject, Long> {

    Subject getBySubjectCode(String subjectCode);

    boolean existsBySubjectCode(String subjectCode);

    boolean existsBySubjectName(String subjectName);

    List<Subject> getAllByDepartment(String department);

    List<Subject> searchByName(String keyword);
}