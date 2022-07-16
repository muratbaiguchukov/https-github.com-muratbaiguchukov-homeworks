package kg.itacademy.doc.service.impl;

import kg.itacademy.doc.entity.Document;
import kg.itacademy.doc.entity.DocumentStatus;
import kg.itacademy.doc.entity.Executor;
import kg.itacademy.doc.exceptions.DocumentModelNullException;
import kg.itacademy.doc.exceptions.DocumentNotFoundException;
import kg.itacademy.doc.mapper.DocumentMapper;
import kg.itacademy.doc.model.DocumentCreateModel;
import kg.itacademy.doc.model.DocumentModel;
import kg.itacademy.doc.repository.DocumentRepository;
import kg.itacademy.doc.repository.ExecutorRepository;
import kg.itacademy.doc.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final ExecutorRepository executorRepository;

    @Override
    public DocumentModel create(DocumentCreateModel documentModel) {

        if (documentModel == null) {
            throw new DocumentModelNullException("Create document model is null");
        }

        Document newEntity = DocumentMapper.INSTANCE.toEntity(documentModel);
        newEntity = documentRepository.save(newEntity);
        return DocumentMapper.INSTANCE.toModel(newEntity);
    }


    @Override
    public boolean update(DocumentModel documentModel) {

        if (documentModel == null) {
            throw new DocumentModelNullException("Create document model is null");
        }


        Document existDocument = documentRepository
                .findById(documentModel.getId())
                .orElseThrow(() -> new DocumentNotFoundException("document not found by id " + documentModel.getId()));


        existDocument.setDocumentName(documentModel.getDocumentName());
        existDocument.setNumber(documentModel.getNumber());
        existDocument.setDate(documentModel.getDate());
        existDocument.setExecutionDate(documentModel.getExecutionDate());
        existDocument.setExecutor(documentModel.getExecutorModel());
        existDocument.setDocumentStatus(documentModel.getDocumentStatus());


        existDocument = documentRepository.save(existDocument);

        return existDocument.getId() != null;


    }

    @Override
    public boolean deleteById(Long id) {

        documentRepository.deleteById(id);

        return true;

    }

    @Override
    public DocumentModel getById(Long id) {

        Document existEntity = documentRepository.findById(id)
                .orElseThrow(() -> new DocumentNotFoundException("document not found by id: " + id));


        DocumentModel existModel = DocumentMapper.INSTANCE.toModel(existEntity);
        return existModel;

    }

    @Override
    public List<DocumentModel> getAllByDocumentName(String documentName) {

        List<Document> documentEntityList = documentRepository.findAllByDocumentName(documentName);

        List<DocumentModel> documentModelList = DocumentMapper.INSTANCE.toListModel(documentEntityList);


        return documentModelList;
    }

    @Override
    public DocumentModel getByDocumentName(String documentName) {

        Document documentEntity = documentRepository.findByDocumentName(documentName);

        DocumentModel documentEntityModel = DocumentMapper.INSTANCE.toModel(documentEntity);
        return documentEntityModel;
    }

    @Override
    public DocumentModel getByNumber(String number) {

        Document documentEntity = documentRepository.findByNumber(number);

        DocumentModel documentModel = DocumentMapper.INSTANCE.toModel(documentEntity);
        return documentModel;
    }

    @Override
    public List<DocumentModel> getByDocumentDate(LocalDate date) {

        List<Document> documentEntityList = documentRepository.findByDate(date);

        List<DocumentModel> documentModelList = DocumentMapper.INSTANCE.toListModel(documentEntityList);
        return documentModelList;
    }

    @Override
    public List<DocumentModel> getByDocumentStatus(DocumentStatus documentStatus) {

        List<Document> documentEntityList = documentRepository.findByDocumentStatus(documentStatus);

        List<DocumentModel> documentModelList = DocumentMapper.INSTANCE.toListModel(documentEntityList);
        return documentModelList;
    }

    @Override
    public List<DocumentModel> getAllByExecutor(Long executorId) {

        Executor ex = executorRepository.findById(executorId).get();
        List<Document> documentEntityList = documentRepository.findByExecutor(ex);

        List<DocumentModel> documentModelList = DocumentMapper.INSTANCE.toListModel(documentEntityList);
        return documentModelList;
    }

    @Override
    public List<DocumentModel> getAllDocumentsByDateAndExecutor(Long executorId, LocalDate startDate, LocalDate endDate) {

        Executor ex = executorRepository.findById(executorId)
                .orElseThrow();

        List<Document> documents = documentRepository.findByExecutorAndDateBetween(ex, startDate, endDate);

        return DocumentMapper.INSTANCE.toListModel(documents);
    }

    @Override
    public  List<Document> findAllByExecutionDateBefore(LocalDate date) {

        return null;
    }
}







