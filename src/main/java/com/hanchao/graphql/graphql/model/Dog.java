package com.hanchao.graphql.graphql.model;

import lombok.Data;

/**
 * 为演示GraphQL interface创建的实现实体
 *
 * @author hanliwei
 * @create 2019-02-20 17:27
 */
@Data
public class Dog implements Animal {

    private String name;
    private int legs;
}
