
package za.ac.cput.service.IService;

import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;

import java.util.List;
import java.util.Map;

public interface IUserAuthService extends service<UserAuth, Long> {

    List<UserAuth> getByUser(User user);

    List<UserAuth> getByUserId(Long userId);

    List<UserAuth> getByEmail(String email);

    boolean existsByUser(User user);

    User register(Map<String, Object> body);

    User verifyCredentials(String email, String password);
}
