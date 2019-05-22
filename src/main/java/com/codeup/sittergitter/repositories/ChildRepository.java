package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.Child;
import com.codeup.sittergitter.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ChildRepository extends CrudRepository<Child, Long> {
    //List<Child> findAll();
    //Child findOne(Long id);
    //void save(Child child);
    //void delete(Child child);

    void findByParent_Username(User parent);

    @Transactional
    void deleteById(Long id);

}
