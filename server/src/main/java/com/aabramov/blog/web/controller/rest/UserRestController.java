package com.aabramov.blog.web.controller.rest;

import com.aabramov.blog.core.model.User;
import com.aabramov.blog.service.Service;
import com.aabramov.blog.service.UserService;
import com.aabramov.blog.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@RestController
@RequestMapping(Paths.Users.ROOT)
public class UserRestController extends AbstractRestController<UserDto, User> {
    
    private final UserService userService;
    
    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    @GetMapping
    public List<UserDto> getAll() {
        return super.getAll();
    }
    
    @Override
    @GetMapping(value = Paths.Users.ID, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public UserDto getOne(@PathVariable("id") Long id) {
        return super.getOne(id);
    }
    
    @Override
    @PutMapping(value = Paths.Users.ID, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public UserDto update(@PathVariable("id") Long id, @RequestBody UserDto body) {
        return super.update(id, body);
    }
    
    @Override
    @DeleteMapping(value = Paths.Users.ID)
    public void delete(@PathVariable("id") Long id) {
        super.delete(id);
    }
    
    @Override
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public UserDto save(@RequestBody UserDto body) {
        return super.save(body);
    }
    
    @Override
    @GetMapping(value = Paths.Users.COUNT)
    public long count() {
        return super.count();
    }
    
    @Override
    public Service<User> getService() {
        return userService;
    }
    
    @Override
    public Class<UserDto> getDtoClass() {
        return UserDto.class;
    }
    
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
