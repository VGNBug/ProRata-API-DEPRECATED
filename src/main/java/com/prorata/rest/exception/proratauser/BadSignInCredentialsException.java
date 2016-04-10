package com.prorata.rest.exception.proratauser;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

/**
 * 401 error response for
 * {@link com.prorata.rest.controller.ProrataUserRestController}
 * 
 * @author Daniel Pawsey
 *		
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "You entered the wrong email or password. Please try again.")
public class BadSignInCredentialsException extends RuntimeException
{
}
