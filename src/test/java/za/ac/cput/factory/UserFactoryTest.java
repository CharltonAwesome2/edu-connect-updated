package za.ac.cput.factory;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.User;

public class UserFactoryTest {

    String name = "Peter";
    String surname = "Parker";
    String studentNumber = "STUD123";
    String email = "pparker@university.com";
    String contactNumber = "0861234567";
    LocalDateTime createdAt = LocalDateTime.now();

    User user = UserFactory.createUser(name,
            surname,
            studentNumber,
            email,
            contactNumber,
            createdAt,
            true,
            null);

    @Test
    void createUser() {
        System.out.println(user);
    }
}