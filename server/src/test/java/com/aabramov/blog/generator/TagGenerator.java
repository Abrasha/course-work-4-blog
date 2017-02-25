package com.aabramov.blog.generator;

import com.aabramov.blog.core.model.Color;
import com.aabramov.blog.core.model.Tag;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public class TagGenerator {
    
    public static Tag getValidTag(String name, Color color) {
        Tag tag = new Tag();
        tag.setName(name);
        tag.setColor(color);
        
        return tag;
    }
    
    public static Tag getValidTag() {
        return getValidTag("test-tag", ColorGenerator.getValidColor());
    }
    
}
