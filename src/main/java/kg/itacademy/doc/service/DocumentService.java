package kg.itacademy.doc.service;

import kg.itacademy.doc.entity.DocumentStatus;
import kg.itacademy.doc.model.DocumentCreateModel;
import kg.itacademy.doc.model.DocumentModel;

import java.time.LocalDate;
import java.util.List;

public interface DocumentService {
    DocumentModel create(DocumentCreateModel documentModel); //создать документ

    DocumentModel update(DocumentModel documentModel); //изменить документ

    boolean deleteById(Long id); //удалить документ по id

    DocumentModel getById(Long id); //получить документ по id

    List<DocumentModel> getAllByDocumentName(String documentName); //получить все документы по наименованию

    DocumentModel getByDocumentName(String documentName); // поиск документа по наименованию

    DocumentModel getByNumber(String number); // поиск документа по регистрационному номеру

    List<DocumentModel> getByDocumentDate(LocalDate date); // поиск документа по дате регистрации

    List<DocumentModel> getByDocumentStatus(DocumentStatus documentStatus); //просмотр документов по статусам

    List<DocumentModel> getAllByExecutor(Long executorId); // просмотр документов, находящихся на исполнении у конкретного исполнителя

    List<DocumentModel> getAllDocumentsByDateAndExecutor(Long executorId, LocalDate startDate, LocalDate endDate); // просмотр документов, находящихся у конкретного исполнителя в течение определенного промежутка времени
}
