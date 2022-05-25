package algorithms;

import java.util.logging.Logger;

/**
 * Iterative Interpolation Search
 * Array/ Linked List should be sorted 
 * Get a mid-point so divided the array into half every time for a search 
 * An Array is used to implement Interpolation Search. Size 5. Data element to be search is 3. Array = {1, 2, 3, 4, 5}
 * https://www.geeksforgeeks.org/interpolation-search/
 * https://link.springer.com/chapter/10.1007%2F3-540-56939-1_58
 * 
 * The idea of formula is to return higher value of position/index when element to be searched is closer to arrayElements[higherBound].
 * And, a smaller value of position/index when closer to arrayElements[lowBound]
 * 
 * Time complexity: O(Log(Log(n)))
 * Space complexity: O(1)
 * 
 * @author prachi.shah
 */
class InterpolationSearchIterative {

	private static final Logger logger = Logger.getLogger(InterpolationSearchIterative.class.getName());

	// ===================Main Logic===================
	public int interpolationSearchAlgorithm(int[] arrayElements, int data, int lowBound, int higherBound) {

		int mid = 0;

		// Returns data if present in the arrayElements[]; else returns -1
		while (lowBound <= higherBound && data >= arrayElements[lowBound] && data <= arrayElements[higherBound]) {
			mid = lowBound + (((higherBound - lowBound) / (arrayElements[higherBound] - arrayElements[lowBound])) * (data - arrayElements[lowBound]));

			if (arrayElements[mid] == data) { // data found at middle location
				return mid;
			}

			if (arrayElements[mid] < data) { // data is greater than mid so ignore the left half
				return interpolationSearchAlgorithm(arrayElements, data, mid + 1, higherBound);
			} else { // data is smaller than mid so ignore the right half - if(arrayElements[mid] >
						// data) {
				return interpolationSearchAlgorithm(arrayElements, data, lowBound, mid - 1);
			}
		}
		return -1; // data not found OR when lowBound > higherBound which mean the 
				  // pointers have flipped and we don't have any more elements to look at
	}

	public static void main(String[] args) {

		InterpolationSearchIterative bs = new InterpolationSearchIterative();
		int[] arrayElements = { 1, 2, 3, 4, 5 };
		int data = 3;
		int lowBound = 0;
		int higherBound = arrayElements.length - 1;

		int result = bs.interpolationSearchAlgorithm(arrayElements, data, lowBound, higherBound);

		if (result != -1) {
			logger.info("Interpolation Search: \n" + data + " found at position " + result);
		} else {
			logger.info(data + " not found.");
		}
	}
}

/* Output: 
 * Mar 27, 2018 2:11:34 PM algorithms.InterpolationSearchIterative main
 * INFO: Interpolation Search: 
 * 3 found at position 2
 */
