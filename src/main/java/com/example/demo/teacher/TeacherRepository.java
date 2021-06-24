package com.example.demo.teacher;

import com.example.demo.action.dto.ActionResponse;
import com.example.demo.action.dto.PostResponse;
import com.example.demo.student.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    //    @Query ("SELECT new com.example.demo.action.dto.ActionResponse( t.name , s.name) FROM Teacher t JOIN t.studentList s");
//    public List<ActionResponse> getAllMembersInformation();
    @Query("SELECT new com.example.demo.action.dto.ActionResponse(t.name , s.name ) FROM Teacher t JOIN t.studentList s ")
    public List<ActionResponse> getAllMembersInformation();

    @Query("SELECT new com.example.demo.action.dto.PostResponse(t.name , s.post,s.createData,s.id ) FROM Teacher t JOIN t.postList s ")
    public List<PostResponse> getAllPostInformation();


    Optional<Teacher> findTeacherByEmail(String email);


}
