package excepciones.dni;

@SuppressWarnings("serial")
public class FailDNIException extends Exception {

	public FailDNIException() {
	}

	public FailDNIException(String message) {
		super(message);
	}

	public FailDNIException(Throwable cause) {
		super(cause);
	}

	public FailDNIException(String message, Throwable cause) {
		super(message, cause);
	}

	public FailDNIException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
