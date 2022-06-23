package kg.itacademy.doc.service;

import kg.itacademy.doc.model.DocumentModel;

import java.util.List;

public interface DocumentService {
    DocumentModel create(DocumentModel documentModel);

    boolean update(DocumentModel documentModel);

    boolean deleteById(Long id);

    DocumentModel getById(Long id);

    List<DocumentModel> getAllByDocumentName(String documentName);
}
