package fr.simplon.brief20.controller;

import fr.simplon.brief20.dto.UploadDocumentDTO;
import fr.simplon.brief20.model.Document;
import fr.simplon.brief20.model.User;
import fr.simplon.brief20.service.DocumentService;
import fr.simplon.brief20.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;
    private final UserService userService;

    @GetMapping
    public String listDocuments(Model model) {
        List<Document> documents = documentService.findAll();
        model.addAttribute("documents", documents);
        return "pages/documents/list";
    }

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("document", UploadDocumentDTO.builder().build());
        return "pages/documents/upload";
    }

    @PostMapping("/upload")
    public String uploadDocument(@ModelAttribute UploadDocumentDTO uploadDocument, Authentication auth) throws IOException {
        User user = userService.findByUsername(auth.getName()).orElseThrow(() -> new RuntimeException("User not found"));

        MultipartFile file = uploadDocument.getFile();
        String description = uploadDocument.getDescription();
        Document document = Document.builder()
            .filename(file.getOriginalFilename())
            .contentType(file.getContentType())
            .data(file.getBytes())
            .description(description)
            .user(user)
            .build();
        documentService.saveDocument(document);
        return "redirect:/documents";
    }

    // return the document's bytes to start download by browser
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long id) {
        Document document = documentService.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));
        return ResponseEntity.ok()
            .header("Content-Disposition", "attachment; filename=\"" + document.getFilename() + "\"")
            .contentType(MediaType.parseMediaType(document.getContentType()))
            .body(document.getData());
    }

    @PostMapping("/delete/{id}")
    public String deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return "redirect:/documents";
    }
}
