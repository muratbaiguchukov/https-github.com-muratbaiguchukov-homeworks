package kg.itacademy.doc.controller;

import kg.itacademy.doc.entity.DocumentStatus;
import kg.itacademy.doc.model.DocumentCreateModel;
import kg.itacademy.doc.model.DocumentModel;
import kg.itacademy.doc.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(path = "/api/document")
@Slf4j
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @PostMapping(path = "/create")
    public ResponseEntity<DocumentModel> createNewDocument(@Valid @RequestBody DocumentCreateModel documentModel) { //фронт дает задание создать новый документ
        DocumentModel result = documentService.create(documentModel);// мы эту модельку (documentModel) передаем в сервисный слой

        if (result.getId() != null) { // если при создании поля id что-то есть, значит мы создали успешно и можем вернуть 201

            return ResponseEntity.status(HttpStatus.CREATED).body(result); //то вернется со статусом 201 или CREATED
        } else { // иначе
            log.info("Id is empty");
            return ResponseEntity // то вернется со статусом 500 если поле id пустое
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateDocument(@Valid @RequestBody DocumentModel documentModel) {// пришла можелька(DocumentModel) от фронта
//        try {
        documentService.update(documentModel);
        return ResponseEntity.ok(true);
//        } catch (RuntimeException ex) {
//            log.error(ex.getMessage(), ex);
//            return ResponseEntity
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(null);
//        }
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity<Boolean> deleteById(@Valid @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(documentService.deleteById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<DocumentModel> getDocumentById(@Valid @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(documentService.getById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getAllByDocumentName")
    public ResponseEntity<List<DocumentModel>> getByAllDocumentName(@NotBlank @RequestParam("allDocumentName") String documentName) {
        try {
            return ResponseEntity.ok(documentService.getAllByDocumentName(documentName));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByDocumentName")
    public ResponseEntity<DocumentModel> getByDocumentName(@NotBlank @RequestParam("documentName") String documentName) {
        try {
            return ResponseEntity.ok(documentService.getByDocumentName(documentName));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByDocumentNumber")
    public ResponseEntity<DocumentModel> getByNumber(@NotBlank @RequestParam("number") String number) {
        try {
            return ResponseEntity.ok(documentService.getByNumber(number));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByDocumentDate")
    public ResponseEntity<List<DocumentModel>> getByDocumentDate(@NotBlank @RequestParam("date") LocalDate date) {
        try {
            return ResponseEntity.ok(documentService.getByDocumentDate(date));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByDocumentStatus")
    public ResponseEntity<List<DocumentModel>> getByDocumentStatus(@NotBlank @RequestParam("documentStatus") DocumentStatus documentStatus) {
        try {
            return ResponseEntity.ok(documentService.getByDocumentStatus(documentStatus));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getAllByDocumentExecutor")
    public ResponseEntity<List<DocumentModel>> getAllByExecutor(@NotNull @RequestParam("executorId") Long executorId) {
        try {
            return ResponseEntity.ok(documentService.getAllByExecutor(executorId));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getAllDocumentsByDateAndExecutor")
    public ResponseEntity<List<DocumentModel>> getAllDocumentsByDateAndExecutor(@NotNull @RequestParam("executerId") Long executorId, LocalDate startDate, LocalDate endDate) {
        try {
            return ResponseEntity.ok(documentService.getAllDocumentsByDateAndExecutor(executorId, startDate, endDate));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException{
                setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }

            @Override
            public String getAsText() throws IllegalArgumentException {
                return DateTimeFormatter.ofPattern("yyyy-MM-dd").format((LocalDate) getValue());
            }
        });
    }

    }




