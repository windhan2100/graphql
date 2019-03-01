package com.hanchao.graphql.graphql.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Book extends BaseEntity {
    @Column(columnDefinition = "varchar(50)")
    private String title;

    private String isbn;

    private int pageCount;

    private long authorId;

    private Double price;
}
