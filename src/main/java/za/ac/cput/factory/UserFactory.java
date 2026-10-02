package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;

/**
 * userFactory.java
 * Factory class for creating User objects
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 06 August 2026
 */

public class UserFactory {
    public static User createUser(String name,
            String surname,
            String studentNumber,
            String email,
            String contactNumber,
            LocalDateTime createdAt,
            Boolean isTutor,
            Boolean isStudent) {

        if (HelperUtil.isNullOrEmpty(name) ||
                HelperUtil.isNullOrEmpty(surname) ||
                HelperUtil.isNullOrEmpty(studentNumber) ||
                HelperUtil.isNullOrEmpty(email) ||
                HelperUtil.isNullOrEmpty(contactNumber) ||
                createdAt == null) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return new User.Builder()
                .setUserId(id)
                .setName(name)
                .setSurname(surname)
                .setStudentNumber(studentNumber)
                .setEmail(email)
                .setContactNumber(contactNumber)
                .setCreatedAt(createdAt)
                .setIsTutor(isTutor)
                .setIsStudent(isStudent)
                .build();
    }
}