package com.hanchao.graphql.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hanchao.graphql.graphql.entity.Author;
import com.hanchao.graphql.graphql.entity.Book;
import com.hanchao.graphql.graphql.enums.CountryEnum;
import com.hanchao.graphql.graphql.repo.AuthorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


/**
 * @author hanliwei
 * @create 2019-02-12 17:36
 */
@Component
@AllArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepo authorRepo;

    public Author getAuthor(Book book) {
        return authorRepo.findAuthorById(book.getAuthorId());
    }

//    public String getPriceNew(CountryEnum country) {
//        return country.toString();
//    }
}
