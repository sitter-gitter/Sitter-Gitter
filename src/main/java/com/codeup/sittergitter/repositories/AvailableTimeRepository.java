package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.AvailableTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableTimeRepository extends CrudRepository<AvailableTime, Long> {
    //List<AvailableTime> findAll();
    //AvailableTime findOne(Long id);
    //void save(AvailableTime availableTime);
    //void delete(AvailableTime availableTime);

    List<AvailableTime> findAvailableTimesByBabysitter_Id(Long id);
}
