package com.aabramov.blog;

import com.aabramov.blog.core.model.Post;
import com.aabramov.blog.core.model.User;
import com.aabramov.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@RestController
public class BlogApplication {
    
    @Autowired
    private PostService postService;
    
    @GetMapping("/")
    public List<Post> posts() {
        Post post = new Post();
        post.setBody("I am body");
        post.setTitle("I am title");
        post.setCreationDate(LocalDateTime.now());
        User author = new User();
        author.setId(1L);
        post.setAuthor(author);
        postService.save(post);
        return postService.findAll();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
