package com.aabramov.blog.persistence.repository;

import com.aabramov.blog.core.model.Post;
import com.aabramov.blog.core.model.Tag;
import com.aabramov.blog.generator.PostGenerator;
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
@RepositoryTest("classpath:database/posts.sql")
@RunWith(SpringRunner.class)
public class PostRepositoryTest {
    
    private static final Long VALID_ID = 1L;
    private static final Long INVALID_ID = 4L;
    
    @Autowired
    private PostRepository postRepository;
    
    @Test
    public void testCount() throws Exception {
        assertEquals(3L, postRepository.count());
    }
    
    @Test
    @Transactional
    public void testGetById() throws Exception {
        Post post = postRepository.findOne(VALID_ID);
        assertNotNull(post);
        assertNotNull(post.getId());
        assertNotNull(post.getBody());
        assertNotNull(post.getTitle());
        
        assertEquals(2, post.getTags().size());
    }
    
    @Test
    public void testGetByIdNotExists() throws Exception {
        Post one = postRepository.findOne(INVALID_ID);
        assertNull(one);
    }
    
    @Test
    public void testInsertNewPost() throws Exception {
        Post post = PostGenerator.getValidPost("post title", "post body");
        Post saved = postRepository.save(post);
        
        assertNotNull(saved);
        assertNotNull(saved.getId());
        
        assertEquals(4L, postRepository.count());
    }
    
    @Test
    public void testUpdatePost() throws Exception {
        Post post = postRepository.findOne(VALID_ID);
        assertNotNull(post);
        assertNotNull(post.getId());
        
        post.setTitle("new title");
        post.setBody("new body");
        
        Post updated = postRepository.save(post);
        assertEquals(post, updated);
    }
    
    @Test
    @Transactional
    public void testDeletePost() throws Exception {
        postRepository.delete(VALID_ID);
        assertEquals(2L, postRepository.count());
    }
    
    @Test
    @Transactional
    public void testAddNewTagToPost() throws Exception {
        Post post = postRepository.findOne(VALID_ID);
        assertNotNull(post);
        
        Tag tag = new Tag();
        tag.setId(2L);
        
        post.getTags().add(tag);
        
        Post saved = postRepository.save(post);
        
        assertEquals(2, saved.getTags().size());
    }
    
    @Test
    @Transactional
    public void testRemoveTagFromPost() throws Exception {
        Post post = postRepository.findOne(VALID_ID);
        assertNotNull(post);
        
        post.getTags().removeIf(tag -> tag.getId() == 1L);
        assertEquals(1, post.getTags().size());
        
        Post saved = postRepository.save(post);
        assertEquals(1, saved.getTags().size());
    }
}