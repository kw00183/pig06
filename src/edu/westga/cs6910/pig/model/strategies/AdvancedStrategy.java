package edu.westga.cs6910.pig.model.strategies;

/**
 * AdvancedStrategy implements the PigStrategy class that defines the strategy
 * algorithms.
 * 
 * @author Kim Weible
 * @version Summer 2021
 */
public class AdvancedStrategy implements PigStrategy {

	/**
	 * Method determines whether the player should roll again or not
	 * 
	 * @param numberOfRollsSoFar	Number of rolls the player has taken this turn
	 * @param pointsSoFarThisTurn	Number of points gained so far this turn
	 * @param pointsToGoal			Number of points from the goal
	 * @param opponentPointsToGoal	Number of points the opponent is from the goal
	 * @return						True if the player should roll again, false otherwise
	 */
	public boolean rollAgain(int numberOfRollsSoFar, int pointsSoFarThisTurn, int pointsToGoal, int opponentPointsToGoal) {
		return true;
	}
}