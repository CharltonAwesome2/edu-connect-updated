/*
    NotificationService.java
    Notification Service class
    Author: Nolwazi Zulu (220118876)
    Date: 22 October 2026
*/

package za.ac.cput.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.enums.NotificationType;
import za.ac.cput.repository.NotificationRepository;
import za.ac.cput.service.IService.INotificationService;

@Service
public class NotificationService implements INotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification read(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @Override
    public Notification update(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> getAllByUser(User user) {
        return notificationRepository.findAllByUser(user);
    }

    // @Override
    // public List<Notification> getAllByUserId(Long userId) {
    //     return notificationRepository.findAllByUser_UserId(userId);
    // }

    @Override
    public List<Notification> getAllByType(NotificationType type) {
        return notificationRepository.findAllByType(type);
    }

    @Override
    public Notification markAsRead(Long id) {
        Notification notification = notificationRepository.findById(id).orElse(null);
        if (notification == null) {
            return null;
        }
        if (!notification.isRead()) {
            notification.setRead(true);
            notification.setReadAt(LocalDateTime.now());
            return notificationRepository.save(notification);
        }
        return notification;
    }

    @Override
    public int markAllAsRead(Long userId) {
        List<Notification> unread = notificationRepository.findAllByUser_UserIdAndReadFalse(userId);

        LocalDateTime now = LocalDateTime.now();

        for (Notification notification : unread) {
            notification.setRead(true);
            notification.setReadAt(now);
        }

        notificationRepository.saveAll(unread);
        return unread.size();
    }

    @Override
    public List<Notification> getAllUnreadByUserId(Long userId) {
        return notificationRepository.findAllByUser_UserIdAndIsReadFalse(userId);
    }

    @Override
    public long countUnreadByUserId(Long userId) {
        return notificationRepository.countByUser_UserIdAndIsReadFalse(userId);
    }

    @Override
    public List<Notification> getAllByUserId(Long userId) {
        return notificationRepository.findAllByUser_UserId(userId);
    }
}
