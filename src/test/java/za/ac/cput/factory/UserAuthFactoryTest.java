/*
    UserAuthFactoryTest.java
    UserAuth Factory Test class
    Author: Lesego Kutlwano Tshabalala (240263952)
    Date: 26 September 2026
*/
package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.util.HelperUtil;

class UserAuthFactoryTest {

    User user = User.builder()
            .userId(1L)
            .name("Nolwazi")
            .surname("Zulu")
            .studentNumber("220118876")
            .email("nolwazi@example.com")
            .contactNumber("0712345678")
            .createdAt(LocalDateTime.now())
            .isTutor(false)
            .isStudent(true)
            .build();

    String password = "Password123!";
    LocalDateTime lastLogin = LocalDateTime.now();

    @Test
    void createUserAuth() {
        UserAuth userAuth = UserAuthFactory.createUserAuth(password, user, lastLogin);

        assertNotNull(userAuth);
        assertNotNull(userAuth.getUserAuthId());

        assertTrue(HelperUtil.verifyPassword(password, userAuth.getPasswordHash()));
        assertEquals(user, userAuth.getUser());
        assertEquals(lastLogin, userAuth.getLastLogin());
    }

    @Test
    void createUserAuthWithNullPassword() {
        UserAuth userAuth = UserAuthFactory.createUserAuth(null, user, lastLogin);
        assertNull(userAuth);
    }

    @Test
    void createUserAuthWithEmptyPassword() {
        UserAuth userAuth = UserAuthFactory.createUserAuth("", user, lastLogin);
        assertNull(userAuth);
    }

    @Test
    void createUserAuthWithNullUser() {
        UserAuth userAuth = UserAuthFactory.createUserAuth(password, null, lastLogin);
        assertNull(userAuth);
    }

    @Test
    void createUserAuthWithNullLastLogin() {
        UserAuth userAuth = UserAuthFactory.createUserAuth(password, user, null);
        assertNull(userAuth);
    }
}