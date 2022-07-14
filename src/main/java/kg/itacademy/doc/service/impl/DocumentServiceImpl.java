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
        //Валидация
        if (documentModel == null) { // не пустой ли объект(documentModel) нам передал фронт
            throw new DocumentModelNullException("Create document model is null"); // выкинет ошибку "созданный документ нулевой"
        }
        // делаем маппинг
        Document newEntity = DocumentMapper.INSTANCE.toEntity(documentModel); // создаем новое entity
        newEntity = documentRepository.save(newEntity);
        return DocumentMapper.INSTANCE.toModel(newEntity);
    }


    @Override
    public DocumentModel update(DocumentModel documentModel) { // полученную от controller модельку(DocumentModel) передаем сервисному слою
        //Валидация
        if (documentModel == null) {
            throw new DocumentModelNullException("Create document model is null");
        }

        // Проверка на то что есть такой документ с таким id
        Document existDocument = documentRepository
                .findById(documentModel.getId())
                .orElseThrow(() -> new DocumentNotFoundException("document not found by id " + documentModel.getId()));

        // маппим
        DocumentModel existDocumentModel = DocumentMapper.INSTANCE.toModel(existDocument);
        return existDocumentModel;

    }

    @Override
    public boolean deleteById(Long id) {
        //Удаление
        documentRepository.deleteById(id);

        //Вернется тру если никаких исключений не произошло.
        return true;

    }

    @Override
    public DocumentModel getById(Long id) {
        //Ищем в бд с таким айди
        Document existEntity = documentRepository.findById(id)
                .orElseThrow(() -> new DocumentNotFoundException("document not found by id: " + id));

        //Маппинг с использованием mapstruct
        DocumentModel existModel = DocumentMapper.INSTANCE.toModel(existEntity);
        return existModel;

    }

    @Override
    public List<DocumentModel> getAllByDocumentName(String documentName) {
        //Достаем все документы по наименованию
        List<Document> documentEntityList = documentRepository.findAllByDocumentName(documentName);

        //Маппим по одному каждый энтити в модель
        // первый вариант
//        for (Document element : documentEntityList){
//            DocumentModel model =  DocumentMapper.INSTANCE.toModel(element);
//            documentModelList.add(model);
//        }
        // второй вариант
        //нижеследующая строка заменяет строки 80 - 83
        List<DocumentModel> documentModelList = DocumentMapper.INSTANCE.toListModel(documentEntityList);
        //добавляем в массив моделек

        //возвращаем модельки
        return documentModelList;

    }

    @Override
    public DocumentModel getByDocumentName(String documentName) {
        // ищем документ по такому наименованию
        Document documentEntity = documentRepository.findByDocumentName(documentName);

        DocumentModel documentEntityModel = DocumentMapper.INSTANCE.toModel(documentEntity);
        return documentEntityModel;
    }

    @Override
    public DocumentModel getByNumber(String number) {
        // ищем документ по такому номеру
        Document documentEntity = documentRepository.findByNumber(number);

        DocumentModel documentModel = DocumentMapper.INSTANCE.toModel(documentEntity);
        return documentModel;
    }

    @Override
    public List<DocumentModel> getByDocumentDate(LocalDate date) {
        // ищем документ по дате
        List<Document> documentEntityList = documentRepository.findByDate(date);

        List<DocumentModel> documentModelList = DocumentMapper.INSTANCE.toListModel(documentEntityList);
        return documentModelList;
    }

    @Override
    public List<DocumentModel> getByDocumentStatus(DocumentStatus documentStatus) {
        // ищем документы, срок исполнения которых истек
        List<Document> documentEntityList = documentRepository.findByDocumentStatus(documentStatus);

        List<DocumentModel> documentModelList = DocumentMapper.INSTANCE.toListModel(documentEntityList);
        return documentModelList;
    }

    @Override
    public List<DocumentModel> getAllByExecutor(Long executorId) {
        // ищем документы, находящиеся на исполнении у конкретного исполнителя
        Executor ex = executorRepository.findById(executorId).get();
        List<Document> documentEntityList = documentRepository.findByExecutor(ex);

        List<DocumentModel> documentModelList = DocumentMapper.INSTANCE.toListModel(documentEntityList);
        return documentModelList;
    }

    @Override
    public List<DocumentModel> getAllDocumentsByDateAndExecutor(Long executorId, LocalDate startDate, LocalDate endDate) {

        //Find executor
//        List<Document> all = documentRepository.findByExecutorAndExecutionDateBetween(executor, startDate, endDate);
        return null;
    }

    @Override
    public List<DocumentModel> findByExecutionDateLessThanCurrentDate(Long id, LocalDate executionDate) {
        return null;
    }

//    @Override
//    public List<DocumentModel> findByExecutionDateLessThanCurrentDate(Long id, LocalDate executionDate) {
//        return null;
//    }
}







