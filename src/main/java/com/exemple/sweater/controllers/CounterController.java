package com.exemple.sweater.controllers;

import com.exemple.sweater.domains.Counter;
import com.exemple.sweater.repos.CounterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/counter")
public class CounterController {
    @Autowired
    CounterRepo counterRepo;

    //Получить все счетчики
    @GetMapping()
    public ResponseEntity<List<Counter>> CountersList() {
        return new ResponseEntity<>(counterRepo.findAll(), HttpStatus.OK);
    }

    // Получить счётчик по id
    @GetMapping("{id}")
    public ResponseEntity<Counter> GetOne(@PathVariable Integer id) {
        final Counter result = counterRepo.findByCounter_id(id);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Создать счётчик
    @PostMapping()
    public ResponseEntity<Counter> Add(@Valid @RequestBody Counter counter) {
        Counter result = counterRepo.saveAndFlush(counter);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // Изменить счётчик
    @PutMapping("{id}")
    public ResponseEntity<Counter> update(@PathVariable Integer id, @RequestBody Counter counter) {
        counter.setCounter_id(id);
        Counter result = counterRepo.saveAndFlush(counter);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    // Удалить счётчик по id
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (counterRepo.findByCounter_id(id) == null) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        } else {
            counterRepo.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}
