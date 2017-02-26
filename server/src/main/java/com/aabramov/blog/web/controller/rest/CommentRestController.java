package com.aabramov.blog.web.controller.rest;

import com.aabramov.blog.core.model.Comment;
import com.aabramov.blog.service.CommentService;
import com.aabramov.blog.service.Service;
import com.aabramov.blog.web.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@RestController
@RequestMapping(Paths.Comments.ROOT)
public class CommentRestController extends AbstractRestController<CommentDto, Comment> {
    
    private final CommentService commentService;
    
    @Autowired
    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }
    
    @Override
    @GetMapping
    public List<CommentDto> getAll() {
        return super.getAll();
    }
    
    @GetMapping(value = Paths.Comments.ID, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public CommentDto getOne(@PathVariable("id") Long id) {
        return super.getOne(id);
    }
    
    @Override
    @PutMapping(value = Paths.Comments.ID, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public CommentDto update(@PathVariable("id") Long id, @RequestBody CommentDto body) {
        return super.update(id, body);
    }
    
    @Override
    @DeleteMapping(value = Paths.Comments.ID)
    public void delete(@PathVariable("id") Long id) {
        super.delete(id);
    }
    
    @Override
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public CommentDto save(@RequestBody CommentDto body) {
        return super.save(body);
    }
    
    @Override
    @GetMapping(value = Paths.Comments.COUNT)
    public long count() {
        return super.count();
    }
    
    @Override
    public Service<Comment> getService() {
        return commentService;
    }
    
    @Override
    public Class<CommentDto> getDtoClass() {
        return CommentDto.class;
    }
    
    @Override
    public Class<Comment> getEntityClass() {
        return Comment.class;
    }
}
