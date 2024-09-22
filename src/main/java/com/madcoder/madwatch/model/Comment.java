package com.madcoder.madwatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@Table(name = "Comment")
@ToString
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "time_stamp")
	private String timeStamp;
	
	@Column(name = "movie_id")
	private Integer movieId;
	
	@Column(name = "show_id")
	private Integer showId;
	
	@Column(name = "episode_id")
	private Integer episodeId;
	
}
