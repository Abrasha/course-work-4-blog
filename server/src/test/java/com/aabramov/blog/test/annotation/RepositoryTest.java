package com.aabramov.blog.test.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Andrii Abramov on 2/26/17.
 */
@Sql
@Rollback
@SpringTest
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepositoryTest {
    
    @AliasFor(annotation = Sql.class, attribute = "value")
    String[] value() default {};
    
    @AliasFor(annotation = Sql.class, attribute = "scripts")
    String[] scripts() default {};
    
}
