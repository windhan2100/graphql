package com.hanchao.graphql.graphql;

import com.coxautodev.graphql.tools.SchemaParserDictionary;
import com.hanchao.graphql.graphql.model.CreatedUser;
import com.hanchao.graphql.graphql.model.ErrorContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	SchemaParserDictionary schemaParserDictionary() {
	    return new SchemaParserDictionary()
                .add(CreatedUser.class)
                .add(ErrorContainer.class);
    }

}
