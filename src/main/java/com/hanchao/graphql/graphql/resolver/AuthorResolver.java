package com.hanchao.graphql.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hanchao.graphql.graphql.entity.Author;
import com.hanchao.graphql.graphql.entity.Book;
import com.hanchao.graphql.graphql.repo.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author hanliwei
 * @create 2019-02-12 17:33
 */
@Component
@AllArgsConstructor
public class AuthorResolver implements GraphQLResolver<Author> {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private BookRepo bookRepo;

    public String getCreatedTime(Author author) {
        return sdf.format(author.getCreatedTime());
    }

    public List<Book> getBooks(Author author) {
        return bookRepo.findByAuthorId(author.getId());
    }
}
