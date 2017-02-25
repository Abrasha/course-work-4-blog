package com.aabramov.blog.service.impl;

import com.aabramov.blog.core.model.User;
import com.aabramov.blog.persistence.repository.UserRepository;
import com.aabramov.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Abramov on 2/26/17.
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }
}
