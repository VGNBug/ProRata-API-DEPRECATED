package com.prorata.api.rest.controller.exception;

import com.prorata.api.rest.exception.proratauser.BadSignInCredentialsException;
import com.prorata.api.rest.exception.proratauser.ProrataUserNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@ControllerAdvice
public class ProrataUserExceptionController {

    @ExceptionHandler(ProrataUserNotFoundException.class)
    public ResponseEntity handleProrataUserNotFoundException(ProrataUserNotFoundException e) {
        // log exception
        return ResponseEntity
			.status(HttpStatus.NOT_FOUND)
			.body(e.getMessage());
    }

	@ExceptionHandler(BadSignInCredentialsException.class)
    public ResponseEntity handleBadSignInCredentialsException(BadSignInCredentialsException e) {
        // log exception
        return ResponseEntity
			.status(HttpStatus.NOT_FOUND)
			.body(e.getMessage());
    }
}
