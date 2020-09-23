package com.example.sweater.repos;

import com.example.sweater.domains.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentTypeRepo  extends JpaRepository<PaymentType, Integer> {

    @Query(value = "select e from PaymentType e order by e.payment_type_id")
    List<PaymentType> findAll();

    @Query(value = "select e from PaymentType e where e.payment_type_id=?1")
    PaymentType findByPayment_type_id(Integer payment_type_id);
}
