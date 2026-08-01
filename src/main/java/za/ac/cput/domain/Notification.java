package za.ac.cput.domain;

import java.time.LocalDateTime;

import za.ac.cput.enums.NotificationType;

public class Notification {

    private Long notificationId;
    private User user;
    private String title;
    private String message;
    private NotificationType type;
    private boolean isRead;
    private LocalDateTime readAt;

    private Notification(Builder builder) {
        this.notificationId = builder.notificationId;
        this.user = builder.user;
        this.title = builder.title;
        this.message = builder.message;
        this.type = builder.type;
        this.isRead = builder.isRead;
        this.readAt = builder.readAt;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public User getUser() {
        return user;
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

    @Override
    public String toString() {
        return "Notification [notificationId=" + notificationId + ", user=" + user + ", title=" + title + ", message="
                + message + ", type=" + type + ", isRead=" + isRead + ", readAt=" + readAt + "]";
    }

    public static class Builder {

        private Long notificationId;
        private User user;
        private String title;
        private String message;
        private NotificationType type;
        private boolean isRead;
        private LocalDateTime readAt;

        public Builder setNotificationId(Long notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
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
