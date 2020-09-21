package com.exemple.sweater.repos;

import com.exemple.sweater.domains.Counter;
import com.exemple.sweater.domains.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CounterRepo extends JpaRepository<Counter, Integer> {
    @Query(value = "select e from Counter e where e.counter_id=?1")
    Counter findByCounter_id(Integer counter_id);
}
