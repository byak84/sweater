package com.exemple.sweater.repos;

import com.exemple.sweater.domains.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepo extends JpaRepository<Counter, Integer> {
}
