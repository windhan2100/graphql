package com.hanchao.graphql.graphql.repo;


import com.hanchao.graphql.graphql.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author hanliwei
 * @create 2019-02-12 17:29
 */
public interface AuthorRepo extends JpaRepository<Author,Long> {

    Author findAuthorById(Long id);
}
