package com.aabramov.blog.service;

import com.aabramov.blog.core.model.Post;
import com.aabramov.blog.generator.PostGenerator;
import com.aabramov.blog.persistence.repository.PostRepository;
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
@MockBeans(@MockBean(PostRepository.class))
@RunWith(SpringRunner.class)
public class PostServiceTest {
    
    private static final Long VALID_ID = 1L;
    
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private PostService postService;
    
    @Test
    public void testFindOne() throws Exception {
        Post expected = PostGenerator.getValidPost("post1", "body1");
        expected.setId(VALID_ID);
        
        when(postRepository.findOne(VALID_ID)).thenReturn(expected);
        
        Post actual = postService.find(VALID_ID);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindAll() throws Exception {
        when(postRepository.findAll()).thenReturn(
                Arrays.asList(new Post(), new Post(), new Post())
        );
        
        List<Post> result = postRepository.findAll();
        
        assertNotNull(result);
        assertEquals(3, result.size());
    }
    
    @Test
    public void testCount() throws Exception {
        when(postRepository.count()).thenReturn(3L);
        
        assertEquals(3, postService.count());
    }
    
    @Test
    public void testUpdate() throws Exception {
        Post toUpdate = PostGenerator.getValidPost("t1", "b1");
        
        when(postRepository.save(toUpdate)).thenReturn(toUpdate);
        
        assertEquals(toUpdate, postService.update(toUpdate));
    }
}