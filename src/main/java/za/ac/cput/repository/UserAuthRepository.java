
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.domain.User;

import java.util.List;

public interface UserAuthRepository
        extends JpaRepository<UserAuth, Long> {

    List<UserAuth> findByUser(User user);

    List<UserAuth> findByUser_UserId(Long userId);

    List<UserAuth> findByUser_Email(String email);

    boolean existsByUser(User user);
}
