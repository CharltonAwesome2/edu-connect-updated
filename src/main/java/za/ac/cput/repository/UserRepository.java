package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByStudentNumber(String studentNumber);
    boolean existsByEmail(String email);

    boolean existsByStudentNumber(String studentNumber);

    List<User> findAllByIsTutor(Boolean isTutor);

    List<User> findAllByIsStudent(Boolean isStudent);
}
