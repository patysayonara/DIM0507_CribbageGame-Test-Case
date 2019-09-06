package swtest101.cribbage.service;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import swtest101.cribbage.exception.InputParseException;
import swtest101.cribbage.exception.InvalidRankException;

@RunWith(Parameterized.class)
public class ParseToCardExceptionalTest {

	@Parameters(name = "{3}-{0}_ShouldThrow_{1}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { //
				{ "XH", InvalidRankException.class, ParseStringService.INVALID_RANK_CHAR_ERROR_MSG, "InvalidRank1" }, //
				{ "OC", InvalidRankException.class, ParseStringService.INVALID_RANK_CHAR_ERROR_MSG, "InvalidRank2" }, //
				{ "0*", InputParseException.class, ParseStringService.INVALID_SUIT_CHAR_ERROR_MSG, "InvalidSuit1" }, //
				{ "0J", InputParseException.class, ParseStringService.INVALID_SUIT_CHAR_ERROR_MSG, "InvalidSuit2" }, //
				{ "10H", InputParseException.class, ParseStringService.INVALID_CARD_STRING_ERROR_MSG, "InvalidCard1" }, //
				{ "0 S", InputParseException.class, ParseStringService.INVALID_CARD_STRING_ERROR_MSG, "InvalidCard2" },//
		});
	}

	@Rule
	public ExpectedException e = ExpectedException.none();

	@Parameter(0)
	public String input;

	@Parameter(1)
	public Class<? extends Exception> expectedExceptionType;

	@Parameter(2)
	public String expectedErrorMessage;

	@Parameter(3)
	public String name;

	@Test
	public void testParseInvalidRank() {
		e.expect(expectedExceptionType);
		e.expectMessage(expectedErrorMessage);

		ParseStringService.parseToCard(input);
	}
}
