package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.AvailableTime;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
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

    List<AvailableTime> findByOrderByStartAsc();

//    List<AvailableTime> findByOrOrderByEndAsc();




    List<AvailableTime> findAvailableTimesByBabysitter_Id(Long id);
}
