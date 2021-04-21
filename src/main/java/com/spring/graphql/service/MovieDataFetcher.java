package com.spring.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphql.model.Movie;
import com.spring.graphql.repository.MovieRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class MovieDataFetcher implements DataFetcher<Movie>{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public Movie get(DataFetchingEnvironment environment) {
		return movieRepository.findById(environment.getArgument("id")).get();
	}

}
