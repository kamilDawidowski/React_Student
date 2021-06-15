package com.example.demo.post;

import com.example.demo.action.dto.PostResponse;
import com.example.demo.student.Student;
import com.example.demo.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins ="http://localhost:3000")
@CrossOrigin(origins = "https://studentreact1.herokuapp.com")

@RestController
@RequestMapping(path = "post")
public class PostController {


    private final PostService postService;



    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping
    public List<Post> getPosts() {

        return postService.getPosts();

    }
    @DeleteMapping(path = "deletPost/{postId}")
    public void deletePost(@PathVariable("postId") Long postId) {

        postService.deletePost(postId);

    }


}