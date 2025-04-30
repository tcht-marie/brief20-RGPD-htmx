package fr.simplon.brief20.controller;

import fr.simplon.brief20.model.Notification;
import fr.simplon.brief20.service.NotificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public String listNotifications(Model model) {
        List<Notification> notifications = notificationService.findAll();
        model.addAttribute("notifications", notifications);
        return "pages/notifications/list";
    }

    @PostMapping("/mark-read/{id}")
    public String markAsRead(@PathVariable Long id) {
        notificationService.findById(id).ifPresent(n -> {
            n.setRead(true);
            notificationService.saveNotification(n);
        });
        return "redirect:/notifications";
    }

    @PostMapping("/delete/{id}")
    public String deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return "redirect:/notifications";
    }
}
