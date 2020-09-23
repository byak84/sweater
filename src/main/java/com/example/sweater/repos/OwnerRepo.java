package com.example.sweater.repos;

import com.example.sweater.domains.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer> {
    @Query(value = "select e from Owner e where e.owner_id=?1")
    Owner findByOwner_id(Integer owner_id);

}
