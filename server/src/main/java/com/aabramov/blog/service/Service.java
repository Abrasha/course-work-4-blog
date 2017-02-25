package com.aabramov.blog.service;

import com.aabramov.blog.core.model.AbstractEntity;

import java.util.List;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public interface Service<T extends AbstractEntity> {
    
    T find(Long id);
    
    List<T> findAll();
    
    T save(T entity);
    
    T update(T entity);
    
    void delete(Long id);
    
    long count();
    
}
