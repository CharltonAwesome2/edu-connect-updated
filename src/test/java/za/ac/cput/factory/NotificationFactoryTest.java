/*
    NotificationFactoryTest.java
    Notification Factory Test class
    Author: Nolwazi Zulu (220118876)
    Date: 09 September 2026
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.enums.NotificationType;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

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

    String title = "Notification of approval";
    String message = "Your tutoring session has been approved.";
    NotificationType type = NotificationType.SESSION_UPDATE;
    boolean isRead = false;
    LocalDateTime readAt = LocalDateTime.now();

    @Test
    void createNotification() {
        Notification notification = NotificationFactory.createNotification(
                user,
                title,
                message,
                type,
                false,
                readAt);

        assertNotNull(notification);
        assertNotNull(notification.getNotificationId());
        assertEquals(user, notification.getUser());
        assertEquals(title, notification.getTitle());
        assertEquals(message, notification.getMessage());
        assertEquals(type, notification.getType());
        assertFalse(notification.isRead());
        assertEquals(readAt, notification.getReadAt());
    }

    @Test
    void createNotificationWithNullUser() {

        Notification notification = NotificationFactory.createNotification(
                null,
                title,
                message,
                type,
                false,
                readAt);

        assertNull(notification);

    }

    @Test
    void createNotificationWithNullTitle() {

        Notification notification = NotificationFactory.createNotification(
                user,
                null,
                message,
                type,
                false,
                readAt);

        assertNull(notification);

    }

    @Test
    void createNotificationWithEmptyTitle() {

        Notification notification = NotificationFactory.createNotification(
                user,
                "",
                message,
                type,
                false,
                readAt);

        assertNull(notification);

    }

    @Test
    void createNotificationWithNullMessage() {

        Notification notification = NotificationFactory.createNotification(
                user,
                title,
                null,
                type,
                false,
                readAt);

        assertNull(notification);

    }

    @Test
    void createNotificationWithEmptyMessage() {

        Notification notification = NotificationFactory.createNotification(
                user,
                title,
                "",
                type,
                false,
                readAt);

        assertNull(notification);

    }

    @Test
    void createNotificationWithNullType() {

        Notification notification = NotificationFactory.createNotification(
                user,
                title,
                message,
                null,
                false,
                readAt);

        assertNull(notification);

    }
}