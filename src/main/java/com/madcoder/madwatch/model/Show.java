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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "shows")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Show {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "categories")
	private String categories;
	
	@Column(name = "seasons", columnDefinition = "Integer(100) default '1'")
	private Integer seasons;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "show_id", referencedColumnName = "id")
	private List<Episode> episodes;
	

}
