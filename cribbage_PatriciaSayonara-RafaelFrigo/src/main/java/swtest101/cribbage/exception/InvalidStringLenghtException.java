package swtest101.cribbage.exception;

public class InvalidStringLenghtException extends InputParseException {

	private static final long serialVersionUID = 1L;

	public InvalidStringLenghtException(String errorMsg) {
		super(errorMsg);
	}

}
