package fr.simplon.brief20.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MeetingDTO {
    private Long id;
    private Long employeeId;
    private Long customerId;
    private LocalDateTime dateTime;
    private String report;
}
