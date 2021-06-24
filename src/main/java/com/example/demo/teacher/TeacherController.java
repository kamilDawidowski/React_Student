package com.example.demo.teacher;

import com.example.demo.post.Post;
import com.example.demo.student.Student;
import com.example.demo.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "https://react-student-app-1.herokuapp.com")
@RestController
@RequestMapping(path = "teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherService teacherService, TeacherRepository teacherRepository) {
        this.teacherService = teacherService;
        this.teacherRepository = teacherRepository;
    }
    @GetMapping("/getTeachers")
    public ResponseEntity<List<Teacher>> getTeacher() {

        return new ResponseEntity<>(teacherService.getTeachers(), HttpStatus.OK);

    }
    @GetMapping("/getTeacherId/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ExpressionException("Nie ma takiego nauczyciela"));
        return ResponseEntity.ok(teacher);

    }

    @PostMapping("/newTeacher")
    public ResponseEntity registerNewTeacher(@RequestBody Teacher teacher) {
        teacherService.addNewTeacher(teacher);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "deletTeacher/{teacherId}")
    public void deleteStudent(@PathVariable("teacherId") Long teacherId) {

        teacherService.deleteTeacher(teacherId);

    }
    @PutMapping(path = "/updateTeacher/{teacherId}")
    public ResponseEntity<Teacher> updateStudent(
            @PathVariable Long teacherId, @RequestBody Teacher teacherInfo) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException("Nie ma studenta"));

        teacher.setName((teacherInfo.getName()));
        teacher.setEmail((teacherInfo.getEmail()));

        Teacher updatedTeacher = teacherRepository.save(teacher);
        return ResponseEntity.ok(updatedTeacher);
    }
    @PutMapping(path = "/addTeacherById/{teacherId}")
    public ResponseEntity<Teacher> addPostById(
            @PathVariable Long teacherId, @RequestBody Post postInfo) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException("Nie ma nauczyciela"));
        teacher.addPostToList((postInfo));
        Teacher updatedTeacherWithPost = teacher;
        teacherRepository.save(teacher);
        return ResponseEntity.ok(updatedTeacherWithPost);
    }


}
