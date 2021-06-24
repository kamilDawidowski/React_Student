package com.example.demo.post;

import com.example.demo.action.dto.ActionResponse;
import com.example.demo.action.dto.PostResponse;
import com.example.demo.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

//    @Query("SELECT new com.example.demo.action.dto.PostResponse(t.name , p.post, p.createData) FROM Teacher t JOIN t.postList p")
//    public List<PostResponse> getAllPost();
//
//    @Query("SELECT new com.example.demo.action.dto.PostResponse(p.post, p.createData, p.id) FROM Post p")
//    public List<PostResponse> getAllPost();

}
