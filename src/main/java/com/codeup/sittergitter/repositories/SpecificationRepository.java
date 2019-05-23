package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificationRepository extends CrudRepository<Specification, Long> {
    //List<Specification> findAll();
//    Specification findOne(Long id);
    //void save(Specification specification);
    //void delete(Specification specification);

    Specification findByBabysitterUsername(String username);
}
