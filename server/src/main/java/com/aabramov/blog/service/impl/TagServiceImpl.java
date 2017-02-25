package com.aabramov.blog.service.impl;

import com.aabramov.blog.core.model.Tag;
import com.aabramov.blog.persistence.repository.TagRepository;
import com.aabramov.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Service
public class TagServiceImpl extends AbstractService<Tag> implements TagService {
    
    private final TagRepository tagRepository;
    
    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    
    @Override
    protected JpaRepository<Tag, Long> getRepository() {
        return tagRepository;
    }
}
