package com.spring.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphql.model.Movie;
import com.spring.graphql.repository.MovieRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllMoviesDataFetcher implements DataFetcher<List<Movie>>{
	
	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> get(DataFetchingEnvironment environment) {
		return movieRepository.findAll();
	}

}
