package com.aabramov.blog.generator;

import com.aabramov.blog.core.model.Comment;

import java.time.LocalDateTime;

/**
 * @author Andrii Abramov on 2/26/17.
 */
public class CommentGenerator {
    
    public static Comment getValidComment(String content) {
        Comment comment = new Comment();
        comment.setCreationDate(LocalDateTime.now());
        comment.setAuthor(UserGenerator.getValidUser("commenter"));
        comment.setBody(content);
        comment.setPost(PostGenerator.getValidPost("comment me", "comment me please"));
        
        return comment;
    }
    
}
