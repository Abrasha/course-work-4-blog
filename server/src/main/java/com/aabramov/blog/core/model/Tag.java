package com.aabramov.blog.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Entity
@Table(name = "tags")
public class Tag extends AbstractEntity {
    
    private String name;
    private Color color;
    
    @Column
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @ManyToOne(targetEntity = Color.class)
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
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name) &&
                Objects.equals(color, tag.color);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }
    
    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", color=" + color +
                "} " + super.toString();
    }
}
