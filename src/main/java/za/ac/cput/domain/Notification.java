package za.ac.cput.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import za.ac.cput.enums.NotificationType;


@Data 
@Builder
public class Notification {

    private Long notificationId;
    private User user;
    private String title;
    private String message;
    private NotificationType type;
    private boolean isRead;
    private LocalDateTime readAt;

}
