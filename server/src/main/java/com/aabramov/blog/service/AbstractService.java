package com.aabramov.blog.service;

import com.aabramov.blog.core.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public abstract class AbstractService<T extends AbstractEntity> implements Service<T, Long> {
    
    @Override
    public void delete(Long id) {
        getRepository().delete(id);
    }
    
    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }
    
    @Override
    public T update(T entity) {
        return getRepository().save(entity);
    }
    
    @Override
    public T find(Long id) {
        return getRepository().findOne(id);
    }
    
    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }
    
    @Override
    public long count() {
        return getRepository().count();
    }
    
    protected abstract JpaRepository<T, Long> getRepository();
    
}
