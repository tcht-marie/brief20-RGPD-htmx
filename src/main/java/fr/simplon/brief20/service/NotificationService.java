package fr.simplon.brief20.service;

import fr.simplon.brief20.model.Notification;
import java.util.List;
import java.util.Optional;

public interface NotificationService {
    Notification saveNotification(Notification notification);
    Optional<Notification> findById(Long id);
    List<Notification> findAll();
    List<Notification> findByUserId(Long userId);
    List<Notification> findUnread();
    void deleteNotification(Long id);
}
