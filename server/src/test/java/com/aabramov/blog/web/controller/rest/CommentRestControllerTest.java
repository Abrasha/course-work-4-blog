package com.aabramov.blog.web.controller.rest;

import com.aabramov.blog.core.model.Comment;
import com.aabramov.blog.generator.CommentGenerator;
import com.aabramov.blog.service.CommentService;
import com.aabramov.blog.test.annotation.SpringTest;
import com.aabramov.blog.web.dto.CommentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@SpringTest
@MockBeans(@MockBean(CommentService.class))
@RunWith(SpringRunner.class)
public class CommentRestControllerTest {
    
    private static final Long VALID_ID = 1L;
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private CommentRestController commentRestControllerTest;
    
    @Test
    public void getAll() throws Exception {
        long expectedCount = 3L;
        when(commentService.count()).thenReturn(expectedCount);
        
        assertEquals(expectedCount, commentRestControllerTest.count());
    }
    
    @Test
    public void getOne() throws Exception {
        Comment expected = CommentGenerator.getValidComment("c1");
        
        when(commentService.find(VALID_ID)).thenReturn(expected);
        
        assertEquals(commentRestControllerTest.convertToDto(expected), commentRestControllerTest.getOne(VALID_ID));
    }
    
    @Test
    public void update() throws Exception {
        Comment comment = CommentGenerator.getValidComment("c1");
        comment.setId(VALID_ID);
        
        CommentDto expected = commentRestControllerTest.convertToDto(comment);
        
        when(commentService.update(comment)).thenReturn(comment);
        
        assertEquals(expected, commentRestControllerTest.update(VALID_ID, expected));
    }
    
    @Test
    public void save() throws Exception {
        Comment comment = CommentGenerator.getValidComment("c1");
        comment.setId(VALID_ID);
        
        CommentDto expected = commentRestControllerTest.convertToDto(comment);
        
        when(commentService.save(comment)).thenReturn(comment);
        
        assertEquals(expected, commentRestControllerTest.save(expected));
    }
    
}