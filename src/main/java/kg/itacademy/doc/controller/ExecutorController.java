package kg.itacademy.doc.controller;

import kg.itacademy.doc.model.ExecutorModel;
import kg.itacademy.doc.service.ExecutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping(path = "/api/executor")
@Slf4j
public class ExecutorController {

@Autowired
private ExecutorService executorService;

    @PostMapping(path = "/create")
    public ResponseEntity<ExecutorModel> createNewExecutor(@Valid @RequestBody ExecutorModel executorModel) {
        ExecutorModel result = executorService.create(executorModel);
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
    public ResponseEntity<Boolean> updateExecutor(@Valid @RequestBody ExecutorModel executorModel) {
        try {
            executorService.update(executorModel);
            return ResponseEntity.ok(true);
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<ExecutorModel> getExecutorById(@Valid @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(executorService.getById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByExecutorFullName")
    public ResponseEntity<List<ExecutorModel>> getByExecutorFullName(@NotBlank @RequestParam("executorFullName") String executorFullName) {
        try {
            return ResponseEntity.ok(executorService.getAllByExecutorFullName(executorFullName));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<ExecutorModel>> getAllExecutor() {
        try {
            return ResponseEntity.ok(executorService.getAll());
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@Valid @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(executorService.deleteById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
