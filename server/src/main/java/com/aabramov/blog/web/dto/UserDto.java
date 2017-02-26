package com.aabramov.blog.web.dto;

import java.util.Objects;
import java.util.Set;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public class UserDto extends AbstractDto {
    
    private Set<TagDto> favouriteTags;
    private String username;
    private String email;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public Set<TagDto> getFavouriteTags() {
        return favouriteTags;
    }
    
    public void setFavouriteTags(Set<TagDto> favouriteTags) {
        this.favouriteTags = favouriteTags;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto user = (UserDto) o;
        return Objects.equals(username, user.username)
                && Objects.equals(email, user.email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(username, email);
    }
}
