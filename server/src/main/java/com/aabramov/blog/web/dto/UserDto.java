package com.aabramov.blog.web.dto;

import com.aabramov.blog.core.model.AbstractEntity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public class UserDto extends AbstractEntity {
    
    private List<PostDto> posts;
    private Set<TagDto> favouriteTags;
    private String username;
    
    public List<PostDto> getPosts() {
        return posts;
    }
    
    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }
    
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto user = (UserDto) o;
        return Objects.equals(username, user.username);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}