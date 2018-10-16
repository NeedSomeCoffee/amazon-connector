package edu.amazon.exceptions;

public class PersistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4714482838748555336L;
	private String message;
	private Throwable cause;
	
	
	public PersistException(String message) {
		this.message = message;
	}


	public PersistException(String message, Throwable cause) {
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
		builder.append("PersistException [message=");
		builder.append(message);
		builder.append(", cause=");
		builder.append(cause);
		builder.append("]");
		return builder.toString();
	}
}
