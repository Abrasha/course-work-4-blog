package com.aabramov.blog.service;

import com.aabramov.blog.core.model.AbstractEntity;

import java.util.List;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public interface Service<T extends AbstractEntity> {
    
    void delete(Long id);
    
    T save(T entity);
    
    long count();
    
    T update(T entity);
    
    T find(Long id);
    
    List<T> findAll();
    
}
