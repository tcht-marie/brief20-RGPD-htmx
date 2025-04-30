package fr.simplon.brief20.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadDocumentDTO {
    private MultipartFile file;
    private String description;
}
