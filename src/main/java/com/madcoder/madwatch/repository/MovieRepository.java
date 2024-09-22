package com.madcoder.madwatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madcoder.madwatch.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	public List<Movie> findAllByOrderByDateOfReleaseDesc();
//	@Query()
	public List<Movie> findByCategoriesContaining(String category);
}
