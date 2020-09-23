package com.example.sweater.controllers;

import com.example.sweater.domains.Owner;
import com.example.sweater.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerRepo ownerRepo;

    //Получить всех собственников
    @GetMapping
    public ResponseEntity<List<Owner>> GetAll() {
        return new ResponseEntity<>(ownerRepo.findAll(),HttpStatus.OK);
    }

    // Получить собственника по id
    @GetMapping("{id}")
    public ResponseEntity<Owner> GetOne(@PathVariable Integer id) {
        final Owner result = ownerRepo.findByOwner_id(id);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Создать собcтвенника
    @PostMapping()
    public ResponseEntity<Owner> Add(@Valid @RequestBody Owner owner) {
        Owner result = ownerRepo.saveAndFlush(owner);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // Изменить собcтвенника
    @PutMapping("{id}")
    public ResponseEntity<Owner> update(@PathVariable Integer id, @RequestBody Owner owner) {
        owner.setOwner_id(id);
        Owner result = ownerRepo.saveAndFlush(owner);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    // Удалить собственника по id
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (ownerRepo.findByOwner_id(id) == null) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
        else {
            ownerRepo.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

}