package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.AvailableTime;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AvailableTimeRepository extends CrudRepository<AvailableTime, Long>, JpaRepository<AvailableTime, Long> {

    @Transactional
    void deleteById(Long id);

    //List<AvailableTime> findAll();
    //AvailableTime findOne(Long id);
    //void save(AvailableTime availableTime);
    //void delete(AvailableTime availableTime);

    @Transactional
    @Modifying
    @Query("UPDATE AvailableTime at SET at.isTaken = :isTaken WHERE at.id = :availableTimeId")
    void updateIsTaken(@Param("availableTimeId") long availableTimeId, @Param("isTaken") Boolean isTaken);


    List<AvailableTime> findByOrderByStartAsc();

    List<AvailableTime> findAvailableTimesByIsTakenFalseOrderByStartAsc();

    List<AvailableTime> findAvailableTimesByIsTakenFalse();




    List<AvailableTime> findAvailableTimesByBabysitter_Id(Long id);
}
