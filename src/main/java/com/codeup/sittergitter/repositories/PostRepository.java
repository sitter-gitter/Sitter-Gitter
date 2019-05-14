package com.codeup.sittergitter.repositories;

import com.codeup.sittergitter.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    //List<Post> findAll();
    //Post findOne(Long id);
    //void save(Post post);
    //void delete(Post post);

    @Query("from Post post where post.id like ?1")
    Post getPostById(Long id);


//    @Modifying
    @Transactional
//    @Query("delete from Post post where post.id = ?1")
    void deleteById(Long id);


}
