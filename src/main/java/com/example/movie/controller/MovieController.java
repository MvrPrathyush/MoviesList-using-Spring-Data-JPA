package com.example.movie.controller;

import java.util.ArrayList;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController{
    @Autowired
    MovieJpaService movieService;

	@GetMapping("/movies")
	public ArrayList<Movie> getMovies() {
		return movieService.getMovies();
	}

	@GetMapping("/movies/{movieId}")
	public Movie getMoviebyId(@PathVariable("movieId")int movieId) {
		return movieService.getMoviebyId(movieId);
	}

	@PostMapping("/movies")
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}

	@PutMapping("/movies/{movieId}")
	public Movie updateMovie(@PathVariable("movieId")int movieId, @RequestBody Movie movie) {
		return movieService.updateMovie(movieId, movie);
	}

	@DeleteMapping("/movies/{movieId}")
	public void deleteMovie(@PathVariable("movieId")int movieId) {
		movieService.deleteMovie(movieId);
		
	}
 
    
}