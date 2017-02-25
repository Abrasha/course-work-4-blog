package com.aabramov.blog.service;

import com.aabramov.blog.BlogApplication;
import com.aabramov.blog.core.model.User;
import com.aabramov.blog.persistence.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Andrii Abramov on 2/26/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BlogApplication.class)
@MockBeans(
        @MockBean(classes = UserRepository.class)
)
public class UserServiceTest {
    
    private static final Long VALID_ID = 1L;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    
    @Test
    public void testFindOne() throws Exception {
        User expected = new User();
        
        when(userRepository.findOne(VALID_ID)).thenReturn(expected);
        
        assertEquals(expected, userService.find(VALID_ID));
    }
    
    @Test
    public void testUpdate() throws Exception {
        User expected = new User();
        
        when(userRepository.save(expected)).thenReturn(expected);
        
        assertEquals(expected, userService.update(expected));
    }
    
    @Test
    public void testCount() throws Exception {
        long expectedCount = 3L;
        
        when(userRepository.count()).thenReturn(expectedCount);
        
        assertEquals(expectedCount, userService.count());
    }
    
}