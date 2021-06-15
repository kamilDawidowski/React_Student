package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// łączenie z baza danych ostani klocek i to jest uzywane w Service
@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}












//    POST http://localhost:8080/kamil/main
//        Content-Type: application/json
//
//        {
//        "email": "ccccccc",
//        "classMaster":"ddddd",
//        "name": "Bob",
//        "surname":"dddddd",
//        "dob":"1993-04-04"
//        }