package fr.simplon.brief20.dto;

import lombok.Data;

@Data
public class DocumentDTO {
    private Long id;
    private Long userId;
    private String filename;
    private String path;
}
