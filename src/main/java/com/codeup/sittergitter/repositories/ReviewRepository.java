package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    //List<Review> findAll();
    //Review findOne(Long id);
    //void save(Review review);
    //void delete(Review review);

    @Query("from Review review where review.id like ?1")
    Review getReviewById(Long id);


    List<Review> findByBabysitterUsername(String username);

    //    @Modifying
    @Transactional
//    @Query("delete from Review review where review.id = ?1")
    void deleteById(Long id);


}
