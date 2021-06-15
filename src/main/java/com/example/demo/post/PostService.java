package com.example.demo.post;


import com.example.demo.teacher.Teacher;
import com.example.demo.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return (List<Post>) postRepository.findAll();

    }

    public void deletePost(Long postId) {
        postRepository.findById(postId);
        boolean exist = postRepository.existsById(postId);
        if (!exist) {
            throw new IllegalStateException("Postwith id " + postId + " does noot exist");
        }
        postRepository.deleteById(postId);

    }





}