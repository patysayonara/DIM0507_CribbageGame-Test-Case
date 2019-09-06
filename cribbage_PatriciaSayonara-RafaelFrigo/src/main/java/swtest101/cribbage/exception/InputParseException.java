package swtest101.cribbage.exception;

public class InputParseException extends RuntimeException {

	private static final long serialVersionUID = 419138294774349516L;

	public InputParseException(String errorMsg) {
		super(errorMsg);
	}
}
