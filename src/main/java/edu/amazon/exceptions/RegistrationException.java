package edu.amazon.exceptions;

public class RegistrationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3083184394974618129L;
	private String message;
	private Throwable cause;
	
	
	public RegistrationException(String message) {
		this.message = message;
	}


	public RegistrationException(String message, Throwable cause) {
		this.message = message;
		this.cause = cause;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public Throwable getCause() {
		return cause;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParsingException [message=");
		builder.append(message);
		builder.append(", cause=");
		builder.append(cause);
		builder.append("]");
		return builder.toString();
	}
}
