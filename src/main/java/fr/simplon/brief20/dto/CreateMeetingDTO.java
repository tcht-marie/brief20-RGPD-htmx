package fr.simplon.brief20.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateMeetingDTO {
    private Long employee;
    private Long customer;
    private String dateTime;
    private String report;
}
