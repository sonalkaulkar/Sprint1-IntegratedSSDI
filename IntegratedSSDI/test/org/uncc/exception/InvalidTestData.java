package org.uncc.exception;

public class InvalidTestData extends Exception {
	String message;

	public InvalidTestData(String msg) {
		message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
