package com.aabramov.blog.web.controller.rest;

import com.aabramov.blog.core.model.User;
import com.aabramov.blog.generator.UserGenerator;
import com.aabramov.blog.service.UserService;
import com.aabramov.blog.test.annotation.SpringTest;
import com.aabramov.blog.web.dto.UserDto;
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
@MockBeans(@MockBean(UserService.class))
@RunWith(SpringRunner.class)
public class UserRestControllerTest {
    
    private static final Long VALID_ID = 1L;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRestController userRestController;
    
    @Test
    public void getAll() throws Exception {
        long expectedCount = 3L;
        when(userService.count()).thenReturn(expectedCount);
        
        assertEquals(expectedCount, userRestController.count());
    }
    
    @Test
    public void getOne() throws Exception {
        User expected = UserGenerator.getValidUser("testable");
        
        when(userService.find(VALID_ID)).thenReturn(expected);
        
        assertEquals(userRestController.convertToDto(expected), userRestController.getOne(VALID_ID));
    }
    
    @Test
    public void update() throws Exception {
        User user = UserGenerator.getValidUser("testable");
        user.setId(VALID_ID);
        
        UserDto expected = userRestController.convertToDto(user);
        
        when(userService.update(user)).thenReturn(user);
        
        assertEquals(expected, userRestController.update(VALID_ID, expected));
    }
    
    @Test
    public void save() throws Exception {
        User user = UserGenerator.getValidUser("testable");
        user.setId(VALID_ID);
        
        UserDto expected = userRestController.convertToDto(user);
        
        when(userService.save(user)).thenReturn(user);
        
        assertEquals(expected, userRestController.save(expected));
    }
    
}