package algorithms;

import java.util.logging.Logger;

/**
 * Iterative Binary Search 
 * Array/ Linked List should be sorted 
 * Get a mid-point so divided the array into half every time for a search 
 * An Array is used to implement Binary Search. Size 5. Data element to be search is 2. Array = {1, 2, 3, 4, 5}
 * https://www.geeksforgeeks.org/binary-search/
 * 
 * Time complexity: O(Log(n))
 * Space complexity: O(1)
 * 
 * @author prachi.shah
 */
class BinarySearchIterative {

	private static final Logger logger = Logger.getLogger(BinarySearchIterative.class.getName());

	// ===================Variable Declarations===================
	int mid;
	int lowBound;
	int higherBound;
	int sizeOfArray;

	// ===================Main Logic===================
	public int binarySearchAlgorithm(int[] arrayElements, int data) {

		sizeOfArray = arrayElements.length;
		lowBound = 0;
		higherBound = sizeOfArray - 1;

		// Returns data if present in the arrayElements[]; else returns -1
		while (lowBound <= higherBound) {
			mid = lowBound + (higherBound - lowBound) / 2;

			if (arrayElements[mid] == data) { // data found at middle location
				return mid;
			}

			if (arrayElements[mid] < data) { // data is greater than mid so ignore the left half
				lowBound = mid + 1;
			}
			else { // data is smaller than mid so ignore the right half - if(arrayElements[mid] > data) {
				higherBound = mid - 1;
			}
		}
		return -1; // data not found OR when lowBound > higherBound which mean the 
		  		  // pointers have flipped and we don't have any more elements to look at
	}

	public static void main(String[] args) {

		BinarySearchIterative bs = new BinarySearchIterative();
		int[] arrayElements = { 1, 2, 3, 4, 5 };
		int data = 2;

		int result = bs.binarySearchAlgorithm(arrayElements, data);

		if (result != -1) {
			logger.info("Binary Search: \n" + data + " found at position " + result);
		} else {
			logger.info(data + " not found.");
		}
	}
}

/*
 * Output: 
 * Mar 24, 2018 3:58:58 PM algorithms.BinarySearchIterative main 
 * INFO: Binary Search: 
 * 2 found at position 1
 */
