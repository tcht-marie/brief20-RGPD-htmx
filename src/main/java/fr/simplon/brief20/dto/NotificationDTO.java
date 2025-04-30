package fr.simplon.brief20.dto;

import java.time.LocalDateTime;

import fr.simplon.brief20.model.Notification;
import lombok.Data;

@Data
public class NotificationDTO {
    private Long id;
    private Long userId;
    private String message;
    private boolean read;
    private LocalDateTime createdAt;
    private Notification.Type type;
}
