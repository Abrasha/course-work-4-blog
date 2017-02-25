package com.aabramov.blog.web.dto;

import com.aabramov.blog.core.model.AbstractEntity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public class CommentDto extends AbstractEntity {
    
    private PostDto post;
    private UserDto author;
    private String body;
    private LocalDateTime creationDate;
    
    public PostDto getPost() {
        return post;
    }
    
    public void setPost(PostDto post) {
        this.post = post;
    }
    
    public UserDto getAuthor() {
        return author;
    }
    
    public void setAuthor(UserDto author) {
        this.author = author;
    }
    
    public String getBody() {
        return body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    
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
        CommentDto comment = (CommentDto) o;
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
