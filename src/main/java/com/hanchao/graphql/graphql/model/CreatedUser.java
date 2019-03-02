package com.hanchao.graphql.graphql.model;

import com.hanchao.graphql.graphql.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CreatedUser.java
 *
 * @author hanliwei
 * @create 2019-03-02 11:14
 */
@Data
@AllArgsConstructor
public class CreatedUser implements CreateUserResult {
    private User user;
}
