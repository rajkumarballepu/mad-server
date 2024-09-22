package com.madcoder.madwatch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.madcoder.madwatch.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	public List<Comment> findByMovieIdOrderByTimeStampDesc(int movieId);
}
