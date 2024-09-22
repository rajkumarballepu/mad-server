package com.madcoder.madwatch.model;

import jakarta.persistence.Column;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "movie")
public class Movie {

	public Movie(String name, String dateOfRelaese, double i, String description, String avatar,
			String categories) {
		super();
		this.name = name;
		this.dateOfRelease = dateOfRelaese;
		this.rating = i;
		this.description = description;
		this.avatar = avatar;
		this.categories= categories;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "date_of_release")
	private String dateOfRelease;
	
	@Column(name = "rating")
	private Double rating;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "avatar" )
	private String avatar;
	
	@Column(name = "categories")
	private String categories;
	
	@Column(name = "slug")
	private String slug;
	
	@Column(name = "download_link")
	private String downloadLink;
	
	@Column(name = "frame_link")
	private String frameLink;
	
	@Column(name = "languages")
	private String languages;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "movie_id", referencedColumnName = "id")
	@OrderBy("time_stamp DESC")
	private List<Comment> comments;
	
	
	
}
