package com.example.demo.teacher;

import com.example.demo.post.Post;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers() {
        return (List<Teacher>) teacherRepository.findAll();

    }
    public void addNewTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findTeacherByEmail(teacher.getEmail());
        if (teacherOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        teacherRepository.save(teacher);
        System.out.println("To jest :" + teacher.getName()+"prawidłowo dodany");

    }

    public void deleteTeacher(Long teacherId) {
        teacherRepository.findById(teacherId);
        boolean exist = teacherRepository.existsById(teacherId);
        if (!exist) {
            throw new IllegalStateException("Teacher with id " + teacherId + " does noot exist");
        }
        teacherRepository.deleteById(teacherId);

    }

    public void addPostByTeacher(Long teacherId, Post post) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new IllegalStateException("teacher with id" + teacherId + "does not exist"));
        teacher.addPostToList(post);
        teacherRepository.save(teacher);
    }





    @Transactional
    public void updateTeacher(Long teacherId,
                              String name,
                              String email) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new IllegalStateException("teacher with id" + teacherId + "does not exist"));
        if (name != null &&
                name.length() > 0 && (teacher.getName()!=name))
        {
            teacher.setName(name);
        }

        if (email != null &&
                email.length() > 0 && (teacher.getEmail()!=email))
        {
            Optional<Teacher> teacherOptional = teacherRepository.findTeacherByEmail(email);
            if (teacherOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            teacher.setEmail(email);
        }
        teacherRepository.save(teacher);



    }





}
