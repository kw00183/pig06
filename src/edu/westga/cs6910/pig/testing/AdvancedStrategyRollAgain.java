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
}