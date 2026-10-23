package za.ac.cput.service.IService;

import java.util.List;

import za.ac.cput.domain.User;

public interface IUserService extends service<User, Long> {

    User getByEmail(String email);

    User getByStudentNumber(String studentNumber);

    boolean existsByEmail(String email);

    boolean existsByStudentNumber(String studentNumber);

    List<User> getAllTutors();

    List<User> getAllStudents();
}
