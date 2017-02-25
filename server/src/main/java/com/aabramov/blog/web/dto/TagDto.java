package com.aabramov.blog.web.dto;

import com.aabramov.blog.core.model.Color;

import java.util.Objects;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public class TagDto extends AbstractDto {
    
    private String name;
    private Color color;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagDto tag = (TagDto) o;
        return Objects.equals(name, tag.name) &&
                Objects.equals(color, tag.color);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }
    
    @Override
    public String toString() {
        return "TagDto{" +
                "name='" + name + '\'' +
                ", color=" + color +
                "} " + super.toString();
    }
    
}
