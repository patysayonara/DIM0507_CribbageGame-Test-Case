package swtest101.cribbage.exception;

public class InvalidRankException extends InputParseException {

	private static final long serialVersionUID = -3828636849165087214L;

	public InvalidRankException(String errorMsg) {
		super(errorMsg);
	}

}
