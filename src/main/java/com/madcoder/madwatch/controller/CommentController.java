package com.madcoder.madwatch.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madcoder.madwatch.model.Comment;
import com.madcoder.madwatch.repository.CommentRepository;

@RestController
@CrossOrigin
@RequestMapping("/madwatch/api/comment")
public class CommentController {
	
	private CommentRepository commentRepository;
	
	@Autowired
	private void setCommentRepo(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	@GetMapping("/")
	public String home() {
		return "Comments home";
	}
	
	@GetMapping("/{movieId}")
	public List<Comment> getComments(@PathVariable int movieId) {
		List<Comment> comments = commentRepository.findByMovieIdOrderByTimeStampDesc(movieId);
		return comments;
	}
	
	@PostMapping("/")
	public Comment postComment(@RequestBody Comment comment) {
		System.out.println(comment);
		String pattern = "YYYY-MM-d HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		comment.setTimeStamp(date);
		commentRepository.save(comment);
		return comment;
	}
	
	@PostMapping("/episode/")
	public Comment postEpisodeComment(@RequestBody Comment comment) {
		System.out.println(comment);
		String pattern = "YYYY-MM-d HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		comment.setTimeStamp(date);
		comment = commentRepository.save(comment);
		return comment;
	}
	
	
}
