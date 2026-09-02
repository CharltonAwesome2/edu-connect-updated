/*
    NotificationFactory.java
    Notification Factory class
    Author: Nolwazi Zulu (220118876)
    Date: 23 March 2026
    */
package za.ac.cput.factory;

import java.time.LocalDateTime;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.util.HelperUtil;

public class NotificationFactory {

    public static Notification createNotification(String message,
            boolean isRead,
            LocalDateTime createdAt,
            User user) {

        if (HelperUtil.isNullOrEmpty(message)
                || createdAt == null 
                || user == null)
            return null;

        Long notificationId = HelperUtil.generateId();

        return new Notification.Builder()
                .setNotificationId(notificationId)
                .setMessage(message)
                .setRead(isRead)
                .setCreatedAt(createdAt)
                .setUser(user)
                .build();
    }
}
