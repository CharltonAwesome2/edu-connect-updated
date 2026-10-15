/*
    UserAuthFactoryTest.java
    UserAuth Factory Test class
    Author: Lesego Kutlwano Tshabalala (240263952)
    Date: 26 September 2026
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserAuthFactoryTest {

    User user = new User.Builder()
            .setUserId(1L)
            .setName("Nolwazi")
            .setSurname("Zulu")
            .setStudentNumber("220118876")
            .setEmail("nolwazi@example.com")
            .setContactNumber("0712345678")
            .setCreatedAt(LocalDateTime.now())
            .setIsTutor(false)
            .setIsStudent(true)
            .build();

    String password = "Password123!";
    LocalDateTime lastLogin = LocalDateTime.now();

    @Test
    void createUserAuth() {
        UserAuth userAuth = UserAuthFactory.createUserAuth(
                password,
                user,
                lastLogin);

        assertNotNull(userAuth);
        assertNotNull(userAuth.getAuthId());
        assertNotNull(userAuth.getPasswordHash());
        assertNotEquals(password, userAuth.getPasswordHash());
        assertEquals(user, userAuth.getUser());
        assertEquals(lastLogin, userAuth.getLastLogin());
    }

    @Test
    void createUserAuthWithNullPassword() {

        UserAuth userAuth = UserAuthFactory.createUserAuth(
                null,
                user,
                lastLogin);

        assertNull(userAuth);

    }

    @Test
    void createUserAuthWithEmptyPassword() {

        UserAuth userAuth = UserAuthFactory.createUserAuth(
                "",
                user,
                lastLogin);

        assertNull(userAuth);

    }

    @Test
    void createUserAuthWithNullUser() {

        UserAuth userAuth = UserAuthFactory.createUserAuth(
                password,
                null,
                lastLogin);

        assertNull(userAuth);

    }

    @Test
    void createUserAuthWithNullLastLogin() {

        UserAuth userAuth = UserAuthFactory.createUserAuth(
                password,
                user,
                null);

        assertNull(userAuth);

    }
}