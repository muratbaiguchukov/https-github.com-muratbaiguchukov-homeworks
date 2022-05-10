package kg.itacademy.dental.controller;

import kg.itacademy.dental.model.SickModel;
import kg.itacademy.dental.service.SickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/sick")
@Slf4j
public class SickController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    SickService sickService;

    @PostMapping(path = "/create")
    public ResponseEntity<SickModel> createNewSick(@RequestBody SickModel sickModel) {
        SickModel result = sickService.create(sickModel);
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
    public ResponseEntity<Boolean> updateSick(@RequestBody SickModel sickModel) {
        try {
            sickService.update(sickModel);
            return ResponseEntity.ok(true);
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<SickModel> getSickById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(sickService.getById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getBySickFullname")
    public ResponseEntity<List<SickModel>> getBySickFullname(@RequestParam("sickFullname") String sickFullname) {
        try {
            return ResponseEntity.ok(sickService.getAllBySickFullname(sickFullname));
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
            return ResponseEntity.ok(sickService.deleteById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
