// /*
//     NotificationRepositoryImpl.java
//     Notification Repository Implementation class
//     Author: Nolwazi Zulu (220118876)
//     Date: 22 October 2026
// */
// package za.ac.cput.repository;

// import za.ac.cput.domain.Notification;
// import java.util.HashMap;
// import java.util.Map;

// public class NotificationRepositoryImpl implements NotificationRepository {

//     private static final NotificationRepositoryImpl REPOSITORY = new NotificationRepositoryImpl();

//     private final Map<Long, Notification> notificationDB =
//             new HashMap<>();

//     private NotificationRepositoryImpl() {
//     }

//     public static NotificationRepositoryImpl getRepository() {
//         return REPOSITORY;
//     }

//     @Override
//     public Notification create(Notification notification) {
//         if (notification == null
//                 || notification.getNotificationId() == null) {
//             return null;
//         }

//         notificationDB.put(
//                 notification.getNotificationId(), notification);

//         return notification;
//     }

//     @Override
//     public Notification read(Long id) {
//         if (id == null) {
//             return null;
//         }

//         return notificationDB.get(id);
//     }

//     @Override
//     public Notification update(Notification notification) {
//         if (notification == null
//                 || notification.getNotificationId() == null) {
//             return null;
//         }

//         Long id = notification.getNotificationId();

//         if (!notificationDB.containsKey(id)) {
//             return null;
//         }

//         notificationDB.put(id, notification);
//         return notification;
//     }

//     @Override
//     public boolean delete(Long id) {
//         if (id == null) {
//             return false;
//         }

//         return notificationDB.remove(id) != null;
//     }
// }
