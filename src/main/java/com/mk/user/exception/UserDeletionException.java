package com.mk.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserDeletionException extends Exception{
	public UserDeletionException() {
	}

	public UserDeletionException(String message) {
		super(message);
	}

	public UserDeletionException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDeletionException(Throwable cause) {
		super(cause);
	}

	public UserDeletionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
