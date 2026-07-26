package za.ac.cput.domain;

import java.time.LocalDateTime;

public class Notification {

    private Long notificationId;
    private Long userId;
    private String title;
    private String message;
    private NotificationType type;
    private boolean isRead;
    private LocalDateTime readAt;

    private Notification() {
    }

    private Notification(Builder builder) {
        this.notificationId = builder.notificationId;
        this.userId = builder.userId;
        this.title = builder.title;
        this.message = builder.message;
        this.type = builder.type;
        this.isRead = builder.isRead;
        this.readAt = builder.readAt;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getType() {
        return type;
    }

    public boolean isRead() {
        return isRead;
    }

    public LocalDateTime getReadAt() {
        return readAt;
    }

    public static class Builder {

        private Long notificationId;
        private Long userId;
        private String title;
        private String message;
        private NotificationType type;
        private boolean isRead;
        private LocalDateTime readAt;

        public Builder setNotificationId(Long notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setType(NotificationType type) {
            this.type = type;
            return this;
        }

        public Builder setRead(boolean read) {
            isRead = read;
            return this;
        }

        public Builder setReadAt(LocalDateTime readAt) {
            this.readAt = readAt;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
