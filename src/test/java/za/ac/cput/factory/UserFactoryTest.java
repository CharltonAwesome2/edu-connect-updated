package za.ac.cput.factory;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import za.ac.cput.domain.User;

public class UserFactoryTest {

    String name = "Peter";
    String surname = "Parker";
    String studentNumber = "STUD123";
    String email = "pparker@university.com";
    String contactNumber = "0861234567";
    LocalDateTime createdAt = LocalDateTime.now();
    boolean isTutor = true;
    boolean isStudent = false;

    @Test
    void createUser() {
        User user = UserFactory.createUser(name,
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
        assertTrue(user.getIsTutor());
        assertFalse(user.getIsStudent());
    }

    @Test
    void createUserWithNullName() {
        User user = UserFactory.createUser(null,
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
        User user = UserFactory.createUser("",
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
        User user = UserFactory.createUser(name,
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
        User user = UserFactory.createUser(name,
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
        User user = UserFactory.createUser(name,
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
        User user = UserFactory.createUser(name,
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
        User user = UserFactory.createUser(name,
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
        User user = UserFactory.createUser(name,
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
        User user = UserFactory.createUser(name,
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
        User user = UserFactory.createUser(name,
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
        User user = UserFactory.createUser(name,
                surname,
                studentNumber,
                email,
                contactNumber,
                null,
                isTutor,
                isStudent);

        assertNull(user);
    }

    @Test
    void createUserWithNullTutorBoolean() {
        User user = UserFactory.createUser(name,
                surname,
                studentNumber,
                email,
                contactNumber,
                createdAt,
                null,
                isStudent);

        assertNull(user);
    }

    @Test
    void createUserWithNullStudentBoolean() {
        User user = UserFactory.createUser(name,
                surname,
                studentNumber,
                email,
                contactNumber,
                createdAt,
                isTutor,
                null);

        assertNull(user);
    }
}