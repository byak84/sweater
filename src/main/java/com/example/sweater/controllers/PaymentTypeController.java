package com.example.sweater.controllers;

import com.example.sweater.repos.PaymentTypeRepo;
import com.example.sweater.domains.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paymenttype")
public class PaymentTypeController {
    @Autowired
    PaymentTypeRepo paymentTypeRepo;

    // Получить все виды платежей
    @GetMapping()
    public ResponseEntity<List<PaymentType>> GetAll() {
        return new ResponseEntity<>(paymentTypeRepo.findAll(), HttpStatus.OK);
    }

    // Получить вид платежа по id
    @GetMapping("{id}")
    public ResponseEntity<PaymentType> GetOne(@PathVariable Integer id) {
        final PaymentType result = paymentTypeRepo.findByPayment_type_id(id);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Создать вид платежа
    @PostMapping()
    public ResponseEntity<PaymentType> Add(@Valid @RequestBody PaymentType paymentType) {
        PaymentType result = paymentTypeRepo.saveAndFlush(paymentType);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // Изменить вид платежа по id
    @PutMapping("{id}")
    public ResponseEntity<PaymentType> update(@PathVariable Integer id, @RequestBody PaymentType paymentType) {
        paymentType.setPayment_type_id(id);
        PaymentType result = paymentTypeRepo.saveAndFlush(paymentType);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    // Удалить вид платежа
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (paymentTypeRepo.findByPayment_type_id(id) == null) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        } else {
            paymentTypeRepo.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

}


