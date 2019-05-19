package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.AvailableTime;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AvailableTimeRepository extends CrudRepository<AvailableTime, Long>, JpaRepository<AvailableTime, Long> {
    //List<AvailableTime> findAll();
    //AvailableTime findOne(Long id);
    //void save(AvailableTime availableTime);
    //void delete(AvailableTime availableTime);

    List<AvailableTime> findByOrderByStartAsc();

    List<AvailableTime> findAvailableTimesByBabysitter_Id(Long id);
}
