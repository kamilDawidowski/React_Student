package com.example.demo.student;

import com.example.demo.post.Post;
import com.example.demo.teacher.Teacher;
import com.example.demo.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "https://react-student-app-1.herokuapp.com", maxAge = 3600)
//@CrossOrigin(origins ="http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "student")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    private TeacherRepository teacherRepository;



    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents() {

        return studentService.getStudents();

    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {

        studentService.addNewStudent(student);

    }
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId) {

        studentService.deleteStudent(studentId);

    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email)
    {
        studentService.updateStudent(studentId,name,email);
    }

    @PutMapping(path = "/addStudentById/{teacherId}")
    public ResponseEntity<Teacher> addStudentById(
            @PathVariable Long teacherId,@RequestBody Student studentInfo)
    {
        Teacher teacher=teacherRepository.findById(teacherId)
                .orElseThrow(()-> new IllegalStateException("Nie ma nauczyciela do dodania studenta"));
        teacher.addStudentToList((studentInfo));
        teacherRepository.save(teacher);
        Teacher updatedTeacherWithStudent=teacher;
        return  ResponseEntity.ok(updatedTeacherWithStudent);
    }


}
