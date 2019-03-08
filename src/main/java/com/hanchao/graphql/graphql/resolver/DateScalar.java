package com.hanchao.graphql.graphql.resolver;

import graphql.language.IntValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自定义标量类型-测试
 *
 * @author hanliwei
 * @create 2019-03-08 22:34
 */
@Component
public class DateScalar extends GraphQLScalarType {
    public DateScalar() {
        super("Date", "Built-in Date as timestamp", new Coercing() {
            @Override
            public Long serialize(Object input) {
                if (input instanceof java.util.Date) {
                    return ((java.util.Date) input).getTime();
                }
                return null;
            }

            @Override
            public java.util.Date parseValue(Object input) {
                if (input instanceof Long) {
                    return new java.util.Date((Long) input);
                }
                return null;
            }

            @Override
            public java.util.Date parseLiteral(Object input) {
                if (input instanceof IntValue) {
                    return new Date(((IntValue) input).getValue().longValue());
                }
                return null;
            }
        });
    }
}
