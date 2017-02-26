package com.aabramov.blog.web.dto;

import com.aabramov.blog.core.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public class PostDto extends AbstractDto {
    
    private String title;
    private String body;
    private Set<TagDto> tags;
    
    private User author;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationDate;
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getBody() {
        return body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    
    public User getAuthor() {
        return author;
    }
    
    public void setAuthor(User author) {
        this.author = author;
    }
    
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    
    public Set<TagDto> getTags() {
        return tags;
    }
    
    public void setTags(Set<TagDto> tags) {
        this.tags = tags;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDto post = (PostDto) o;
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
