package com.hanchao.graphql.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * ErrorContainer.java
 *
 * @author hanliwei
 * @create 2019-03-02 11:15
 */
@Data
@AllArgsConstructor
public class ErrorContainer implements CreateUserResult {
    private List<String> messages;
}
