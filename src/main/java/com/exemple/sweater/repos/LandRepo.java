package com.exemple.sweater.repos;

import com.exemple.sweater.domains.Land;
import com.exemple.sweater.domains.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandRepo extends JpaRepository<Land, Integer> {

    @Query(value = "select e from Land e where e.land_id=?1 order by e.land_id")
    Land findByLand_id(Integer land_id);

    @Override
    @Query(value = "select e from Land e order by e.land_id")
    List<Land> findAll();
}
