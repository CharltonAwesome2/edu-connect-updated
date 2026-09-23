/*
    NotificationFactory.java
    Notification Factory class
    Author: Nolwazi Zulu (220118876)
    Date: 05 September 2026
*/
package za.ac.cput.factory;

import java.time.LocalDateTime;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.enums.NotificationType;
import za.ac.cput.util.HelperUtil;

public class NotificationFactory {

    public static Notification createNotification(
            User user,
            String title,
            String message,
            NotificationType type,
            boolean isRead,
            LocalDateTime readAt) {

        if (user == null ||
                HelperUtil.isNullOrEmpty(title) ||
                HelperUtil.isNullOrEmpty(message) ||
                type == null ||
                readAt == null) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return new Notification.Builder()
                .setNotificationId(id)
                .setUser(user)
                .setTitle(title)
                .setMessage(message)
                .setType(type)
                .setRead(isRead)
                .setRead(isRead)
                .build();
    }
}