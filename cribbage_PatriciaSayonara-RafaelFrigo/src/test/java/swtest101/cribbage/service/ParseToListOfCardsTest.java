package swtest101.cribbage.service;

import static org.hamcrest.CoreMatchers.*;
import static swtest101.cribbage.entity.Suit.CLUBS;
import static swtest101.cribbage.entity.Suit.DIAMONDS;
import static swtest101.cribbage.entity.Suit.HEARTS;
import static swtest101.cribbage.entity.Suit.SPADES;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import swtest101.cribbage.entity.Card;


public class ParseToListOfCardsTest {
	
	private String handOfCards;
	private List<Card> actualListOfCards;
	private List<Card> expectedListOfCards;

	private final Card KING_SPADES = (new Card(13, SPADES));
	private final Card NINE_HEARTS = (new Card(9, HEARTS));
	private final Card TWO_CLUBS = (new Card(2, CLUBS));
	private final Card FIVE_DIAMONS = (new Card(5, DIAMONDS));
	private final Card SIX_CLUBS = (new Card(6, CLUBS));
	private final Card EIGHT_CLUBS = (new Card(8, CLUBS));
//	private final Card SEVEN_HEARTS = (new Card(7, HEARTS));
//	private final Card KING_CLUBS = (new Card(13, CLUBS));
//	private final Card JACK_CLUBS = (new Card(11, SPADES));
//	private final Card THREE_SPADES = (new Card(3, SPADES));

	
	@Test
	public void shouldReturnNoCard() { 
		handOfCards = "";
		actualListOfCards = ParseStringService.parseToListOfCards(handOfCards);
		expectedListOfCards = new ArrayList<Card>();
		
		Assert.assertThat(actualListOfCards, is(expectedListOfCards));
	}
	
	@Test
	public void shouldReturnACard() { 
		handOfCards = "KS";
		actualListOfCards = ParseStringService.parseToListOfCards(handOfCards);
		expectedListOfCards = new ArrayList<Card>();
		expectedListOfCards.add(KING_SPADES);
		
		Assert.assertThat(actualListOfCards, is(expectedListOfCards));
	}
	
	@Test
	public void shouldReturnSameOrder1() {
		handOfCards = "KS9H";
		actualListOfCards = ParseStringService.parseToListOfCards(handOfCards);
		expectedListOfCards = new ArrayList<Card>();
		expectedListOfCards.add(KING_SPADES);
		expectedListOfCards.add(NINE_HEARTS);
		
		Assert.assertThat(actualListOfCards, is(expectedListOfCards));		
	}
	
	@Test
	public void shouldReturnSameOrder2() {
		handOfCards = "KS9H2C";
		actualListOfCards = ParseStringService.parseToListOfCards(handOfCards);
		expectedListOfCards = new ArrayList<Card>();
		expectedListOfCards.add(KING_SPADES);
		expectedListOfCards.add(NINE_HEARTS);
		expectedListOfCards.add(TWO_CLUBS);
		
		Assert.assertThat(actualListOfCards, is(expectedListOfCards));		
	}
	
	@Test
	public void shouldReturnSameOrder3() {
		handOfCards = "KS9H2C";
		actualListOfCards = ParseStringService.parseToListOfCards(handOfCards);
		expectedListOfCards = new ArrayList<Card>();
		expectedListOfCards.add(KING_SPADES);
		expectedListOfCards.add(NINE_HEARTS);
		expectedListOfCards.add(TWO_CLUBS);
		
		Assert.assertThat(actualListOfCards, is(expectedListOfCards));		
	}
	
	@Test
	public void shouldReturnSameOrder4() {
		handOfCards = "KS9H2C5D";
		actualListOfCards = ParseStringService.parseToListOfCards(handOfCards);
		expectedListOfCards = new ArrayList<Card>();
		expectedListOfCards.add(KING_SPADES);
		expectedListOfCards.add(NINE_HEARTS);
		expectedListOfCards.add(TWO_CLUBS);
		expectedListOfCards.add(FIVE_DIAMONS);
		
		Assert.assertThat(actualListOfCards, is(expectedListOfCards));		
	}
	
	@Test
	public void shouldReturnSameOrder5() {
		handOfCards = "KS9H2C5D6C";
		actualListOfCards = ParseStringService.parseToListOfCards(handOfCards);
		expectedListOfCards = new ArrayList<Card>();
		expectedListOfCards.add(KING_SPADES);
		expectedListOfCards.add(NINE_HEARTS);
		expectedListOfCards.add(TWO_CLUBS);
		expectedListOfCards.add(FIVE_DIAMONS);
		expectedListOfCards.add(SIX_CLUBS);
		
		Assert.assertThat(actualListOfCards, is(expectedListOfCards));		
	}	

	@Test
	public void shouldReturnSameOrder6() {
		handOfCards = "KS9H2C5D6C8C";
		actualListOfCards = ParseStringService.parseToListOfCards(handOfCards);
		expectedListOfCards = new ArrayList<Card>();
		expectedListOfCards.add(KING_SPADES);
		expectedListOfCards.add(NINE_HEARTS);
		expectedListOfCards.add(TWO_CLUBS);
		expectedListOfCards.add(FIVE_DIAMONS);
		expectedListOfCards.add(SIX_CLUBS);
		expectedListOfCards.add(EIGHT_CLUBS);
		
		Assert.assertThat(actualListOfCards, is(expectedListOfCards));		
	}
	
}
