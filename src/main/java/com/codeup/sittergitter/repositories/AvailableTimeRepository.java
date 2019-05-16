package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.AvailableTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableTimeRepository extends CrudRepository<AvailableTime, Long> {
    //List<AvailableTime> findAll();
    //AvailableTime findOne(Long id);
    //void save(AvailableTime availableTime);
    //void delete(AvailableTime availableTime);
}
