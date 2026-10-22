/*
    NotificationService.java
    Notification Service class
    Author: Nolwazi Zulu (220118876)
    Date: 22 October 2026
*/

package za.ac.cput.service;

import za.ac.cput.domain.Notification;
import za.ac.cput.repository.NotificationRepository;
import za.ac.cput.repository.NotificationRepositoryImpl;

public class NotificationService {

    private final NotificationRepository repository;

    private static final NotificationService SERVICE =
            new NotificationService();

    private NotificationService() {
        repository = NotificationRepositoryImpl.getRepository();
    }

    public static NotificationService getService() {
        return SERVICE;
    }

    public Notification create(Notification notification) {
        return repository.create(notification);
    }

    public Notification read(Long id) {
        return repository.read(id);
    }

    public Notification update(Notification notification) {
        return repository.update(notification);
    }

    public boolean delete(Long id) {
        return repository.delete(id);
    }
}
