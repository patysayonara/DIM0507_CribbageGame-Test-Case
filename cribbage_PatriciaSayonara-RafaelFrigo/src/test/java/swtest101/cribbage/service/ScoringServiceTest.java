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

@RunWith(Parameterized.class)
public class ScoringServiceTest {

	@Parameters(name = "{0}-\"{1}\"_ShouldReturn_{2}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] {
				{"PairTest", "AS9HJCKDAH", 2},
				{"PairTest", "4S9H4CJDKH", 2},
				{"PairTest", "QS0H8C6DQH", 2},
				{"PairTest", "4S7HJC9DJH", 2},
				{"PairTest", "7S9HKCJDKH", 2},
				{"PairTest", "8S2H4D2C2S", 6},
				{"PairTest", "4S4H4C5S4D", 12},
				{"StraightTest", "AS3H8C9D0S", 3},
				{"StraightTest", "AS9H8C3D0S", 3},
				{"StraightTest", "ASJHQCKD9S", 3},
				{"StraightTest", "9SKHQCJDAS", 3},
				{"StraightTest", "ASJH0C9D8S", 4},
				{"StraightTest", "9S0HJCQDKS", 5},
				{"StraightTest", "QS9H0CJDKS", 5},
				{"FlushTest", "AD3SKS7S9S",4},
				{"FlushTest", "AH3DKD7D9D",4},
				{"FlushTest", "AC3HKH7H9H",4},
				{"FlushTest", "AS3CKC7C9C",4},
				{"FlushTest", "AS3SKS7S9S",5},
				{"FlushTest", "AD3DKD7D9D",5},
				{"FlushTest", "AH3HKH7H9H",5},
				{"FlushTest", "AC3CKC7C9C",5},
				{"NobTest", "AHJH3C7D9S", 1},
				{"NobTest", "AD2CJD7H9S", 1},
				{"NobTest", "AC2D7HJC9S", 1},
				{"NobTest", "AS3C7H9DJS", 1},
				{"FifteenTest", "QD5CAH2S6D", 2},
				{"FifteenTest", "KD4CAH2S6D", 2},
				{"FifteenTest", "AD2C5H7S9D", 4},
				{"FifteenTest", "0D3C2H5S7D", 6},
				{"PairFifteenTest", "QH2CKC2S3C", 10},
				{"PairStraightFifteenTest", "8H9D2H8C7S", 12},
				{"PairStraightFifteenTest", "2C3S4S2S0H", 12},
				{"StraightNobFifteenTest", "6C4D5DJCKS", 10}
		});
	}
	
	@Parameter(0)
	public String testType;
	
	@Parameter(1)
	public String handOfCards;
	
	@Parameter(2)
	public Integer expectedScore;
	
	@Test
	public void test() {
		final Integer actualScore = ScoringService.calculateScore(handOfCards);

		assertThat(actualScore, is(equalTo(expectedScore)));
	}

}
