package br.edu.unifeso.apiconsultasmed.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.edu.unifeso.apiconsultasmed.exceptions.ItemAlreadyExistsException;
import br.edu.unifeso.apiconsultasmed.exceptions.ItemNotFoundException;

@RestControllerAdvice
public class ExceptionsController {
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException exception) {
		return ResponseEntity.notFound()
				.header("x-erro-msg", exception.getMessage())
				.build();
	}
	
	@ExceptionHandler(ItemAlreadyExistsException.class)
	public ResponseEntity<String> handleItemAlreadyExistsException(ItemAlreadyExistsException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).header("x-erro-msg", exception.getMessage()).build();
	}
}
