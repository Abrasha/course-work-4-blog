package com.aabramov.blog.service.impl;

import com.aabramov.blog.core.model.Comment;
import com.aabramov.blog.persistence.repository.CommentRepository;
import com.aabramov.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Abramov on 2/26/17.
 */
@Service
public class CommentServiceImpl extends AbstractService<Comment> implements CommentService {
    
    private final CommentRepository commentRepository;
    
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    
    @Override
    protected JpaRepository<Comment, Long> getRepository() {
        return commentRepository;
    }
}
