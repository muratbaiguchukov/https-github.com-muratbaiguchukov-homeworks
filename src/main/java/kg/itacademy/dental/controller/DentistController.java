package kg.itacademy.dental.controller;

import kg.itacademy.dental.model.DentistModel;
import kg.itacademy.dental.service.DentistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/dentist")
@Slf4j
public class DentistController {

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        DentistService dentistService;

        @PostMapping(path = "/create")
        public ResponseEntity<DentistModel> createNewDentist(@RequestBody DentistModel dentistModel) {
            DentistModel result = dentistService.create(dentistModel);
            //Если при создании поле id что то есть, значит мы создали успешно и можем вернуть 201
            if (result.getId() != null) {
                //вернется со статус 201
                return ResponseEntity.status(HttpStatus.CREATED).body(result);
            } else {
                //вернется со статус 500 если поле id пустое
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }
        }

        @PutMapping(path = "/update")
        public ResponseEntity<Boolean> updateDentist(@RequestBody DentistModel dentistModel) {
            try {
                dentistService.update(dentistModel);
                return ResponseEntity.ok(true);
            } catch (RuntimeException ex) {
                log.error(ex.getMessage(), ex);
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }
        }

        @GetMapping(path = "/get/{id}")
        public ResponseEntity<DentistModel> getDentistById(@PathVariable("id") Long id) {
            try {
                return ResponseEntity.ok(dentistService.getById(id));
            } catch (RuntimeException ex) {
                log.error(ex.getMessage(), ex);
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }
        }

        @GetMapping(path = "/getByDentistFullname")
        public ResponseEntity<List<DentistModel>> getByDentistFullname(@RequestParam("dentistFullname") String dentistFullname) {
            try {
                return ResponseEntity.ok(dentistService.getAllByDentistFullname(dentistFullname));
            } catch (RuntimeException ex) {
                log.error(ex.getMessage(), ex);
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }
        }

        @DeleteMapping(path = "/delete/{id}")
        public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
            try {
                return ResponseEntity.ok(dentistService.deleteById(id));
            } catch (RuntimeException ex) {
                log.error(ex.getMessage(), ex);
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }
        }
    }

