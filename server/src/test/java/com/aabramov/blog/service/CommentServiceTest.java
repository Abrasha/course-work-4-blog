package com.aabramov.blog.service;

import com.aabramov.blog.core.model.Comment;
import com.aabramov.blog.generator.CommentGenerator;
import com.aabramov.blog.persistence.repository.CommentRepository;
import com.aabramov.blog.test.annotation.SpringTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@SpringTest
@MockBeans(@MockBean(CommentRepository.class))
@RunWith(SpringRunner.class)
public class CommentServiceTest {
    
    private static final Long VALID_ID = 1L;
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private CommentService commentService;
    
    @Test
    public void testFindOne() throws Exception {
        Comment expected = CommentGenerator.getValidComment("random");
        
        when(commentRepository.findOne(VALID_ID)).thenReturn(expected);
        
        Comment actual = commentService.find(VALID_ID);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindAll() throws Exception {
        when(commentRepository.findAll()).thenReturn(
                Arrays.asList(new Comment(), new Comment(), new Comment())
        );
        
        List<Comment> result = commentService.findAll();
        
        assertNotNull(result);
        assertEquals(3, result.size());
    }
    
    @Test
    public void testCount() throws Exception {
        when(commentRepository.count()).thenReturn(3L);
        
        assertEquals(3, commentService.count());
    }
    
    @Test
    public void testUpdate() throws Exception {
        Comment toUpdate = CommentGenerator.getValidComment("random content");
        
        when(commentRepository.save(toUpdate)).thenReturn(toUpdate);
        
        assertEquals(toUpdate, commentService.update(toUpdate));
    }
}