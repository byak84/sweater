package com.example.sweater.repos;

import com.example.sweater.domains.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepo extends JpaRepository<Counter, Integer> {
}
