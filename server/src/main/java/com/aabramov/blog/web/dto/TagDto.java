package com.aabramov.blog.web.dto;

import java.util.Objects;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public class TagDto extends AbstractDto {
    
    private String name;
    private ColorDto color;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ColorDto getColor() {
        return color;
    }
    
    public void setColor(ColorDto color) {
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
