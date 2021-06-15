package com.example.demo.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Post  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String post;
    private LocalDate createData = LocalDate.now();

    public Post(String post) {
        this.post = post;
        this.createData = LocalDate.now();
    }
}


