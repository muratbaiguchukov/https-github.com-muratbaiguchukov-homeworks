package kg.itacademy.currency.controller;

import kg.itacademy.currency.exception.CurrencyNotFoundException;
import kg.itacademy.currency.model.CurrencyModel;
import kg.itacademy.currency.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/currency")
@Slf4j
public class CurrencyController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    CurrencyService currencyService;

    @PostMapping(path = "/create")
    public ResponseEntity<CurrencyModel> createNewCurrency(@RequestBody CurrencyModel currencyModel) {
        CurrencyModel result = currencyService.create(currencyModel);

        if (result.getId() != null) {

            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateCurrency(@RequestBody CurrencyModel currencyModel) {
        try {
            currencyService.update(currencyModel);
            return ResponseEntity.ok(true);
        } catch (CurrencyNotFoundException ex) {
            log.error (ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<CurrencyModel> getCurrencyById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(currencyService.getById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByCurrencyName")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(currencyService.deleteById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
