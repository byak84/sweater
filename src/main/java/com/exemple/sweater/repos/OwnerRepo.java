package com.exemple.sweater.repos;

import com.exemple.sweater.domains.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer> {

//    @Override
//    //@Query(value = "select * from owner order by owner_id", nativeQuery = true)
//    @Query(value = "select e from Owner e order by e.lastname")
//    List<Owner> findAll();
//

    @Query(value = "select e from Owner e where e.owner_id=?1")
    Owner findByOwner_id(Integer owner_id);

}
