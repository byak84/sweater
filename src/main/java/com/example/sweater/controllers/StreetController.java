package com.example.sweater.controllers;

import com.example.sweater.domains.Street;
import com.example.sweater.repos.StreetRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/street")
public class StreetController {

//    @Autowired
    private final StreetRepo streetRepo;

    public StreetController(StreetRepo streetRepo) {
        this.streetRepo = streetRepo;
    }

    //Получить все улицы
    @GetMapping()
    public ResponseEntity<List<Street>> GetAll() {
        return new ResponseEntity<>(streetRepo.findAll(), HttpStatus.OK);
    }

    // Получить собственника по id
    @GetMapping("{id}")
    public ResponseEntity<Street> GetOne(@PathVariable Integer id) {
        final Street result = streetRepo.findByStreet_id(id);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Создать улицу
    @PostMapping()
    public ResponseEntity<Street> Add(@Valid @RequestBody Street street) {
        Street result = streetRepo.saveAndFlush(street);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // Изменить улицу
    @PutMapping("{id}")
    public ResponseEntity<Street> update(@PathVariable Integer id, @RequestBody Street street) {
        street.setStreet_id(id);
        Street result = streetRepo.saveAndFlush(street);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    // Удалить улицу по id
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (streetRepo.findByStreet_id(id) == null) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        } else {
            streetRepo.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

}
