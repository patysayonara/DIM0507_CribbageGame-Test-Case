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

import swtest101.cribbage.exception.InvalidStringLenghtException;

@RunWith (Parameterized.class)
public class ParseToListOfCardsExceptionalTest {

	@Parameters(name = "{3}-{0}_ShouldThrow_{1}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] {
				{ "QCKHJA2H6DQ", InvalidStringLenghtException.class, ParseStringService.INVALID_CARD_STRING_LENGTH_ERROR_MSG, "InvalidStringLength1" },
				{ "ASQHK", InvalidStringLenghtException.class, ParseStringService.INVALID_CARD_STRING_LENGTH_ERROR_MSG, "InvalidStringLength2" },
				{ "A", InvalidStringLenghtException.class, ParseStringService.INVALID_CARD_STRING_LENGTH_ERROR_MSG, "InvalidStringLength3" },
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
	public void testParseInvalidFormat() {
		e.expect(expectedExceptionType);
		e.expectMessage(expectedErrorMessage);
		
		ParseStringService.parseToListOfCards(input);
	}
}
