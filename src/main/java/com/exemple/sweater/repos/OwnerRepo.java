package com.exemple.sweater.repos;

import com.exemple.sweater.domains.Land;
import com.exemple.sweater.domains.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer> {

    @Override
    //@Query(value = "select * from owner order by owner_id", nativeQuery = true)
    @Query(value = "select e from Owner e order by e.lastname")
    List<Owner> findAll();

    //@Query(value = "select * from owner where owner_id=?1", nativeQuery = true)
    @Query(value = "select e from Owner e where e.owner_id=?1")
    Owner findByOwner_id(Integer owner_id);

    @Modifying
    @Transactional
    @Query(value = "update owner set firstname=?2, lastname=?3, patronymic=?4, phone=?5, comment=?6 where owner_id=?1", nativeQuery = true)
    void UpdateUserInfoByID(Integer owner_id, String firstname, String lastname, String patronymic, String phone, String comment);

    @Modifying
    @Transactional
    @Query(value = "delete from owner where owner_id=?1", nativeQuery = true)
    void delByID(Integer owner_id);

    List<Owner> findAllOrderById();

}
