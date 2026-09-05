/*
    NotificationFactoryTest.java
    Notification Factory Test class
    Author: Nolwazi Zulu (220118876)
    Date: 05 September 2026
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    private final User user = new User.Builder()
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

    @Test
    void createNotification() {
        Notification notification = NotificationFactory.createNotification(
                "Your tutoring session has been approved.",
                false,
                user
        );

        assertNotNull(notification);
        assertEquals("Your tutoring session has been approved.", notification.getMessage());
        assertFalse(notification.isRead());
        assertEquals(user, notification.getUser());
        assertNotNull(notification.getNotificationId());
    }
}