package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User deleteByUsername(String username);

//    @Query("from User user where user.id like ?1")
//    User getUserById(long id);
}
