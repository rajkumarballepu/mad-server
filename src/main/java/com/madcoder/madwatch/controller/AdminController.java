package com.madcoder.madwatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madcoder.madwatch.model.Movie;
import com.madcoder.madwatch.repository.MovieRepository;
import com.madcoder.madwatch.util.Utilities;

@RestController
@CrossOrigin
@RequestMapping("/madwatch/api/auth/movie")
public class AdminController {
	
	private MovieRepository movieRepo;
	private Utilities utilities;
	
	@Autowired
	private void setMovieRepo(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}
	
	@Autowired
	private void setUtilities(Utilities utilities) {
		this.utilities = utilities;
	}
	
	@PostMapping("/post")
	public Movie postMovie(@RequestBody Movie movie) {
		System.out.println(movie);
		movie.setSlug(utilities.slugGenerator(movie.getName()));
		movieRepo.save(movie);
		return movie;
	}
	
	@GetMapping("/all")
	public List<Movie> getAllMovies() {
		List<Movie> list = movieRepo.findAllByOrderByDateOfReleaseDesc();
		return list;
	}
}
