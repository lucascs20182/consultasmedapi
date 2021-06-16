package br.edu.unifeso.apiconsultasmed.exceptions;

public class ItemAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public ItemAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ItemAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ItemAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ItemAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
