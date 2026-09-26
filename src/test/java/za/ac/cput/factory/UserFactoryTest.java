/*
    UserFactoryTest.java
    User Factory Test class
    Author: Lesego Kutlwano Tshabalala (240263952)
    Date: 26 September 2026
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    String name = "Nolwazi";
    String surname = "Zulu";
    String studentNumber = "220118876";
    String email = "nolwazi@example.com";
    String contactNumber = "0712345678";
    LocalDateTime createdAt = LocalDateTime.now();
    Boolean isTutor = false;
    Boolean isStudent = true;

    @Test
    void createUser() {
        User user = UserFactory.createUser(
                name,
                surname,
                studentNumber,
                email,
                contactNumber,
                createdAt,
                isTutor,
                isStudent);

        assertNotNull(user);
        assertNotNull(user.getUserId());
        assertEquals(name, user.getName());
        assertEquals(surname, user.getSurname());
        assertEquals(studentNumber, user.getStudentNumber());
        assertEquals(email, user.getEmail());
        assertEquals(contactNumber, user.getContactNumber());
        assertEquals(createdAt, user.getCreatedAt());
        assertEquals(isTutor, user.getIsTutor());
        assertEquals(isStudent, user.getIsStudent());
    }

    @Test
    void createUserWithNullName() {

        User user = UserFactory.createUser(
                null,
                surname,
                studentNumber,
                email,
                contactNumber,
                createdAt,
                isTutor,
                isStudent);

        assertNull(user);

    }

    @Test
    void createUserWithEmptyName() {

        User user = UserFactory.createUser(
                "",
                surname,
                studentNumber,
                email,
                contactNumber,
                createdAt,
                isTutor,
                isStudent);

        assertNull(user);

    }

    @Test
    void createUserWithNullSurname() {

        User user = UserFactory.createUser(
                name,
                null,
                studentNumber,
                email,
                contactNumber,
                createdAt,
                isTutor,
                isStudent);

        assertNull(user);

    }

    @Test
    void createUserWithEmptySurname() {

        User user = UserFactory.createUser(
                name,
                "",
                studentNumber,
                email,
                contactNumber,
                createdAt,
                isTutor,
                isStudent);

        assertNull(user);

    }

    @Test
    void createUserWithNullStudentNumber() {

        User user = UserFactory.createUser(
                name,
                surname,
                null,
                email,
                contactNumber,
                createdAt,
                isTutor,
                isStudent);

        assertNull(user);

    }

    @Test
    void createUserWithEmptyStudentNumber() {

        User user = UserFactory.createUser(
                name,
                surname,
                "",
                email,
                contactNumber,
                createdAt,
                isTutor,
                isStudent);

        assertNull(user);

    }

    @Test
    void createUserWithNullEmail() {

        User user = UserFactory.createUser(
                name,
                surname,
                studentNumber,
                null,
                contactNumber,
                createdAt,
                isTutor,
                isStudent);

        assertNull(user);

    }

    @Test
    void createUserWithEmptyEmail() {

        User user = UserFactory.createUser(
                name,
                surname,
                studentNumber,
                "",
                contactNumber,
                createdAt,
                isTutor,
                isStudent);

        assertNull(user);

    }

    @Test
    void createUserWithNullContactNumber() {

        User user = UserFactory.createUser(
                name,
                surname,
                studentNumber,
                email,
                null,
                createdAt,
                isTutor,
                isStudent);

        assertNull(user);

    }

    @Test
    void createUserWithEmptyContactNumber() {

        User user = UserFactory.createUser(
                name,
                surname,
                studentNumber,
                email,
                "",
                createdAt,
                isTutor,
                isStudent);

        assertNull(user);

    }

    @Test
    void createUserWithNullCreatedAt() {

        User user = UserFactory.createUser(
                name,
                surname,
                studentNumber,
                email,
                contactNumber,
                null,
                isTutor,
                isStudent);

        assertNull(user);

    }
}