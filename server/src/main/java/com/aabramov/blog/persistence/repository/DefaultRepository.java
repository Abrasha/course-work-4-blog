package com.aabramov.blog.persistence.repository;

import com.aabramov.blog.core.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public interface DefaultRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {
}
