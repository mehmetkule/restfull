package com.mk.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DublicateUserException extends Exception {
	public DublicateUserException() {
	}

	public DublicateUserException(String message) {
		super(message);
	}

	public DublicateUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public DublicateUserException(Throwable cause) {
		super(cause);
	}

	public DublicateUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
