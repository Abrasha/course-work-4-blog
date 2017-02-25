package com.aabramov.blog.service;

import com.aabramov.blog.core.model.Tag;
import com.aabramov.blog.persistence.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Service
public class TagService extends AbstractService<Tag> {
    
    private final TagRepository tagRepository;
    
    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    
    @Override
    protected JpaRepository<Tag, Long> getRepository() {
        return tagRepository;
    }
}
