package com.spring.graphql.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {

    @Value("classpath:movies.graphql")
    Resource resource;

    private GraphQL graphQL;
    
    @Autowired
    private AllMoviesDataFetcher allMoviesDataFetcher;
    
    @Autowired
    private MovieDataFetcher movieDataFetcher;
	
    // This method will be called at application start up, after all the Spring Beans have been constructed
    @PostConstruct
    private void loadSchema() throws IOException {
        // get the schema
        File schemaFile = resource.getFile();
        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        //get wiring
        RuntimeWiring wiring = buildRuntimeWiring();
        //make executable GraphQLSchema
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        //initialize graphQL
        graphQL = GraphQL.newGraphQL(schema).build();
    }
    
    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allMovies", allMoviesDataFetcher)
                        .dataFetcher("movie", movieDataFetcher))
                .build();
    }
    
	public GraphQL getGraphQL() {
		return graphQL;
	}

}
