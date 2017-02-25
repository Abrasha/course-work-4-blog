package com.aabramov.blog.service;

import com.aabramov.blog.core.model.Color;
import com.aabramov.blog.persistence.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Service
public class ColorService extends AbstractService<Color> {
    
    private final ColorRepository colorRepository;
    
    @Autowired
    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }
    
    @Override
    protected JpaRepository<Color, Long> getRepository() {
        return colorRepository;
    }
}
