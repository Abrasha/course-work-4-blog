package com.aabramov.blog.web.controller.rest;

import com.aabramov.blog.core.model.Post;
import com.aabramov.blog.service.PostService;
import com.aabramov.blog.service.Service;
import com.aabramov.blog.web.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@RestController
@RequestMapping(Paths.Posts.ROOT)
public class PostRestController extends AbstractRestController<PostDto, Post> {
    
    private final PostService postService;
    
    @Autowired
    public PostRestController(PostService postService) {
        this.postService = postService;
    }
    
    @Override
    @GetMapping
    public List<PostDto> getAll() {
        return super.getAll();
    }
    
    @Override
    @GetMapping(value = Paths.Posts.ID, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public PostDto getOne(@PathVariable("id") Long id) {
        return super.getOne(id);
    }
    
    @Override
    @PutMapping(value = Paths.Posts.ID, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public PostDto update(@PathVariable("id") Long id, @RequestBody PostDto body) {
        return super.update(id, body);
    }
    
    @Override
    @DeleteMapping(value = Paths.Posts.ID)
    public void delete(@PathVariable("id") Long id) {
        super.delete(id);
    }
    
    @Override
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public PostDto save(@RequestBody PostDto body) {
        return super.save(body);
    }
    
    @Override
    @GetMapping(value = Paths.Posts.COUNT)
    public long count() {
        return super.count();
    }
    
    @Override
    public Service<Post> getService() {
        return postService;
    }
    
    @Override
    public Class<PostDto> getDtoClass() {
        return PostDto.class;
    }
    
    @Override
    public Class<Post> getEntityClass() {
        return Post.class;
    }
}
