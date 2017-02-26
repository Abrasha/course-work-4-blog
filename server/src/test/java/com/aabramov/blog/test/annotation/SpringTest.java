package com.aabramov.blog.test.annotation;

import com.aabramov.blog.BlogApplication;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Andrii Abramov on 2/26/17.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = BlogApplication.class)
public @interface SpringTest {
    
}
