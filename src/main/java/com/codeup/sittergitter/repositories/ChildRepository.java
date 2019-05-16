package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.Child;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends CrudRepository<Child, Long> {
    //List<Child> findAll();
    //Child findOne(Long id);
    //void save(Child child);
    //void delete(Child child);
}
