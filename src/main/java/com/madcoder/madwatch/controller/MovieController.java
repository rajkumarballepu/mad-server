package com.madcoder.madwatch.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madcoder.madwatch.model.Movie;
import com.madcoder.madwatch.repository.MovieRepository;
import com.madcoder.madwatch.util.Utilities;

@RestController
@CrossOrigin
@RequestMapping("/madwatch/api/movie")
public class MovieController {
	
	MovieRepository movieRepository;
	private Utilities utilities;
	
	@Autowired
	public void setMovieRepository(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}	
	
	@Autowired
	public void setUtilities(Utilities utilities) {
		this.utilities = utilities;
	}
	
	@GetMapping("/") 
	public String home() {
		System.out.println(movieRepository.findByCategoriesContaining("Romance"));
		return "Welcome to home";
	}
	
	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable int movieId) {
		Optional<Movie> movie = movieRepository.findById(movieId);
		System.out.println(movie.get());
		return movie.get();
	}
	
	@GetMapping("/all")
	public List<Movie> getAllMovies() {
		List<Movie> all = movieRepository.findAllByOrderByDateOfReleaseDesc();
		List<Movie> movies = new ArrayList<Movie>();
		for (Movie movie : all) {
//			movie.setComments(null);			
			movies.add(movie);
		}
		
		return all;
	}
	
	@GetMapping("/category/{category}")
	public List<Movie> getCategoryMovies(@PathVariable String category) {
		List<Movie> byCategoriesContaining = movieRepository.findByCategoriesContaining(category);
		return byCategoriesContaining;
	}
	
	@PostMapping("/")
	public Movie postMovie(@RequestBody Movie movie) {
		System.out.println(movie);
		System.out.println(utilities.slugGenerator(movie.getName()));
		movie.setSlug(utilities.slugGenerator(movie.getName()));
//		movieRepository.save(movie);
		return movie;
	}
	
}
