package com.madcoder.madwatch.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "episodes")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Episode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "episode_no")
	private int episodeNo;
	
	@Column(name = "episode_link")
	private String episodeLink;
	
	@Column(name = "show_id")
	private int showId;
	
	@Column(name = "season_no")
	private Integer seasonNo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "episode_id", referencedColumnName = "id")
	@JoinColumn(name = "show_id", referencedColumnName = "show_id")
	@OrderBy("time_stamp DESC")
	private List<Comment> comments;
}
