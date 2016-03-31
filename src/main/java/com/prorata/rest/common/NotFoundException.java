package com.prorata.rest.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found")  // 404
public class NotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4591580715847707730L;

}