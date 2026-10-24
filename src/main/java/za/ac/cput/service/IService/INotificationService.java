package za.ac.cput.service.IService;
import java.util.List;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.enums.NotificationType;

public interface INotificationService extends service<Notification, Long> {

    List<Notification> getAllByUser(User user);

    List<Notification> getAllByUserId(Long userId);

    List<Notification> getAllByType(NotificationType type);

    List<Notification> getAllUnreadByUserId(Long userId);

    long countUnreadByUserId(Long userId);

    Notification markAsRead(Long id);

    int markAllAsRead(Long userId);
}
