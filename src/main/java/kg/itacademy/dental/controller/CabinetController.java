package kg.itacademy.dental.controller;

import kg.itacademy.dental.entity.Cabinet;
import kg.itacademy.dental.model.CabinetModel;
import kg.itacademy.dental.service.CabinetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cabinet")
@Slf4j
public class CabinetController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    CabinetService cabinetService;

    @PostMapping(path = "/create")
    public ResponseEntity<CabinetModel> createNewCabinet(@RequestBody CabinetModel cabinetModel) {
        CabinetModel result = cabinetService.create(cabinetModel);
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
    public ResponseEntity<Boolean> updateCabinet(@RequestBody CabinetModel cabinetModel) {
        try {
            cabinetService.update(cabinetModel);
            return ResponseEntity.ok(true);
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<CabinetModel> getCabinetById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(cabinetService.getById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByCodeCabinet")
    public ResponseEntity<List<CabinetModel>> getByCodeCabinet(@RequestParam("codeCabinet") String codeCabinet) {
        try {
            return ResponseEntity.ok(cabinetService.getAllByCodeCabinet(codeCabinet));
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
            return ResponseEntity.ok(cabinetService.deleteById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
