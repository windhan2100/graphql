package com.hanchao.graphql.graphql.utils;

import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;

import java.util.Optional;

/**
 * @author hanliwei
 * @create 2019-03-02 16:13
 */
public class Utils {
    public static Optional<String> getHeader(String header, DataFetchingEnvironment env) {
        GraphQLContext graphQLContext = env.getContext();
        return graphQLContext.getHttpServletRequest()
                .flatMap(req -> Optional.ofNullable(req.getHeader(header)));
    }

    public static Optional<String> getAuthToken(DataFetchingEnvironment env) {
        Optional<String> auth = getHeader("Authorization", env);
        return auth.map(str -> str.replace("Bearer ", ""));
    }
}
