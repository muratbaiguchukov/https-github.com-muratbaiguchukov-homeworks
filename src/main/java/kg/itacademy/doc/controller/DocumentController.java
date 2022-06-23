package kg.itacademy.doc.controller;

import kg.itacademy.doc.model.DocumentModel;
import kg.itacademy.doc.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/document")
@Slf4j
public class DocumentController {


        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        DocumentService documentService;

        @PostMapping(path = "/create")
        public ResponseEntity<DocumentModel> createNewDocument(@RequestBody DocumentModel documentModel) {
            DocumentModel result = documentService.create(documentModel);

            if (result.getId() != null) {

                return ResponseEntity.status(HttpStatus.CREATED).body(result);
            } else {

                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }
        }

        @GetMapping(path = "/getByDocumentName")
        public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
            try {
                return ResponseEntity.ok(documentService.deleteById(id));
            } catch (RuntimeException ex) {
                log.error(ex.getMessage(), ex);
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }
        }
    }

