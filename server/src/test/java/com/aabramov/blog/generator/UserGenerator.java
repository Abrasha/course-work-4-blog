package com.aabramov.blog.generator;

import com.aabramov.blog.core.model.User;

import java.util.Collections;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public class UserGenerator {
    
    public static User getValidUser(String username) {
        User result = new User();
        result.setUsername(username);
        result.setPassword("password:for:" + username);
        result.setEmail(username + "@example.com");
        result.setFavouriteTags(Collections.emptySet());
        
        return result;
    }
    
}
