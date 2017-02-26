package com.aabramov.blog.web.controller.rest;

import com.aabramov.blog.core.model.Post;
import com.aabramov.blog.generator.PostGenerator;
import com.aabramov.blog.service.PostService;
import com.aabramov.blog.test.annotation.SpringTest;
import com.aabramov.blog.web.dto.PostDto;
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
@MockBeans(@MockBean(PostService.class))
@RunWith(SpringRunner.class)
public class PostRestControllerTest {
    
    private static final Long VALID_ID = 1L;
    
    @Autowired
    private PostService colorService;
    
    @Autowired
    private PostRestController postRestController;
    
    @Test
    public void getAll() throws Exception {
        long expectedCount = 3L;
        when(colorService.count()).thenReturn(expectedCount);
        
        assertEquals(expectedCount, postRestController.count());
    }
    
    @Test
    public void getOne() throws Exception {
        Post expected = PostGenerator.getValidPost("p1", "c1");
        
        when(colorService.find(VALID_ID)).thenReturn(expected);
        
        assertEquals(postRestController.convertToDto(expected), postRestController.getOne(VALID_ID));
    }
    
    @Test
    public void update() throws Exception {
        Post post = PostGenerator.getValidPost("p2", "c2");
        post.setId(VALID_ID);
        
        PostDto expected = postRestController.convertToDto(post);
        
        when(colorService.update(post)).thenReturn(post);
        
        assertEquals(expected, postRestController.update(VALID_ID, expected));
    }
    
    @Test
    public void save() throws Exception {
        Post post = PostGenerator.getValidPost("p3", "c3");
        post.setId(VALID_ID);
        
        PostDto expected = postRestController.convertToDto(post);
        
        when(colorService.save(post)).thenReturn(post);
        
        assertEquals(expected, postRestController.save(expected));
    }
    
}