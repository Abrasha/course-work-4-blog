package com.aabramov.blog.service.impl;

import com.aabramov.blog.core.model.Color;
import com.aabramov.blog.persistence.repository.ColorRepository;
import com.aabramov.blog.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Service
public class ColorServiceImpl extends AbstractService<Color> implements ColorService {
    
    private final ColorRepository colorRepository;
    
    @Autowired
    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }
    
    @Override
    protected JpaRepository<Color, Long> getRepository() {
        return colorRepository;
    }
}
