package com.example.demo.teacher;

import com.example.demo.post.Post;
import com.example.demo.student.Student;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
@ToString
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String atribute="Nauczyciel";


    @OneToMany(
            targetEntity = Student.class, // ustwia na referncje w drugiej klasie
            cascade = CascadeType.ALL,// kazda operacja bedzie przypożadkowyc tej element
            orphanRemoval = true // jesli usuniemy nauczyclea uczniowie beda tez usunięci

    )
    @JoinColumn(name = "cp_fk",referencedColumnName ="id")
    private List<Student> studentList=new ArrayList<>();

    @OneToMany(
            targetEntity = Post.class, // ustwia na referncje w drugiej klasie
            cascade = CascadeType.ALL,// kazda operacja bedzie przypożadkowyc tej element
            orphanRemoval = true // jesli usuniemy nauczyclea uczniowie beda tez usunięci

    )
    @JoinColumn(name = "cp_fk",referencedColumnName ="id")
    private List<Post> postList=new ArrayList<>();

    @Column(nullable = true, length = 64)
    private String photos;



    public void addPostToList(Post post) {
        this.postList.add(post);
    }
    public void addStudentToList(Student student) {
        this.studentList.add(student);
    }

    public Teacher(String name, String email) {
        this.name = name;
        this.email = email;
        this.atribute = "Nauczyciel";
    }

    public Teacher(String name, String email,List<Student> studentList) {
        this.name = name;
        this.email = email;
        this.atribute = "Nauczyciel";
        this.studentList=studentList;
    }
    public Teacher(String name, String email,List<Student> studentList,List<Post> postList) {
        this.name = name;
        this.email = email;
        this.atribute = "Nauczyciel";
        this.studentList=studentList;
        this.postList=postList;
    }

    public Teacher(String name, String email, String atribute, String photos) {
        this.name = name;
        this.email = email;
        this.atribute = "Nauczyciel";
        this.photos = photos;
    }
}
