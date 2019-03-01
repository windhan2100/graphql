package com.hanchao.graphql.graphql.repo;

import com.hanchao.graphql.graphql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author hanliwei
 * @create 2019-02-12 17:31
 */
public interface BookRepo extends JpaRepository<Book,Long> {
    List<Book> findByAuthorId(Long id);

    Book findBookById(Long id);
}
