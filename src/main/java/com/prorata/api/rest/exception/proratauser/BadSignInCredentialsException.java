package com.prorata.api.rest.exception.proratauser;
import com.prorata.api.rest.controller.ProrataUserRestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

/**
 * 401 error response for
 * {@link ProrataUserRestController}
 * 
 * @author Daniel Pawsey
 *		
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "You entered the wrong email or password. Please try again.")
public class BadSignInCredentialsException extends RuntimeException
{
}
