package com.exemple.sweater.controllers;

import com.exemple.sweater.domains.Land;
import com.exemple.sweater.domains.Owner;
import com.exemple.sweater.repos.LandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/land")
public class LandController {

    @Autowired
    LandRepo landRepo;

    // Получить все участки
    @GetMapping()
    public ResponseEntity<List<Land>> getAll() {
        return new ResponseEntity<>(landRepo.findAll(), HttpStatus.OK);
    }

    // Получить участок по id
    @GetMapping("{id}")
    public ResponseEntity<Land> GetOne(@PathVariable Integer id) {
        final Land result = landRepo.findByLand_id(id);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Создать участок
    @PostMapping()
    public ResponseEntity<Land> Add(@Valid @RequestBody Land land) {
        Land result = landRepo.saveAndFlush(land);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // Изменить участок
    @PutMapping("{id}")
    public ResponseEntity<Land> update(@PathVariable Integer id, @RequestBody Land land) {
        land.setLand_id(id);
        Land result = landRepo.saveAndFlush(land);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    // Удалить собственника по id
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (landRepo.findByLand_id(id) == null) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        } else {
            landRepo.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}

