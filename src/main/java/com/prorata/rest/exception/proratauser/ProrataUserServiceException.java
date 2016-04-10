package com.prorata.rest.exception.proratauser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 500 error response for
 * {@link com.prorata.rest.controller.ProrataUserRestController}
 * 
 * @author Daniel Pawsey
 *		
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Something went wrong on our server. Please try again later.")
public class ProrataUserServiceException extends RuntimeException
{
	private static final long serialVersionUID = 3714881395790098730L;
}
