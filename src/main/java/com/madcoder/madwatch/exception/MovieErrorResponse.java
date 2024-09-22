package com.madcoder.madwatch.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieErrorResponse {
	private int status;
	private String message;
	private long timestands;
}
