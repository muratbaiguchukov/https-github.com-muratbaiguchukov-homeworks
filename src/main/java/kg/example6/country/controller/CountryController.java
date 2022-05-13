package kg.example6.country.controller;

import kg.example6.country.entity.Country;
import kg.example6.country.model.CountryModel;
import kg.example6.country.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/country")
@Slf4j
public class CountryController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    CountryService countryService;

    @PostMapping(path = "/create")
    public ResponseEntity<CountryModel> createNewCountry(@RequestBody CountryModel countryModel) {
        CountryModel result = countryService.create(countryModel);

        if (result.getId() != null) {

            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateCountry(@RequestBody CountryModel countryModel) {
        try {
            countryService.update(countryModel);
            return ResponseEntity.ok(true);
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<CountryModel> getCountryById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(countryService.getById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Country>> getAll() {
        try {
            return ResponseEntity.ok(countryService.getAll());
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getByCountryName")
    public ResponseEntity<List<CountryModel>> getByCountryName(@RequestParam("countryName") String countryName) {
        try {
            return ResponseEntity.ok(countryService.getAllByCountryName(countryName));
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
            return ResponseEntity.ok(countryService.deleteById(id));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    
}
