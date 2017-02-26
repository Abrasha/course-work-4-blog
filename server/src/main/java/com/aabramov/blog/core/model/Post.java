package com.aabramov.blog.core.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Entity
@Table(name = "posts")
public class Post extends AbstractEntity {
    
    private String title;
    private String body;
    private LocalDateTime creationDate;
    
    private Set<Tag> tags;
    private User author;
    
    @Column
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column
    public String getBody() {
        return body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    
    @ManyToOne(targetEntity = User.class)
    public User getAuthor() {
        return author;
    }
    
    public void setAuthor(User author) {
        this.author = author;
    }
    
    @Column
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    
    @ManyToMany(targetEntity = Tag.class)
    public Set<Tag> getTags() {
        return tags;
    }
    
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(body, post.body) &&
                Objects.equals(creationDate, post.creationDate);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(title, body, creationDate);
    }
    
    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author=" + author +
                ", creationDate=" + creationDate +
                "} " + super.toString();
    }
}
