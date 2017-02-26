package com.aabramov.blog.generator;

import com.aabramov.blog.core.model.Color;
import com.aabramov.blog.core.model.Tag;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    
    public static List<Tag> getValidTags(int count) {
        return IntStream.range(0, count)
                .mapToObj(e -> getValidTag("test-tag", ColorGenerator.getValidColor()))
                .collect(Collectors.toList());
    }
    
}
