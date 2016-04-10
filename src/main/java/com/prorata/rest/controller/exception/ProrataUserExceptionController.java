package com.prorata.rest.controller.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.prorata.rest.exception.proratauser.*;

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
