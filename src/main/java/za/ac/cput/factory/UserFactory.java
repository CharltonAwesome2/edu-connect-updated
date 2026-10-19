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
                createdAt == null ||
                isTutor == null ||
                isStudent == null) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return User.builder()
                .userId(id)
                .name(name)
                .surname(surname)
                .studentNumber(studentNumber)
                .email(email)
                .contactNumber(contactNumber)
                .createdAt(createdAt)
                .isTutor(isTutor)
                .isStudent(isStudent)
                .build();
    }
}