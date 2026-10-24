/*
    NotificationRepository.java
    Notification Repository interface
    Author: Nolwazi Zulu (220118876)
    Date: 22 October 2026
*/
package za.ac.cput.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.enums.NotificationType;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByType(NotificationType type);

    List<Notification> findAllByUser_UserIdAndIsReadFalse(Long userId);

    long countByUser_UserIdAndIsReadFalse(Long userId);

    List<Notification> findAllByUser(User user);

    List<Notification> findAllByUser_UserId(Long userId);

    List<Notification> findAllByUser_UserIdAndReadFalse(Long userId);

    long countByUser_UserIdAndReadFalse(Long userId);
}