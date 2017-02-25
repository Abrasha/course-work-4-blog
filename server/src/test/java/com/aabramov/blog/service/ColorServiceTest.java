package com.aabramov.blog.service;

import com.aabramov.blog.BlogApplication;
import com.aabramov.blog.core.model.Color;
import com.aabramov.blog.generator.ColorGenerator;
import com.aabramov.blog.persistence.repository.ColorRepository;
import com.aabramov.blog.service.impl.ColorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BlogApplication.class)
@MockBeans(
        @MockBean(classes = ColorRepository.class)
)
public class ColorServiceTest {
    
    private static final Long VALID_ID = 1L;
    
    @Autowired
    private ColorRepository colorRepository;
    
    @Autowired
    private ColorService colorService;
    
    @Test
    public void testFindOne() throws Exception {
        Color expected = ColorGenerator.getValidColorWithId(VALID_ID);
        
        when(colorRepository.findOne(VALID_ID)).thenReturn(expected);
        
        Color actual = colorService.find(VALID_ID);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindAll() throws Exception {
        when(colorRepository.findAll()).thenReturn(
                Arrays.asList(new Color(), new Color(), new Color())
        );
        
        List<Color> result = colorService.findAll();
        
        assertNotNull(result);
        assertEquals(3, result.size());
    }
    
    @Test
    public void testCount() throws Exception {
        when(colorRepository.count()).thenReturn(3L);
        
        assertEquals(3, colorService.count());
    }
    
    @Test
    public void testUpdate() throws Exception {
        Color toUpdate = ColorGenerator.getValidColor();
        
        when(colorRepository.save(toUpdate)).thenReturn(toUpdate);
        
        assertEquals(toUpdate, colorService.update(toUpdate));
    }
}