package com.aabramov.blog.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Entity
@Table(name = "colors")
public class Color extends AbstractEntity {
    
    private String name;
    private String hex;
    
    @Column(name = "color_name", nullable = false)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "hex", nullable = false)
    public String getHex() {
        return hex;
    }
    
    public void setHex(String hex) {
        this.hex = hex;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return Objects.equals(name, color.name) &&
                Objects.equals(hex, color.hex);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, hex);
    }
    
    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                ", hex='" + hex + '\'' +
                "} " + super.toString();
    }
}
