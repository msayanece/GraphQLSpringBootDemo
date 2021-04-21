package com.spring.graphql.model;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.graphql.jpautil.StringListConverter;

@Table(name = "movie")
@Entity
public class Movie {

	@Id
	private String id;
	private String title;
	@Convert(converter = StringListConverter.class)
	private List<String> directors;
	@Convert(converter = StringListConverter.class)
	private List<String> producers;
	private String releaseDate;
	
	public Movie() {
		super();
	}
	public Movie(String id, String title, List<String> directors, List<String> producers, String releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.directors = directors;
		this.producers = producers;
		this.releaseDate = releaseDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getDirectors() {
		return directors;
	}
	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}
	public List<String> getProducers() {
		return producers;
	}
	public void setProducers(List<String> producers) {
		this.producers = producers;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", directors=" + directors + ", producers=" + producers
				+ ", releaseDate=" + releaseDate + "]";
	}
	
}
