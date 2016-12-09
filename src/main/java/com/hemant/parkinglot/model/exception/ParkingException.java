package com.hemant.parkinglot.model.exception;

public class ParkingException extends RuntimeException {

	private static final long serialVersionUID = -6009459986479821048L;

	public ParkingException() {
		super();
	}

	public ParkingException(String s) {
		super(s);
	}

	public ParkingException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParkingException(Throwable cause) {
		super(cause);
	}
}
