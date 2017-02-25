package com.aabramov.blog.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Entity
@Table(name = "comments")
public class Comment extends AbstractEntity {
    
    private Post post;
    private User author;
    private String body;
    private LocalDateTime creationDate;
    
    @ManyToOne(targetEntity = Post.class)
    public Post getPost() {
        return post;
    }
    
    public void setPost(Post post) {
        this.post = post;
    }
    
    @ManyToOne(targetEntity = User.class)
    public User getAuthor() {
        return author;
    }
    
    public void setAuthor(User author) {
        this.author = author;
    }
    
    @Column(nullable = false)
    public String getBody() {
        return body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    
    @Column(nullable = false)
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
        Comment comment = (Comment) o;
        return Objects.equals(post, comment.post) &&
                Objects.equals(author, comment.author) &&
                Objects.equals(body, comment.body) &&
                Objects.equals(creationDate, comment.creationDate);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(post, author, body, creationDate);
    }
    
    @Override
    public String toString() {
        return "Comment{" +
                "post=" + post +
                ", author=" + author +
                ", body='" + body + '\'' +
                ", creationDate=" + creationDate +
                "} " + super.toString();
    }
}
