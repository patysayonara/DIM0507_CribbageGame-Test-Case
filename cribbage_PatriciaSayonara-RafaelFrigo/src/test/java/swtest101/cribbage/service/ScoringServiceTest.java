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
				{"PairTest", "5S9H5CJDKH", 2},
				{"PairTest", "QS0H8C6DQH", 2},
				{"PairTest", "4S7HJC9DJH", 2},
				{"PairTest", "7S9HKCJDKH", 2},
				{"StraightTest", "AS3H7C8D9S", 3},
				{"StraightTest", "AS7H8C3D9S", 3},
				{"StraightTest", "ASJHQCKD9S", 3},
				{"StraightTest", "9SKHQCJDAS", 3},
				{"StraightTest", "AS0H9C8D7S", 4},
				{"StraightTest", "6S7H8C9D0S", 5},
				{"StraightTest", "QS9H0CJDKS", 5},
				{"FlushTest", "AS3SKS7S9D",4},
				{"FlushTest", "AD3DKD7D9H",4},
				{"FlushTest", "AH3HKH7H9C",4},
				{"FlushTest", "AC3CKC7C9S",4},
				{"FlushTest", "AS3SKS7S9S",5},
				{"FlushTest", "AD3DKD7D9D",5},
				{"FlushTest", "AH3HKH7H9H",5},
				{"FlushTest", "AC3CKC7C9C",5},
				{"NobAndPairTest", "AHJH3C7D9S", 3},
				{"NobAndPairTest", "AD2CJD7H9S", 3},
				{"NobAndPairTest", "AC2D7HJC9S", 3},
				{"NobAndPairTest", "AS3C7H9DJS", 3},
				{"FifteenTest", "QD5CAH2S6D", 2},
				{"FifteenTest", "KD4CAH2S6D", 2},
				{"FifteenTest", "AD2C5H7S9D", 4},
				{"FifteenTest", "0D3C2H5S7D", 6}
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
