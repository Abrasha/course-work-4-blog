package com.aabramov.blog.persistence.repository;

import com.aabramov.blog.BlogApplication;
import com.aabramov.blog.core.model.Tag;
import com.aabramov.blog.generator.ColorGenerator;
import com.aabramov.blog.generator.TagGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Rollback
@Sql(scripts = "classpath:database/tags.sql")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BlogApplication.class)
public class TagRepositoryTest {
    
    private static final Long VALID_ID = 1L;
    private static final Long INVALID_ID = 3L;
    
    @Autowired
    private TagRepository tagRepository;
    
    @Test
    public void testGetByIdExists() throws Exception {
        Tag result = tagRepository.findOne(VALID_ID);
        assertNotNull(result);
        assertNotNull(result.getId());
    }
    
    @Test
    public void testGetByIdDoesNotExists() throws Exception {
        Tag result = tagRepository.findOne(INVALID_ID);
        assertNull(result);
    }
    
    @Test
    public void testInsert() throws Exception {
        Tag toSave = TagGenerator.getValidTag("test-tag-3", ColorGenerator.getValidColor());
        toSave.getColor().setId(1L);
        assertNotNull(toSave);
        
        Tag saved = tagRepository.save(toSave);
        assertNotNull(saved);
        assertNotNull(saved.getId());
        
        assertEquals(3, tagRepository.count());
    }
    
    @Test
    public void testCount() throws Exception {
        assertEquals(2, tagRepository.count());
    }
}