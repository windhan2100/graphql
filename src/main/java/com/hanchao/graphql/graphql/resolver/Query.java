package com.hanchao.graphql.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hanchao.graphql.graphql.entity.Author;
import com.hanchao.graphql.graphql.entity.Book;
import com.hanchao.graphql.graphql.enums.CountryEnum;
import com.hanchao.graphql.graphql.model.Dog;
import com.hanchao.graphql.graphql.model.Fish;
import com.hanchao.graphql.graphql.model.Animal;
import com.hanchao.graphql.graphql.repo.AuthorRepo;
import com.hanchao.graphql.graphql.repo.BookRepo;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    /**
     * 分页测试
     * @param first
     * @param after
     * @param env
     * @return
     */
    public Connection<Book> books(int first,String after,DataFetchingEnvironment env) {
        return new SimpleListConnection<>(bookRepo.findAll()).get(env);
    }

    /**
     * @descript: 测试一下接口的使用
     * @auther: hanliwei
     * @date: 2019/3/3 18:31
     * @param name
     * @return
     */
    public Animal getAnimal(String name) {
        Dog dog = new Dog();
        dog.setName(name);
        dog.setLegs(4);

        Fish fish = new Fish();
        fish.setName(name);
        fish.setTailColor("BlueAndRead");

        if ("dog".equals(name)) {
            return dog;
        } else if ("fish".equals(name)) {
            return fish;
        }
        return null;
    }

    /**
     * @descript: 返回不同类型的数据
     * @auther: hanliwei
     * @date: 2019/3/3 20:42
     * @return
     */
    public List<Animal> animals() {
        Dog dog = new Dog();
        dog.setName("I am Dog");
        dog.setLegs(4);

        Fish fish = new Fish();
        fish.setName("I am Fish");
        fish.setTailColor("BlueAndRead");

        List<Animal> list = new ArrayList<>();
        list.add(dog);
        list.add(fish);

        return list;
    }
}
