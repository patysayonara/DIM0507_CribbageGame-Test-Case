package swtest101.cribbage.entity;

/**
 *
 * @author eiji adachi
 *
 */
public enum Suit {

	// clubs (♣),
	CLUBS,
	// diamonds (♦),
	DIAMONDS,
	// hearts (♥)
	HEARTS,
	// spades (♠)
	SPADES;

	public char firstChar() {
		return name().charAt(0);
	}
}
