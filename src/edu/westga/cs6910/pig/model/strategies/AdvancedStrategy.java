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
	 * @param numberOfRollsSoFar
	 *            Number of rolls the player has taken this turn
	 * @param pointsSoFarThisTurn
	 *            Number of points gained so far this turn
	 * @param pointsToGoal
	 *            Number of points from the goal
	 * @param opponentPointsToGoal
	 *            Number of points the opponent is from the goal
	 * @return True if the player should roll again, false otherwise
	 */
	public boolean rollAgain(int numberOfRollsSoFar, int pointsSoFarThisTurn,
			int pointsToGoal, int opponentPointsToGoal) {
		boolean isStillTurn = false;
		boolean isGameWon = true;
		int expectedOtherPlayerNumberOfRollsLeft = (int) Math
				.ceil(opponentPointsToGoal / 7);
		int expectedPlayerNumberOfRollsLeft = (int) Math.ceil(pointsToGoal / 7);
		double averagePointsPerRollThisTurn = 0.0;

		if (numberOfRollsSoFar > 0) {
			averagePointsPerRollThisTurn = pointsSoFarThisTurn
					/ numberOfRollsSoFar;
		}

		if (numberOfRollsSoFar > 0 && pointsSoFarThisTurn > 0) {
			isStillTurn = true;
		}

		if (pointsToGoal > 0 && opponentPointsToGoal > 0) {
			isGameWon = false;
		}

		if (isStillTurn && !isGameWon && opponentPointsToGoal <= 7) {
			return true;
		} else if (isStillTurn && !isGameWon
				&& expectedOtherPlayerNumberOfRollsLeft > expectedPlayerNumberOfRollsLeft) {
			return false;
		} else if (isStillTurn && !isGameWon
				&& expectedOtherPlayerNumberOfRollsLeft < expectedPlayerNumberOfRollsLeft) {
			return true;
		} else if (isStillTurn && !isGameWon
				&& expectedOtherPlayerNumberOfRollsLeft == expectedPlayerNumberOfRollsLeft
				&& averagePointsPerRollThisTurn < 7.0) {
			return true;
		} else if (isStillTurn && !isGameWon
				&& expectedOtherPlayerNumberOfRollsLeft == expectedPlayerNumberOfRollsLeft
				&& averagePointsPerRollThisTurn >= 7.0) {
			return false;
		} else if (numberOfRollsSoFar == 0 && !isGameWon) {
			return true;
		} else if (isStillTurn && !isGameWon) {
			return true;
		}
		return false;
	}
}