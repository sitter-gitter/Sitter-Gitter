package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    //List<Appointment> findAll();
    //Appointment findOne(Long id);
    //void save(Appointment appointment);
    //void delete(Appointment appointment);


   // get appts by sitter
    // get appts by gitter

}
