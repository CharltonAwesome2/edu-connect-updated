package za.ac.cput.service.IService;

import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;

import java.util.List;

public interface IUserAuthService extends service<UserAuth, Long> {

    List<UserAuth> getByUser(User user);

    List<UserAuth> getByUserId(Long userId);

    List<UserAuth> getByEmail(String email);

    boolean existsByUser(User user);
}