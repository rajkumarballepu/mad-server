package com.madcoder.madwatch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madcoder.madwatch.model.Episode;
import com.madcoder.madwatch.model.Show;
import com.madcoder.madwatch.repository.EpisodeRepository;
import com.madcoder.madwatch.repository.ShowRepository;

@RestController
@RequestMapping("/madwatch/api/show")
public class ShowController {
	
	private ShowRepository showRepo;
	@SuppressWarnings("unused")
	private EpisodeRepository epRepo;
	
	@Autowired
	public void setShowRepo(ShowRepository showRepo, EpisodeRepository epRepo) {
		this.showRepo = showRepo;
		this.epRepo = epRepo;
	}
	
	@GetMapping("/")
	public String showHome() {
		return "Welcome shows";
	}
	
	@GetMapping("/all")
	public List<Show> getAllShows() {
		return showRepo.findAll();
	}
	
	@GetMapping("/{showId}")
	public Optional<Show> getShow(@PathVariable Integer showId) {
		return showRepo.findById(showId);
	}
	
	@PostMapping("/")
	public Show postShow(@RequestBody Show show) {
//		showRepo.save(show);
		return show;
	}
	
	@GetMapping("/episode/")
	public String episodeHome() {
		return "Hello episodes";
	}
	
	@PostMapping("/episode/")
	public Episode postEpisode(@RequestBody Episode episode) {
//		episode = epRepo.save(episode);
		return episode;
	}
	

}
