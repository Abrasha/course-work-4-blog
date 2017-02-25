package com.aabramov.blog.web.controller.rest;

import com.aabramov.blog.core.model.AbstractEntity;
import com.aabramov.blog.service.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public abstract class AbstractRestController<Dto, Entity extends AbstractEntity> {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public List<Dto> getAll() {
        return convertToDto(getService().findAll());
    }
    
    public Dto getOne(Long id) {
        return convertToDto(getService().find(id));
    }
    
    public Dto update(Long id, Dto body) {
        Entity entity = convertToEntity(body);
        entity.setId(id);
        return convertToDto(getService().update(entity));
    }
    
    public void delete(Long id) {
        getService().delete(id);
    }
    
    public Dto save(Dto body) {
        Entity entity = convertToEntity(body);
        return convertToDto(getService().save(entity));
    }
    
    public long count() {
        return getService().count();
    }
    
    public abstract Service<Entity> getService();
    
    public abstract Class<Dto> getDtoClass();
    
    public abstract Class<Entity> getEntityClass();
    
    protected Dto convertToDto(Entity entity) {
        return modelMapper.map(entity, getDtoClass());
    }
    
    protected List<Dto> convertToDto(List<Entity> entities) {
        return entities.stream()
                .map(entity -> modelMapper.map(entity, getDtoClass()))
                .collect(Collectors.toList());
    }
    
    protected Entity convertToEntity(Dto dto) {
        return modelMapper.map(dto, getEntityClass());
    }
    
    protected List<Entity> convertToEntity(List<Dto> dtos) {
        return dtos.stream()
                .map(dto -> modelMapper.map(dto, getEntityClass()))
                .collect(Collectors.toList());
    }
}
