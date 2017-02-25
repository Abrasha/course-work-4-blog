package com.aabramov.blog.web.dto;

import java.util.Objects;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public class ColorDto extends AbstractDto {
    
    private String name;
    private String hex;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
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
        ColorDto colorDto = (ColorDto) o;
        return Objects.equals(name, colorDto.name) &&
                Objects.equals(hex, colorDto.hex);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, hex);
    }
    
    @Override
    public String toString() {
        return "ColorDto{" +
                "name='" + name + '\'' +
                ", hex='" + hex + '\'' +
                "} " + super.toString();
    }
}
