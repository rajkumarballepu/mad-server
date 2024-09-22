package com.madcoder.madwatch.util;

import org.springframework.stereotype.Component;

@Component
public class Utilities {
	public String slugGenerator(String movieName) {
		movieName = movieName.trim().toLowerCase();
		return movieName.replaceAll(" ", "-");
	}
}
