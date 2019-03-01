package com.hanchao.graphql.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hanchao.graphql.graphql.entity.Author;
import com.hanchao.graphql.graphql.entity.Book;
import com.hanchao.graphql.graphql.enums.CountryEnum;
import com.hanchao.graphql.graphql.model.BookInput;
import com.hanchao.graphql.graphql.repo.AuthorRepo;
import com.hanchao.graphql.graphql.repo.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author hanliwei
 * @create 2019-02-12 18:58
 */
@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    private AuthorRepo authorRepo;
    private BookRepo bookRepo;

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return authorRepo.save(author);
    }

    public Book newBook(String title, String isbn, int pageCount, Long authorId) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount);
        book.setAuthorId(authorId);
        return bookRepo.save(book);
    }


    public Book saveBook(BookInput input) {
        Book book = new Book();
        book.setTitle(input.getTitle());
        book.setIsbn(input.getIsbn());
        book.setPageCount(input.getPageCount());
        book.setAuthorId(input.getAuthorId());
        return bookRepo.save(book);
    }

    public Boolean deleteBook(Long id) {
        bookRepo.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(int pageCount,long id) {
        Book book = bookRepo.findBookById(id);
        book.setPageCount(pageCount);
        return bookRepo.save(book);
    }


}
