package com.example.demo.action;

import com.example.demo.action.dto.ActionRequest;
import com.example.demo.action.dto.ActionResponse;
import com.example.demo.action.dto.PostResponse;
import com.example.demo.post.Post;
import com.example.demo.post.PostRepository;
import com.example.demo.post.PostService;
import com.example.demo.student.StudentRepository;
import com.example.demo.teacher.Teacher;
import com.example.demo.teacher.TeacherRepository;
import com.example.demo.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins ="http://localhost:3000")
//@CrossOrigin(origins = "https://studentreact1.herokuapp.com")
@RestController
public class ActionController {
    @Autowired
    private TeacherRepository teacherRepository;



    @PostMapping("/addStudentsToClass")
    public Teacher addStudentToClass(@RequestBody ActionRequest actionRequest) {
        return teacherRepository.save(actionRequest.getTeacher());
    }
    @GetMapping("/findAllTeachers")
    public List<Teacher> findAllClass() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @GetMapping("/findAllMembers")
    public List<ActionResponse> getAllMembersInformation() {
        return teacherRepository.getAllMembersInformation();
    }

    @GetMapping("/postList")
    public List<PostResponse> getAllPostInformation() { return teacherRepository.getAllPostInformation(); }





}
