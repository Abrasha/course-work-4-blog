package com.aabramov.blog.web.controller.rest;

import com.aabramov.blog.BlogApplication;
import com.aabramov.blog.core.model.Color;
import com.aabramov.blog.generator.ColorGenerator;
import com.aabramov.blog.service.ColorService;
import com.aabramov.blog.service.TagService;
import com.aabramov.blog.service.impl.ColorServiceImpl;
import com.aabramov.blog.web.dto.ColorDto;
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
        @MockBean(classes = ColorService.class)
)
public class ColorRestControllerTest {
    
    private static final Long VALID_ID = 1L;
    
    @Autowired
    private ColorService colorService;
    
    @Autowired
    private ColorRestController colorRestController;
    
    @Test
    public void getAll() throws Exception {
        long expectedCount = 3L;
        when(colorService.count()).thenReturn(expectedCount);
        
        assertEquals(expectedCount, colorRestController.count());
    }
    
    @Test
    public void getOne() throws Exception {
        Color expected = ColorGenerator.getValidColor();
        
        when(colorService.find(VALID_ID)).thenReturn(expected);
        
        assertEquals(colorRestController.convertToDto(expected), colorRestController.getOne(VALID_ID));
    }
    
    @Test
    public void update() throws Exception {
        Color color = ColorGenerator.getValidColor();
        color.setId(VALID_ID);
        
        ColorDto expected = colorRestController.convertToDto(color);
        
        when(colorService.update(color)).thenReturn(color);
        
        assertEquals(expected, colorRestController.update(VALID_ID, expected));
    }
    
    @Test
    public void save() throws Exception {
        Color color = ColorGenerator.getValidColor();
        color.setId(VALID_ID);
        
        ColorDto expected = colorRestController.convertToDto(color);
        
        when(colorService.save(color)).thenReturn(color);
        
        assertEquals(expected, colorRestController.save(expected));
    }
    
}