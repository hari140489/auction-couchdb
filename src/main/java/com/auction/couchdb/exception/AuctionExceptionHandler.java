package com.auction.couchdb.exception;

import com.couchbase.client.java.error.DocumentAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Created by hsupar on 9/16/2016.
 */
@RestControllerAdvice
public class AuctionExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(
		AuctionExceptionHandler.class);

	@ExceptionHandler(AuctionException.class)
	public ResponseEntity<ErrorMessage> handleAuctionException(
		final AuctionException e) {
		LOGGER.debug("Handling AuctionException {}", e.getMessage());
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage("Unable to process the request");
		errorMessage.setTime(LocalDateTime.now());
		return new ResponseEntity<>(errorMessage,
			HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DocumentAlreadyExistsException.class)
	public ResponseEntity<ErrorMessage> handleDocumentAlreadyExistsException(
		final DocumentAlreadyExistsException e) {
		LOGGER.debug("Handling DocumentAlreadyExistsException {}",
			e.getMessage());
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage("Data already exists");
		errorMessage.setTime(LocalDateTime.now());
		return new ResponseEntity<>(errorMessage,
			HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<ErrorMessage> handleAlreadyExistsException(
		final AlreadyExistsException e) {
		LOGGER.debug("Handling AlreadyExistsException {}", e.getMessage());
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage("Data already exists");
		errorMessage.setTime(LocalDateTime.now());
		return new ResponseEntity<>(errorMessage,
			HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DoesNotExistException.class)
	public ResponseEntity<ErrorMessage> handleUserDoesNotExistException(
		final DoesNotExistException e) {
		LOGGER.debug("Handling DoesNotExistException {}", e.getMessage());
		final ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage("Data does not exist");
		errorMessage.setTime(LocalDateTime.now());
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
