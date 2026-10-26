package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.enums.NotificationType;
import za.ac.cput.service.IService.INotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    private final INotificationService notificationService;

    public NotificationController(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/create")
    public ResponseEntity<Notification> create(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.create(notification);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Notification> read(@PathVariable Long id) {
        Notification notification = notificationService.read(id);
        if (notification == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Notification> update(@RequestBody Notification notification) {
        Notification updatedNotification = notificationService.update(notification);
        if (updatedNotification == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedNotification, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        notificationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<Notification> getAll() {
        return notificationService.getAll();
    }

    @GetMapping("/by-user-id/{userId}")
    public List<Notification> getAllByUserId(@PathVariable Long userId) {
        return notificationService.getAllByUserId(userId);
    }

    @PatchMapping("/{id}/read")
    public ResponseEntity<Notification> markRead(@PathVariable Long id) {
        Notification n = notificationService.markAsRead(id);
        if (n == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    @PatchMapping("/by-user-id/{userId}/read-all")
    public ResponseEntity<Integer> markAllRead(@PathVariable Long userId) {
        return new ResponseEntity<>(notificationService.markAllAsRead(userId), HttpStatus.OK);
    }

    @PostMapping("/by-user")
    public List<Notification> getAllByUser(@RequestBody User user) {
        return notificationService.getAllByUser(user);
    }

    @GetMapping("/by-type/{type}")
    public List<Notification> getAllByType(@PathVariable NotificationType type) {
        return notificationService.getAllByType(type);
    }

    @GetMapping("/unread/by-user-id/{userId}")
    public List<Notification> getAllUnreadByUserId(@PathVariable Long userId) {
        return notificationService.getAllUnreadByUserId(userId);
    }

    @GetMapping("/unread/count/by-user-id/{userId}")
    public ResponseEntity<Long> countUnreadByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(notificationService.countUnreadByUserId(userId), HttpStatus.OK);
    }
}
