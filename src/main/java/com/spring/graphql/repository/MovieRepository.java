package com.spring.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.graphql.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {
}