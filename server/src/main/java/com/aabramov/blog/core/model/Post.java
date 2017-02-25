package com.aabramov.blog.core.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Entity
@Table(name = "posts")
public class Post extends AbstractEntity {
    
    private String title;
    private String body;
    //    Set<Tag> tags;
    private List<Comment> comments;
    
    private User author;
    
    private LocalDateTime creationDate;
    
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
    
    @OneToMany(mappedBy = "post")
    public List<Comment> getComments() {
        return comments;
    }
    
    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
                ", comments=" + comments +
                ", author=" + author +
                ", creationDate=" + creationDate +
                "} " + super.toString();
    }
}
