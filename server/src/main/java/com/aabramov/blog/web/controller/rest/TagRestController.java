package com.aabramov.blog.web.controller.rest;

import com.aabramov.blog.core.model.Tag;
import com.aabramov.blog.service.Service;
import com.aabramov.blog.service.TagService;
import com.aabramov.blog.web.dto.TagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@RestController
@RequestMapping(Paths.Tags.ROOT)
public class TagRestController extends AbstractRestController<TagDto, Tag> {
    
    private final TagService tagService;
    
    @Autowired
    public TagRestController(TagService tagService) {
        this.tagService = tagService;
    }
    
    @Override
    @GetMapping
    public List<TagDto> getAll() {
        return super.getAll();
    }
    
    @Override
    @GetMapping(value = Paths.Tags.ID, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public TagDto getOne(@PathVariable("id") Long id) {
        return super.getOne(id);
    }
    
    @Override
    @PutMapping(value = Paths.Tags.ID, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public TagDto update(@PathVariable("id") Long id, @RequestBody TagDto body) {
        return super.update(id, body);
    }
    
    @Override
    @DeleteMapping(value = Paths.Tags.ID)
    public void delete(@PathVariable("id") Long id) {
        super.delete(id);
    }
    
    @Override
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public TagDto save(@RequestBody TagDto body) {
        return super.save(body);
    }
    
    @Override
    @GetMapping(value = Paths.Tags.COUNT)
    public long count() {
        return super.count();
    }
    
    @Override
    public Service<Tag> getService() {
        return tagService;
    }
    
    @Override
    public Class<TagDto> getDtoClass() {
        return TagDto.class;
    }
    
    @Override
    public Class<Tag> getEntityClass() {
        return Tag.class;
    }
}
