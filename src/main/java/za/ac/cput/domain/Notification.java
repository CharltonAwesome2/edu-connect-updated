package za.ac.cput.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import za.ac.cput.enums.NotificationType;

@Data
@Builder
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    private User user;
    private String title;
    private String message;
    private NotificationType type;
    private boolean isRead;
    private LocalDateTime readAt;

}
