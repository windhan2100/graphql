package com.hanchao.graphql.graphql.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hanliwei
 * @create 2019-03-02 11:03
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint", nullable = false)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
