package swtest101.cribbage.entity;

/**
 *
 * @author eiji adachi
 *
 */
public class Card {
	/**
	 * The rank of a card is internally represented as an integer.
	 *
	 * Ace is represented as 1
	 *
	 * Numbers from 2 to 10 are represented as their own values
	 *
	 * Jack is represented as 11
	 *
	 * Queen is represented as 12
	 *
	 * King is represented as 13
	 */
	private Integer rank;

	/**
	 * Might be one of: clubs (♣), diamonds (♦), hearts (♥) or spades (♠)
	 */
	private Suit suit;

	public Card() {
		super();
	}

	public Card(Integer rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Card other = (Card) obj;
		if (rank == null) {
			if (other.rank != null) {
				return false;
			}
		} else if (!rank.equals(other.rank)) {
			return false;
		}
		if (suit != other.suit) {
			return false;
		}
		return true;
	}

	public Integer getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + "]";
	}
}
