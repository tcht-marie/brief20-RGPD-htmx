package fr.simplon.brief20.service;

import fr.simplon.brief20.model.Document;
import java.util.List;
import java.util.Optional;

public interface DocumentService {
    Document saveDocument(Document document);
    Optional<Document> findById(Long id);
    List<Document> findAll();
    List<Document> findByUserId(Long userId);
    void deleteDocument(Long id);
}
