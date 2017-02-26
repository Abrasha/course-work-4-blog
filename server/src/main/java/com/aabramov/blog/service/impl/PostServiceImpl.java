package com.aabramov.blog.service.impl;

import com.aabramov.blog.core.model.Post;
import com.aabramov.blog.persistence.repository.PostRepository;
import com.aabramov.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Abramov on 2/26/17.
 */
@Service
public class PostServiceImpl extends AbstractService<Post> implements PostService {
    
    private final PostRepository postRepository;
    
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    
    @Override
    protected JpaRepository<Post, Long> getRepository() {
        return postRepository;
    }
}
