package com.prorata.api.rest.exception.proratauser;

import com.prorata.api.model.ProrataUserEntity;
import com.prorata.api.rest.controller.ProrataUserRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 404 error response for
 * {@link ProrataUserRestController#read(java.util.Map)}
 * , explaining that the requested
 * {@link ProrataUserEntity ProrataUserEntity} could not
 * be found.
 * 
 * @author Daniel Pawsey
 *		
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "A user with that email and / or password cannot be found.")
public class ProrataUserNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 8783204384768830129L;
}