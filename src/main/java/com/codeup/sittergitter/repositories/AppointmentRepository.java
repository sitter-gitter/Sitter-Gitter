package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.Appointment;
import com.codeup.sittergitter.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    //List<Appointment> findAll();
    //Appointment findOne(Long id);
    //void save(Appointment appointment);
    //void delete(Appointment appointment);

    @Transactional
    void deleteById(Long id);

    List<Appointment> findByOrderByStartAsc();

    void getAppointmentsByBabysitterId(Long id);
    void getAppointmentsByParentId(Long id);
//    void getAppointmentsByBabsitter(User babysitter);
//    void getAppointmentsByParent(User parent);
    void getAppointmentByBabysitter(User babysitter);
    void getAppointmentByParent(User parent);

    void findAppointmentByBabysitter(User babysitter);
    void findAppointmentByBabysitter_Id(Long id);
    void findAppointmentsByBabysitter_Id(Long id);
    void findAppointmentByParent_Id(Long id);
    void findAppointmentsByParent_Id(Long id);

    // get appts by sitter
    // get appts by gitter

}
