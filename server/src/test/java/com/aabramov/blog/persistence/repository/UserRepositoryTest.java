package com.aabramov.blog.persistence.repository;

import com.aabramov.blog.core.model.Tag;
import com.aabramov.blog.core.model.User;
import com.aabramov.blog.generator.UserGenerator;
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
@RepositoryTest("classpath:database/users.sql")
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    
    private static final Long VALID_ID = 1L;
    private static final Long INVALID_ID = 3L;
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void testCount() throws Exception {
        assertEquals(2L, userRepository.count());
    }
    
    @Test
    @Transactional
    public void testGetById() throws Exception {
        User user = userRepository.findOne(VALID_ID);
        assertNotNull(user);
        assertNotNull(user.getId());
        assertNotNull(user.getEmail());
        assertNotNull(user.getUsername());
        assertNotNull(user.getPassword());
        assertNotNull(user.getFavouriteTags());
        
        assertEquals(1, user.getFavouriteTags().size());
    }
    
    @Test
    public void testGetByIdNotExists() throws Exception {
        User one = userRepository.findOne(INVALID_ID);
        assertNull(one);
    }
    
    @Test
    public void testInsertNewUser() throws Exception {
        User user = UserGenerator.getValidUser("insertionUser");
        User saved = userRepository.save(user);
        
        assertNotNull(saved);
        assertNotNull(saved.getId());
        
        assertEquals(3L, userRepository.count());
    }
    
    @Test
    public void testUpdateUser() throws Exception {
        User user = userRepository.findOne(VALID_ID);
        assertNotNull(user);
        assertNotNull(user.getId());
        
        user.setUsername("after-update");
        user.setPassword("new password");
        
        User updated = userRepository.save(user);
        assertEquals(user, updated);
    }
    
    @Test
    @Transactional
    public void testDeleteUser() throws Exception {
        userRepository.delete(VALID_ID);
        assertEquals(1L, userRepository.count());
    }
    
    @Test
    @Transactional
    public void testAddNewTagToUser() throws Exception {
        User user = userRepository.findOne(VALID_ID);
        assertNotNull(user);
        
        Tag tag = new Tag();
        tag.setId(2L);
        
        user.getFavouriteTags().add(tag);
        
        User saved = userRepository.save(user);
        
        assertEquals(2, saved.getFavouriteTags().size());
    }
    
    @Test
    @Transactional
    public void testRemoveTagFromUser() throws Exception {
        User user = userRepository.findOne(VALID_ID);
        assertNotNull(user);
        
        user.getFavouriteTags().removeIf(tag -> tag.getId() == 1L);
        assertEquals(0, user.getFavouriteTags().size());
        
        User saved = userRepository.save(user);
        assertEquals(0, saved.getFavouriteTags().size());
    }
}