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
	 * points (had 93 and rolled a 7) -- ends game
	 */
	@Test
	public void testWhenPlayerHasExactly100Points() {
		boolean result = this.strategy.rollAgain(1, 7, 0, 13);
		assertEquals(false, result);
	}

	/**
	 * BOUNDARY Test when the player has a valid roll, resulting in more than
	 * 100 points (had 93 and rolled a 10) -- ends game
	 */
	@Test
	public void testWhenPlayerExceeds100Points() {
		boolean result = this.strategy.rollAgain(1, 10, -3, 13);
		assertEquals(false, result);
	}

	/**
	 * BOUNDARY Test when the other player has a valid roll, resulting in
	 * exactly 100 points (had 93 and rolled a 7) -- ends game
	 */
	@Test
	public void testWhenOtherPlayerHasExactly100Points() {
		boolean result = this.strategy.rollAgain(0, 0, 13, 0);
		assertEquals(false, result);
	}

	/**
	 * BOUNDARY Test when the other player has a valid roll, resulting in more
	 * than 100 points (had 93 and rolled a 10) -- ends game
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

	/**
	 * BOUNDARY Test when the other player needs more than 7 points to win
	 */
	@Test
	public void testWhenOtherPlayerNeedsMoreThan7PointsToWin() {
		boolean result = this.strategy.rollAgain(1, 8, 13, 8);
		assertEquals(false, result);
	}

	/**
	 * BOUNDARY Test when players expected number of rolls is more than
	 * opponents using average 7 points per roll and first roll
	 */
	@Test
	public void testWhenOtherPlayerNeedsMoreRollsToWinFirstRoll() {
		int opponentPointsToGoal = 54;
		int pointsToGoal = 59;

		boolean result = this.strategy.rollAgain(0, 0, pointsToGoal,
				opponentPointsToGoal);
		assertEquals(true, result);
	}

	/**
	 * BOUNDARY Test when players expected number of rolls is less than
	 * opponents using average 7 points per roll and first roll
	 */
	@Test
	public void testWhenOtherPlayerNeedsLessRollsToWinFirstRoll() {
		int opponentPointsToGoal = 59;
		int pointsToGoal = 54;

		boolean result = this.strategy.rollAgain(0, 0, pointsToGoal,
				opponentPointsToGoal);
		assertEquals(true, result);
	}

	/**
	 * BOUNDARY Test when players expected number of rolls is more than
	 * opponents using average 7 points per roll and last roll valid
	 */
	@Test
	public void testWhenOtherPlayerNeedsMoreRollsToWin() {
		int opponentPointsToGoal = 59;
		int pointsToGoal = 54;

		boolean result = this.strategy.rollAgain(1, 8, pointsToGoal,
				opponentPointsToGoal);
		assertEquals(false, result);
	}

	/**
	 * BOUNDARY Test when players expected number of rolls is less than
	 * opponents using average 7 points per roll and last roll valid
	 */
	@Test
	public void testWhenOtherPlayerNeedsLessRollsToWin() {
		int opponentPointsToGoal = 54;
		int pointsToGoal = 59;

		boolean result = this.strategy.rollAgain(1, 8, pointsToGoal,
				opponentPointsToGoal);
		assertEquals(true, result);
	}

	/**
	 * BOUNDARY Test when players expected number of rolls are equal and average
	 * points per roll this turn are less than 7 (roll true)
	 */
	@Test
	public void testWhenOtherPlayerEqualRollsToWinAndAveragePointsPerRollLessThan7() {
		int opponentPointsToGoal = 54;
		int pointsToGoal = 55;
		int numberOfRollsSoFar = 3;
		int pointsSoFarThisTurn = 19;

		boolean result = this.strategy.rollAgain(numberOfRollsSoFar,
				pointsSoFarThisTurn, pointsToGoal, opponentPointsToGoal);
		assertEquals(true, result);
	}

	/**
	 * BOUNDARY Test when players expected number of rolls are equal and average
	 * points per roll this turn are more than 7 (roll false)
	 */
	@Test
	public void testWhenOtherPlayerEqualRollsToWinAndAveragePointsPerRollMoreThan7() {
		int opponentPointsToGoal = 54;
		int pointsToGoal = 55;
		int numberOfRollsSoFar = 3;
		int pointsSoFarThisTurn = 28;

		boolean result = this.strategy.rollAgain(numberOfRollsSoFar,
				pointsSoFarThisTurn, pointsToGoal, opponentPointsToGoal);
		assertEquals(false, result);
	}

	/**
	 * BOUNDARY Test when players expected number of rolls are equal and average
	 * points per roll this turn equal 7.0 (roll false)
	 */
	@Test
	public void testWhenOtherPlayerEqualRollsToWinAndAveragePointsPerRollEqualTo7() {
		int opponentPointsToGoal = 54;
		int pointsToGoal = 55;
		int numberOfRollsSoFar = 3;
		int pointsSoFarThisTurn = 21;

		boolean result = this.strategy.rollAgain(numberOfRollsSoFar,
				pointsSoFarThisTurn, pointsToGoal, opponentPointsToGoal);
		assertEquals(false, result);
	}

	/**
	 * BOUNDARY Test when players expected number of rolls are equal and average
	 * points per roll this turn equal 0.0 (roll true)
	 */
	@Test
	public void testWhenOtherPlayerEqualRollsToWinAndAveragePointsPerRollEqualTo0() {
		int opponentPointsToGoal = 54;
		int pointsToGoal = 55;
		int numberOfRollsSoFar = 0;
		int pointsSoFarThisTurn = 0;

		boolean result = this.strategy.rollAgain(numberOfRollsSoFar,
				pointsSoFarThisTurn, pointsToGoal, opponentPointsToGoal);
		assertEquals(true, result);
	}
}