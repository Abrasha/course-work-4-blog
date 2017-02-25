package com.aabramov.blog.persistence.repository.generator;

import com.aabramov.blog.core.model.Color;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public class ColorGenerator {
    
    public static Color getValidColor(String name, String hex) {
        Color color = new Color();
        color.setName(name);
        color.setHex(hex);
        return color;
    }
    
    public static Color getValidColor() {
        return getValidColor("Red", "#FF0000");
    }
    
}
