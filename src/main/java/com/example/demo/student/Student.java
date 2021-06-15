package com.example.demo.student;

import com.example.demo.post.Post;
import com.example.demo.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize=1
    )
    @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String email;
    private String name;
    private String surname;
    private LocalDate dob;
    @Transient // Mówi ze nie musi to byc kolumna w naszej database bo bedziemy ja sobie przeliczali
    private Integer age;
    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }
    public Student(String email,
                   String name,
                   String surname,
                   LocalDate dob

                   ) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.dob = dob;

    }

}
