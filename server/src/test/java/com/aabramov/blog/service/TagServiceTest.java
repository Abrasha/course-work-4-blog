package com.aabramov.blog.service;

import com.aabramov.blog.BlogApplication;
import com.aabramov.blog.core.model.Tag;
import com.aabramov.blog.generator.TagGenerator;
import com.aabramov.blog.persistence.repository.TagRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BlogApplication.class)
@MockBeans(
        @MockBean(classes = TagRepository.class)
)
public class TagServiceTest {
    
    private static final long VALID_ID = 1L;
    
    @Autowired
    private TagService tagService;
    
    @Autowired
    private TagRepository tagRepository;
    
    @Test
    public void testCount() throws Exception {
        long expectedCount = 3L;
        
        when(tagRepository.count()).thenReturn(expectedCount);
        
        assertEquals(expectedCount, tagService.count());
    }
    
    @Test
    public void testFindAll() throws Exception {
        when(tagRepository.findAll()).thenReturn(
                Arrays.asList(new Tag(), new Tag(), new Tag())
        );
        
        assertEquals(3, tagService.findAll().size());
    }
    
    @Test
    public void testInsert() throws Exception {
        Tag expectedTag = TagGenerator.getValidTag();
        expectedTag.setId(VALID_ID);
        
        when(tagRepository.findOne(VALID_ID)).thenReturn(expectedTag);
        
        Tag found = tagService.find(VALID_ID);
        
        assertNotNull(found);
        assertNotNull(found.getId());
        
        assertEquals(expectedTag, found);
    }
    
    @Test
    public void testUpdate() throws Exception {
        Tag toUpdate = TagGenerator.getValidTag();
        
        when(tagService.save(toUpdate)).thenReturn(toUpdate);
        
        assertEquals(toUpdate, tagService.update(toUpdate));
    }
}