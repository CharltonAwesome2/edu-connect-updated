/*
    NotificationService.java
    Notification Service class
    Author: Nolwazi Zulu (220118876)
    Date: 22 October 2026
*/

package za.ac.cput.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.Notification;
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
}
