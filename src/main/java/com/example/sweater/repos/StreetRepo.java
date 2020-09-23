package com.example.sweater.repos;

import com.example.sweater.domains.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepo extends JpaRepository<Street, Integer> {

    @Query(value = "select e from Street e where e.street_id=?1")
    Street findByStreet_id(Integer owner_id);

}
