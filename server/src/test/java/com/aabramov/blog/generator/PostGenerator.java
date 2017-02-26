package com.aabramov.blog.generator;

import com.aabramov.blog.core.model.Post;

import java.time.LocalDateTime;

/**
 * @author Andrii Abramov on 2/26/17.
 */
public class PostGenerator {
    
    public static Post getValidPost(String title, String body) {
        Post result = new Post();
        result.setTitle(title);
        result.setBody(body);
        result.setCreationDate(LocalDateTime.now());
        return result;
    }
    
}
