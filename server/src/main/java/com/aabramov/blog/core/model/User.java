package com.aabramov.blog.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    
    private Set<Tag> favouriteTags;
    private String username;
    private String email;
    private String password;
    
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
    
    @ManyToMany(targetEntity = Tag.class)
    public Set<Tag> getFavouriteTags() {
        return favouriteTags;
    }
    
    public void setFavouriteTags(Set<Tag> favouriteTags) {
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
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(email, user.email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(username, email);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "favouriteTags=" + favouriteTags +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
}
