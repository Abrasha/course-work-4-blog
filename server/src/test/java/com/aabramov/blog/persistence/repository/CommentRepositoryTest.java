package com.aabramov.blog.persistence.repository;

import com.aabramov.blog.core.model.Comment;
import com.aabramov.blog.generator.CommentGenerator;
import com.aabramov.blog.test.annotation.RepositoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@RepositoryTest("classpath:database/comments.sql")
@RunWith(SpringRunner.class)
public class CommentRepositoryTest {
    
    private static final Long VALID_ID = 1L;
    private static final Long INVALID_ID = 4L;
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Test
    public void testCount() throws Exception {
        assertEquals(3L, commentRepository.count());
    }
    
    @Test
    @Transactional
    public void testGetById() throws Exception {
        Comment post = commentRepository.findOne(VALID_ID);
        assertNotNull(post);
        assertNotNull(post.getId());
        assertNotNull(post.getBody());
        assertNotNull(post.getPost());
    }
    
    @Test
    public void testGetByIdNotExists() throws Exception {
        Comment one = commentRepository.findOne(INVALID_ID);
        assertNull(one);
    }
    
    @Test
    public void testInsertNewPost() throws Exception {
        Comment comment = CommentGenerator.getValidComment("nice topic");
        comment.getAuthor().setId(1L);
        comment.getPost().setId(1L);
        Comment saved = commentRepository.save(comment);
        
        assertNotNull(saved);
        assertNotNull(saved.getId());
        
        assertEquals(4L, commentRepository.count());
    }
    
    @Test
    public void testUpdatePost() throws Exception {
        Comment comment = commentRepository.findOne(VALID_ID);
        assertNotNull(comment);
        assertNotNull(comment.getId());
        
        comment.setBody("new body");
        
        Comment updated = commentRepository.save(comment);
        assertEquals(comment, updated);
    }
    
    @Test
    @Transactional
    public void testDeletePost() throws Exception {
        commentRepository.delete(VALID_ID);
        assertEquals(2L, commentRepository.count());
    }
    
}