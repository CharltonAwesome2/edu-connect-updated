package za.ac.cput.service;

import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;

public interface IUserAuthService extends service<UserAuth, Long> {

    UserAuth getByUser(User user);

    UserAuth getByUserId(Long userId);

    UserAuth getByEmail(String email);

    boolean existsByUser(User user);
}