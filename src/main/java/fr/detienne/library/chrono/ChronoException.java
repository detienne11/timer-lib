package fr.detienne.library.chrono;

public final class ChronoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ChronoException() {
		super();
	}

	public ChronoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChronoException(String message) {
		super(message);
	}

	public ChronoException(Throwable cause) {
		super(cause);
	}	

}
