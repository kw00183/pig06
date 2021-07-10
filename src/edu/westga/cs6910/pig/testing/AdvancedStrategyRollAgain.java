package edu.westga.cs6910.pig.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.AdvancedStrategy;

/**
 * This is the JUnit testing class to test the advanced strategy to roll again
 * 
 * @author Kim Weible
 * @version Summer 2021
 *
 */
public class AdvancedStrategyRollAgain {
	private AdvancedStrategy strategy;

	/**
	 * run before each method execution
	 */
	@BeforeEach
	public void setUp() {
		this.strategy = new AdvancedStrategy();
	}

	/**
	 * SUNNY-DAY Test for the first roll of the game by the computer
	 */
	@Test
	public void testShouldReturnTrueAtStartOfGame() {
		boolean result = this.strategy.rollAgain(0, 0, 100, 100);
		assertEquals(true, result);
	}

	/**
	 * SUNNY-DAY Test for the first roll of the game by the computer when the
	 * human player rolled 1 and has no points
	 */
	@Test
	public void testShouldReturnTrueAtStartOfGameAfterHumanPlayerHasGoneWithNoPoints() {
		boolean result = this.strategy.rollAgain(0, 0, 100, 100);
		assertEquals(true, result);
	}

	/**
	 * SUNNY-DAY Test for the first roll of the game by the computer when the
	 * human player rolled and now has points
	 */
	@Test
	public void testShouldReturnTrueAtStartOfGameAfterHumanPlayerHasGoneWithSomePoints() {
		boolean result = this.strategy.rollAgain(0, 0, 100, 93);
		assertEquals(true, result);
	}

	/**
	 * BOUNDARY Test when the player has a valid roll, resulting in exactly 100
	 * points (had 93 and rolled a 7)
	 */
	@Test
	public void testWhenPlayerHasExactly100Points() {
		boolean result = this.strategy.rollAgain(1, 7, 0, 13);
		assertEquals(false, result);
	}

	/**
	 * BOUNDARY Test when the player has a valid roll, resulting in more than
	 * 100 points (had 93 and rolled a 10)
	 */
	@Test
	public void testWhenPlayerExceeds100Points() {
		boolean result = this.strategy.rollAgain(1, 10, -3, 13);
		assertEquals(false, result);
	}

	/**
	 * BOUNDARY Test when the other player has a valid roll, resulting in
	 * exactly 100 points (had 93 and rolled a 7)
	 */
	@Test
	public void testWhenOtherPlayerHasExactly100Points() {
		boolean result = this.strategy.rollAgain(0, 0, 13, 0);
		assertEquals(false, result);
	}

	/**
	 * BOUNDARY Test when the other player has a valid roll, resulting in more
	 * than 100 points (had 93 and rolled a 10)
	 */
	@Test
	public void testWhenOtherPlayerExceeds100Points() {
		boolean result = this.strategy.rollAgain(0, 0, 13, -3);
		assertEquals(false, result);
	}

	/**
	 * BOUNDARY Test when the other player needs exactly 7 points to win
	 */
	@Test
	public void testWhenOtherPlayerNeeds7PointsToWin() {
		boolean result = this.strategy.rollAgain(1, 5, 13, 7);
		assertEquals(true, result);
	}

	/**
	 * BOUNDARY Test when the other player needs less than 7 points to win
	 */
	@Test
	public void testWhenOtherPlayerNeedsLessThan7PointsToWin() {
		boolean result = this.strategy.rollAgain(1, 8, 13, 3);
		assertEquals(true, result);
	}
}