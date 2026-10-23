
/*
  NotificationServiceTest.java
  Notification Service Test class 
  Author: Nolwazi Zulu (220118876)
  Date: 22 October 2026

 */

package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.factory.NotificationFactory;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    private NotificationService service;
    private Notification notification;

    @BeforeEach
    void setUp() {
        service = NotificationService.getService();

        User user = new User.Builder().build();

        notification = NotificationFactory.createNotification(
                "Test notification",
                false,
                user
        );
    }

    @Test
    void create() {
        assertNotNull(
                notification,
                "Factory should create a notification"
        );

        Notification result = service.create(notification);

        assertNotNull(result);

        assertEquals(
                notification.getNotificationId(),
                result.getNotificationId()
        );
    }

    @Test
    void read() {
        assertNotNull(
                notification,
                "Factory should create a notification"
        );

        service.create(notification);

        Notification result = service.read(
                notification.getNotificationId()
        );

        assertNotNull(result);

        assertEquals(
                "Test notification",
                result.getMessage()
        );
    }

    @Test
    void update() {
        assertNotNull(
                notification,
                "Factory should create a notification"
        );

        service.create(notification);

        Notification updated = new Notification.Builder()
                .setNotificationId(
                        notification.getNotificationId()
                )
                .setUser(notification.getUser())
                .setMessage("Updated notification")
                .setRead(true)
                .build();

        Notification result = service.update(updated);

        assertNotNull(result);

        assertEquals(
                "Updated notification",
                result.getMessage()
        );

        assertTrue(result.isRead());
    }

    @Test
    void delete() {
        assertNotNull(
                notification,
                "Factory should create a notification"
        );

        service.create(notification);

        Long id = notification.getNotificationId();

        assertTrue(service.delete(id));

        assertNull(service.read(id));
    }
}
