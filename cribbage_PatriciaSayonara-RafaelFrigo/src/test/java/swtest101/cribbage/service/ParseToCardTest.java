
package swtest101.cribbage.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static swtest101.cribbage.entity.Suit.CLUBS;
import static swtest101.cribbage.entity.Suit.DIAMONDS;
import static swtest101.cribbage.entity.Suit.HEARTS;
import static swtest101.cribbage.entity.Suit.SPADES;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import swtest101.cribbage.entity.Card;
import swtest101.cribbage.entity.Suit;

@RunWith(Parameterized.class)
public class ParseToCardTest {

	@Parameters(name = "{0}_ShouldReturn_{1}-{2}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { //
				{ "AC", 1, CLUBS }, //
				{ "7C", 7, CLUBS }, //
				{ "0D", 10, DIAMONDS }, //
				{ "JH", 11, HEARTS }, //
				{ "QS", 12, SPADES }, //
				{ "KC", 13, CLUBS },//
		});
	}

	@Parameter(0)
	public String input;

	@Parameter(1)
	public Integer expectedRank;

	@Parameter(2)
	public Suit expectedSuit;

	@Test
	public void testParseToCard() {
		final Card card = ParseStringService.parseToCard(input);

		assertThat(card.getRank(), is(equalTo(expectedRank)));
		assertThat(card.getSuit(), is(equalTo(expectedSuit)));
	}
}
