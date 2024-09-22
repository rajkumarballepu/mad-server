package com.madcoder.madwatch.exception;

public class MovieNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MovieNotFound() {
		super("Movie not found with id");
	}

}
