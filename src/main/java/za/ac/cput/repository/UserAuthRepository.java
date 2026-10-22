package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.domain.User;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

        Optional<UserAuth> findByUser(User user);

        Optional<UserAuth> findByUser_UserId(Long userId);

        Optional<UserAuth> findByUser_Email(String email);

        boolean existsByUser(User user);
}
