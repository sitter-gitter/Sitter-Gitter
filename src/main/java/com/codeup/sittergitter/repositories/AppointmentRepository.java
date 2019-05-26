package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.Appointment;
import com.codeup.sittergitter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long>, JpaRepository<Appointment, Long> {
    //List<Appointment> findAll();
    //Appointment findOne(Long id);
    //void save(Appointment appointment);
    //void delete(Appointment appointment);

    @Transactional
    void deleteById(Long id);

    List<Appointment> findByOrderByStartAsc();
//    List<Appointment> findBySitterApproved();

    @Transactional
    @Modifying
    @Query("UPDATE Appointment appt SET appt.availableTime = null WHERE appt.id = :appointmentId")
    void nullifyAvailTime(@Param("appointmentId") long appointmentId);


    List<Appointment> findAllByParentUsernameOrderByStartAsc(String username);
    List<Appointment> findAllByBabysitterUsernameOrderByStartAsc(String username);
//
//    void findAllByBabysitter(User babysitter);
//
//    void getAppointmentsByBabysitterId(Long id);
//    void getAppointmentsByParentId(Long id);
//    void getAppointmentsByBabsitter(User babysitter);
//    void getAppointmentsByParent(User parent);
//    void getAppointmentByBabysitter(User babysitter);
//    void getAppointmentByParent(User parent);
//
//    void findAppointmentByBabysitter(User babysitter);
//    List<Appointment> findAppointmentByBabysitter_Id();
//    void findAppointmentsByBabysitter_Id(Long id);
//    void findAppointmentByParent_Id(Long id);
//    void findAppointmentsByParent_Id(Long id);

    // get appts by sitter
    // get appts by gitter

}
