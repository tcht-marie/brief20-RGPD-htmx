package fr.simplon.brief20.controller;

import fr.simplon.brief20.dto.CreateMeetingDTO;
import fr.simplon.brief20.model.Meeting;
import fr.simplon.brief20.service.MeetingService;
import fr.simplon.brief20.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/meetings")
public class MeetingController {
    private final MeetingService meetingService;
    private final UserService userService;

    @GetMapping
    public String listMeetings(Model model) {
        List<Meeting> meetings = meetingService.findAll();
        model.addAttribute("meetings", meetings);
        return "pages/meetings/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("meeting", CreateMeetingDTO.builder().build());
        return "pages/meetings/create";
    }

    @PostMapping
    public String createMeeting(@ModelAttribute CreateMeetingDTO meeting) {
        meetingService.saveMeeting(Meeting.builder()
            .customer(userService.findById(meeting.getCustomer()).orElseThrow(() -> new RuntimeException("Customer not found")))
            .employee(userService.findById(meeting.getEmployee()).orElseThrow(() -> new RuntimeException("Employee not found")))
            .dateTime(LocalDateTime.parse(meeting.getDateTime()))
            .build());
        return "redirect:/meetings";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        meetingService.findById(id).ifPresent(m -> model.addAttribute("meeting", m));
        return "pages/meetings/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMeeting(@PathVariable Long id, @ModelAttribute Meeting meeting) {
        meeting.setId(id);
        meetingService.saveMeeting(meeting);
        return "redirect:/meetings";
    }

    @PostMapping("/delete/{id}")
    public String deleteMeeting(@PathVariable Long id) {
        meetingService.deleteMeeting(id);
        return "redirect:/meetings";
    }
}
