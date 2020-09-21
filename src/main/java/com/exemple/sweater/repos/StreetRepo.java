package com.exemple.sweater.repos;

import com.exemple.sweater.domains.Owner;
import com.exemple.sweater.domains.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StreetRepo extends JpaRepository<Street, Integer> {

    @Query(value = "select e from Street e where e.street_id=?1")
    Street findByStreet_id(Integer owner_id);

}
