package com.aabramov.blog.web.controller.rest;

import com.aabramov.blog.core.model.Color;
import com.aabramov.blog.service.ColorService;
import com.aabramov.blog.service.Service;
import com.aabramov.blog.web.dto.ColorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@RestController
@RequestMapping(Paths.COLORS)
public class ColorRestController extends AbstractRestController<ColorDto, Color> {
    
    private final ColorService colorService;
    
    @Autowired
    public ColorRestController(ColorService colorService) {
        this.colorService = colorService;
    }
    
    @Override
    @GetMapping
    public List<ColorDto> getAll() {
        return super.getAll();
    }
    
    @Override
    @GetMapping(value = "/{id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ColorDto getOne(@PathVariable("id") Long id) {
        return super.getOne(id);
    }
    
    @Override
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ColorDto update(@PathVariable("id") Long id, @RequestBody ColorDto body) {
        return super.update(id, body);
    }
    
    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        super.delete(id);
    }
    
    @Override
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ColorDto save(ColorDto body) {
        return super.save(body);
    }
    
    @Override
    @GetMapping(value = "/count")
    public long count() {
        return super.count();
    }
    
    @Override
    public Service<Color> getService() {
        return colorService;
    }
    
    @Override
    public Class<ColorDto> getDtoClass() {
        return ColorDto.class;
    }
    
    @Override
    public Class<Color> getEntityClass() {
        return Color.class;
    }
}
