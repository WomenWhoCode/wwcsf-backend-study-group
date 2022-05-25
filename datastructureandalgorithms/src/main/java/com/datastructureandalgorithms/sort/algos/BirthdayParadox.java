package algorithms;

import java.util.logging.Logger;

/**
 * Birthday Paradox 
 * https://www.geeksforgeeks.org/birthday-paradox/
 * 
 * Here, how many people must be there in a room to make the probability 50% 
 * that two people in the room have same birthday?
 * 
 * Time complexity: O(1) to calculate the result of the formulae
 * Space complexity: O(1) to store the result
 * 
 * @author prachi.shah
 */
class BirthdayParadox {

	private static final Logger logger = Logger.getLogger(BirthdayParadox.class.getName());

	// ===================Main Logic===================
	public double findNumberOfPeopleForAGivenProbability(double probability) {

		// 367 (since there are 366 possible birthdays, including February 29).
		// probability = 1 means 100% chance of two people having the same birthday, we need 366 +1 people (including February 29)
		if (probability != 1) {
			return Math.ceil(Math.sqrt(2 * 365 * Math.log(1 / (1 - probability))));
		} else {
			return 367;
		}
	}

	public static void main(String[] args) {

		BirthdayParadox bs = new BirthdayParadox();
		double probability = 0.5;
		double result = bs.findNumberOfPeopleForAGivenProbability(probability); // 0.5 probability means 50% chance

		double percentage = probability * 100;
		logger.info("For probability/chance to be " + percentage + "%, the number of people should be: " + Math.round(result));
	}
}

/*
 * Output: 
 * Mar 27, 2018 11:47:18 PM algorithms.BirthdayParadox main
 * INFO: For probability/chance to be 50%, the number of people should be: 23
 */
