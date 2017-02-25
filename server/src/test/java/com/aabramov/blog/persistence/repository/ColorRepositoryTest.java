package com.aabramov.blog.persistence.repository;

import com.aabramov.blog.BlogApplication;
import com.aabramov.blog.core.model.Color;
import com.aabramov.blog.generator.ColorGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:database/colors.sql")
@ContextConfiguration(classes = BlogApplication.class)
public class ColorRepositoryTest {
    
    private static final Long VALID_ID = 1L;
    private static final Long INVALID_ID = 3L;
    
    @Autowired
    private ColorRepository colorRepository;
    
    @Test
    public void testCount() {
        assertEquals(2, colorRepository.count());
    }
    
    @Test
    public void testGetByIdExists() throws Exception {
        Color storedEntity = colorRepository.findOne(VALID_ID);
        assertNotNull(storedEntity);
        assertNotNull(storedEntity.getId());
    }
    
    @Test
    public void testGetByIdDoesNotExist() throws Exception {
        Color storedEntity = colorRepository.findOne(INVALID_ID);
        assertNull(storedEntity);
    }
    
    @Test
    public void testDeleteOneExists() throws Exception {
        colorRepository.delete(VALID_ID);
        assertEquals(1, colorRepository.count());
    }
    
    @Test(expected = EmptyResultDataAccessException.class)
    public void testDeleteOneDoesNotExist() throws Exception {
        colorRepository.delete(INVALID_ID);
        assertEquals(2, colorRepository.count());
    }
    
    @Test
    public void testUpdate() {
        Color storedEntity = colorRepository.findOne(VALID_ID);
        assertNotNull(storedEntity);
        assertNotNull(storedEntity.getId());
        
        storedEntity.setHex("#000000");
        storedEntity.setName("Black");
        
        Color saved = colorRepository.save(storedEntity);
        assertEquals(storedEntity, saved);
    }
    
    @Test
    public void testInsert() {
        Color entity = ColorGenerator.getValidColor("Yellow", "#FFFF00");
        Color saved = colorRepository.save(entity);
        
        assertNotNull(saved.getId());
        assertEquals(3, colorRepository.count());
    }
    
}