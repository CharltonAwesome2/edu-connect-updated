/*
    NotificationFactory.java
    Notification Factory class
    Author: Nolwazi Zulu (220118876)
    Date: 05 September 2026
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.util.HelperUtil;

public class NotificationFactory {

    public static Notification createNotification(String message,
        boolean isRead,
        User user) {

    if (!HelperUtil.isNullOrEmpty(message)
            || user == null) {
        return null;
    }

    Long notificationId = HelperUtil.generateId();

    return new Notification.Builder()
            .setNotificationId(notificationId)
            .setMessage(message)
            .setRead(isRead)
            .setUser(user)
            .build();
 }
}