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
import za.ac.cput.enums.NotificationType;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    User user = new User.Builder()
            .setName("Nolwazi")
            .setSurname("Zulu")
            .setStudentNumber("220118876")
            .setEmail("nolwazi@example.com")
            .setContactNumber("0712345678")
            .setCreatedAt(LocalDateTime.now())
            .setIsTutor(false)
            .setIsStudent(true)
            .build();

    String title = "Notification title";
    String message = "Notification message";
    NotificationType type = NotificationType.BOOKING_CONFIRMATION;
    LocalDateTime readAt = LocalDateTime.now();

    private Notification notification = NotificationFactory.createNotification(user,
            title,
            message,
            type,
            false,
            readAt);

    @Test
    void createNotification() {

        assertNotNull(notification);
        assertEquals("Your tutoring session has been approved.", notification.getMessage());
        assertFalse(notification.isRead());
        assertEquals(user, notification.getUser());
        assertNotNull(notification.getNotificationId());
    }
}