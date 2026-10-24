// SubjectRepository.java
// Subject Repository class
// Author: Reotshepile Stock (230875807)
// Date: 21 October 2026

package za.ac.cput.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import za.ac.cput.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findAllBySubjectNameContainingIgnoreCase(String keyword);

    List<Subject> findAllByDepartment(String department);

    boolean existsBySubjectName(String subjectName);

    boolean existsBySubjectCode(String subjectCode);

    Optional<Subject> findBySubjectCode(String subjectCode);

}
