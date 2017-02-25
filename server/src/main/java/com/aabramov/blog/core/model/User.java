package com.aabramov.blog.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Entity
@Table(name = "names")
public class User extends AbstractEntity {
    
    private List<Post> posts;
    private String username;
    private String password;
    
    @OneToMany(mappedBy = "author")
    public List<Post> getPosts() {
        return posts;
    }
    
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    @Column
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
