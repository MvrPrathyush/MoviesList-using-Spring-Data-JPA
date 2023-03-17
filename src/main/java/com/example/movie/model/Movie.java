package com.example.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movielist")

public class Movie{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieid")
    int movieId;

    @Column(name = "moviename")
    String movieName;
    @Column(name = "leadactor")
    String leadActor;

	public Movie(){};

    public Movie(int movieId,String movieName,String leadActor){
        this.movieId = movieId;
        this.movieName = movieName;
        this.leadActor = leadActor;
    }

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

        




}