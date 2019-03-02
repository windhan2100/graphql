package com.hanchao.graphql.graphql.model;

import com.hanchao.graphql.graphql.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hanliwei
 * @create 2019-03-02 16:00
 */
@Data
@AllArgsConstructor
public class LoginPayload implements LoginResult{
    private Long token;
    private User user;
}
