package com.aabramov.blog.web.controller.rest;

import com.aabramov.blog.BlogApplication;
import com.aabramov.blog.core.model.Color;
import com.aabramov.blog.core.model.Tag;
import com.aabramov.blog.generator.TagGenerator;
import com.aabramov.blog.service.TagService;
import com.aabramov.blog.web.dto.TagDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BlogApplication.class)
@MockBeans(
        @MockBean(classes = TagService.class)
)
public class TagRestControllerTest {
    
    private static final Long VALID_ID = 1L;
    
    @Autowired
    private TagService tagService;
    
    @Autowired
    private TagRestController tagRestController;
    
    @Test
    public void getAll() throws Exception {
        long expectedCount = 3L;
        when(tagService.count()).thenReturn(expectedCount);
        
        assertEquals(expectedCount, tagRestController.count());
    }
    
    @Test
    public void getOne() throws Exception {
        Tag expected = TagGenerator.getValidTag();
        
        when(tagService.find(VALID_ID)).thenReturn(expected);
        
        assertEquals(tagRestController.convertToDto(expected), tagRestController.getOne(VALID_ID));
    }
    
    @Test
    public void update() throws Exception {
        Tag tag = TagGenerator.getValidTag();
        tag.setId(VALID_ID);
        
        TagDto expected = tagRestController.convertToDto(tag);
        
        when(tagService.update(tag)).thenReturn(tag);
        
        assertEquals(expected, tagRestController.update(VALID_ID, expected));
    }
    
    @Test
    public void save() throws Exception {
        Tag tag = TagGenerator.getValidTag();
        tag.setId(VALID_ID);
        
        TagDto expected = tagRestController.convertToDto(tag);
        
        when(tagService.save(tag)).thenReturn(tag);
        
        assertEquals(expected, tagRestController.save(expected));
    }
    
}