package kg.itacademy.doc.service.impl;

import kg.itacademy.doc.entity.Document;
import kg.itacademy.doc.exceptions.DocumentModelNullException;
import kg.itacademy.doc.exceptions.DocumentNotFoundException;
import kg.itacademy.doc.model.DocumentModel;
import kg.itacademy.doc.repository.DocumentRepository;
import kg.itacademy.doc.service.DocumentService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public DocumentModel create(DocumentModel documentModel) {
        //Валидация
        if (documentModel == null) {
            throw new DocumentModelNullException("Create document model is null");
        } else if (Strings.isBlank(documentModel.getDocumentName())) {
            throw new InvalidParameterException("document name can't be blank");
        }

        //Маппинг
        Document document = new Document();
        document.setDocumentName(documentModel.getDocumentName());
        document.setNumber(documentModel.getNumber());
        document.setDate(documentModel.getDate());
        document.setExecutionDate(documentModel.getExecutionDate());
        document.setExecutor(documentModel.getExecutor());
        document = documentRepository.save(document);

        // Обратный маппинг
        documentModel.setId(document.getId());

        //Вернуть результат
        return documentModel;
    }


    @Override
    public boolean update(DocumentModel documentModel) {
        //Валидация
        if (documentModel == null) {
            throw new DocumentModelNullException("Create document model is null");
        } else if (documentModel.getDocumentName() == null || documentModel.getDocumentName().equals("")) {
            throw new InvalidParameterException("document name can't be empty");
        } else if (documentModel.getId() == null) {
            throw new InvalidParameterException("document id can't be null");
        }
        //Проверка на то что есть такой документ с таким id
        Document existDocument = documentRepository.getById(documentModel.getId());
        if (existDocument == null) {
            throw new DocumentNotFoundException("document not found by id " + documentModel.getId());
        }

        //маппим
        existDocument.setDocumentName(documentModel.getDocumentName());
        existDocument.setNumber(documentModel.getNumber());
        existDocument.setDate(documentModel.getDate());
        existDocument.setExecutionDate(documentModel.getExecutionDate());
        existDocument.setExecutor(documentModel.getExecutor());

        //обновляем
        existDocument = documentRepository.save(existDocument);

        //Если id не нулл после обновляения то можем считать что update прошел успешно в бд.
        return existDocument.getId() != null;

    }

    @Override
    public boolean deleteById(Long id) {
        //Валидация
        if (!documentRepository.existsById(id)) {
            throw new DocumentNotFoundException("Document not found by id: " + id);
        }

        //Удаление
        documentRepository.deleteById(id);

        //Вернется тру если никаких исключений не произошло.
        return true;

    }

    @Override
    public DocumentModel getById(Long id) {
        //Валидация
        //TODO @Valid
        if (id == null) {
            throw new InvalidParameterException("Id is null");
        }

        //Ищем в бд с таким айди
        //TODO use findById and .orElseThrow exception
        Document existEntity = documentRepository.getById(id);

        //Если в бд нет такого айди то вернет null. Значит мы должны выбросить исключение о том что не нашли такого документа
        if (existEntity == null) {
            throw new DocumentNotFoundException("document not found by id: " + id);
        }

        //Маппинг
        DocumentModel existModel = new DocumentModel();
        existModel.setId(existEntity.getId());
        existModel.setDocumentName(existEntity.getDocumentName());
        existModel.setNumber(existEntity.getNumber());
        existModel.setDate(existEntity.getDate());
        existModel.setExecutionDate(existEntity.getExecutionDate());
        existModel.setExecutor(existEntity.getExecutor()); // айдишник надо указать, а не Executor
        existModel.setDocumentStatus(existEntity.getDocumentStatus());

        return existModel;

    }

    @Override
    public List<DocumentModel> getAllByDocumentName(String documentName) {
        //Валидация
        //TODO @Valid
        if (Strings.isBlank(documentName)) {
            throw new InvalidParameterException("document name is blank");
        }

        //Достаем все документы по наименованию
        List<Document> documentEntityList = documentRepository.findAllByDocumentName(documentName);

        //Создаем пустой массив моделек
        List<DocumentModel> documentModelList = new ArrayList<>();

        //Проходимся по каждому чтобы смаппить все элементы в модельки
        //TODO foreach() and MapStruct
        for (Document element : documentEntityList) {
            //Маппим по одному каждый энтити в модель
            DocumentModel documentModel = new DocumentModel();
            documentModel.setId(element.getId());
            documentModel.setDocumentName(element.getDocumentName());
            documentModel.setNumber(element.getNumber());
            documentModel.setDate(element.getDate());
            documentModel.setExecutionDate(element.getExecutionDate());
            documentModel.setExecutor(element.getExecutor()); // надо айдишник указать, а не Executor
            documentModel.setDocumentStatus(element.getDocumentStatus());

            //добавляем в массив моделек
            documentModelList.add(documentModel);
        }

        //Возвращаем модельки
        return documentModelList;
    }


}
