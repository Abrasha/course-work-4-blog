package com.aabramov.blog;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BlogApplication.class)
@WebAppConfiguration
public class BlogApplicationTest {
    
    @Autowired
    private BlogApplication blogApplication;
    
    @Test
    public void testGetName() {
        Assert.assertEquals("Andrii", blogApplication.name());
    }
    
}
