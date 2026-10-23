/*
    NotificationRepository.java
    Notification Repository interface
    Author: Nolwazi Zulu (220118876)
    Date: 22 October 2026
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
