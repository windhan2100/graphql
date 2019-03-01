package com.hanchao.graphql.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hanchao.graphql.graphql.entity.Author;
import com.hanchao.graphql.graphql.entity.Book;
import com.hanchao.graphql.graphql.enums.CountryEnum;
import com.hanchao.graphql.graphql.repo.AuthorRepo;
import com.hanchao.graphql.graphql.repo.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hanliwei
 * @create 2019-02-12 18:00
 */
@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private AuthorRepo authorRepo;

    private BookRepo bookRepo;

    public Author findAuthorById(Long id) {
        return authorRepo.findAuthorById(id);
    }

    public List<Author> findAllAuthors() {
        return authorRepo.findAll();
    }

    public Long countAuthors() {
        return authorRepo.count();
    }

    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    public Long countBooks() {
        return bookRepo.count();
    }

    public Book findBookById(Long id) {
        return bookRepo.findBookById(id);
    }


    public String testEnum(CountryEnum country) {
        return country.toString();
    }
}
