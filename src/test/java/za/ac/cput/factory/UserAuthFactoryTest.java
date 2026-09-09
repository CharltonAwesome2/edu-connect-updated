package za.ac.cput.factory;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;

class UserAuthFactoryTest {

    private String password = "HashedPassword";
    private User user = new User.Builder().build();
    private LocalDateTime lastLogin = LocalDateTime.now();

    UserAuth userAuth = UserAuthFactory.createUserAuth(password, user, lastLogin);

    @Test
    void createUserAuth() {
        System.out.println(userAuth);
    }
}