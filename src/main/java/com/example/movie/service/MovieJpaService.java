package com.example.movie.service;
import java.util.ArrayList;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class MovieJpaService implements MovieRepository{


    @Autowired
    MovieJpaRepository movieRepository;

	@Override
	public ArrayList<Movie> getMovies() {
		return new ArrayList<>(movieRepository.findAll());
	}

	@Override
	public Movie getMoviebyId(int movieId) {
		try{
			return movieRepository.findById(movieId).get();
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Movie addMovie(Movie movie) {
		movieRepository.save(movie);
		return movie;
	}

	@Override
	public Movie updateMovie(int movieId, Movie movie) {
		Movie existingMovie = getMoviebyId(movieId);
		if(movie.getMovieName() !=null){
			existingMovie.setMovieName(movie.getMovieName());
		}
		if(movie.getLeadActor() != null){
			existingMovie.setLeadActor(movie.getLeadActor());
		}

		
		movieRepository.save(existingMovie);
		return existingMovie;
	}

	@Override
	public void deleteMovie(int movieId) {
		Movie existingMovie = getMoviebyId(movieId);
		movieRepository.deleteById(movieId);

		
	}






}