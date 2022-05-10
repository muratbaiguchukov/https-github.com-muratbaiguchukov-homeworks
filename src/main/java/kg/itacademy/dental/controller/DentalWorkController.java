package kg.itacademy.dental.controller;

import kg.itacademy.dental.model.DentalWorkModel;
import kg.itacademy.dental.service.DentalWorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/dentalWork")
@Slf4j
public class DentalWorkController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    DentalWorkService dentalWorkService;

    @PostMapping(path = "/create")
    public ResponseEntity<DentalWorkModel> createNewDentalWork(@RequestBody DentalWorkModel dentalWorkModel) {
        DentalWorkModel result = dentalWorkService.create(dentalWorkModel);
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
    public ResponseEntity<Boolean> updateDentalWork(@RequestBody DentalWorkModel dentalWorkModel) {
        try {
            dentalWorkService.update(dentalWorkModel);
            return ResponseEntity.ok(true);
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<DentalWorkModel> getDentalWorkById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(dentalWorkService.getById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByDentalWorkName")
    public ResponseEntity<List<DentalWorkModel>> getByDentalWorkName(@RequestParam("dentalWorkName") String dentalWorkName) {
        try {
            return ResponseEntity.ok(dentalWorkService.getAllByDentalWorkName(dentalWorkName));
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
            return ResponseEntity.ok(dentalWorkService.deleteById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
