package algorithms;

import java.util.logging.Logger;

/**
 * Recursive Binary Search
 * Array/ Linked List should be sorted 
 * Get a mid-point so divided the array into half every time for a search 
 * An Array is used to implement Binary Search. Size 5. Data element to be search is 2. Array = {1, 2, 3, 4, 5}
 * https://www.geeksforgeeks.org/binary-search/
 * 
 * Time complexity: O(Log(n))
 * Space complexity: O(Log(n)) recursion call stack space
 * 
 * @author prachi.shah
 */
class BinarySearchRecursive {

	private static final Logger logger = Logger.getLogger(BinarySearchRecursive.class.getName());

	// ===================Main Logic===================
	public int binarySearchAlgorithm(int[] arrayElements, int data, int lowBound, int higherBound) {

		int mid = 0;

		// Returns data if present in the arrayElements[]; else returns -1
		while (lowBound <= higherBound) {
			mid = lowBound + (higherBound - lowBound) / 2;

			if (arrayElements[mid] == data) { // data found at middle location
				return mid;
			}

			if (arrayElements[mid] < data) { // data is greater than mid so ignore the left half
				return binarySearchAlgorithm(arrayElements, data, mid + 1, higherBound);
			} else { // data is smaller than mid so ignore the right half - if(arrayElements[mid] >
						// data) {
				return binarySearchAlgorithm(arrayElements, data, lowBound, mid - 1);
			}
		}
		return -1; // data not found OR when lowBound > higherBound which mean the 
				  // pointers have flipped and we don't have any more elements to look at
	}

	public static void main(String[] args) {

		BinarySearchRecursive bs = new BinarySearchRecursive();
		int[] arrayElements = { 1, 2, 3, 4, 5 };
		int data = 3;
		int lowBound = 0;
		int higherBound = arrayElements.length - 1;

		int result = bs.binarySearchAlgorithm(arrayElements, data, lowBound, higherBound);

		if (result != -1) {
			logger.info("Binary Search: \n" + data + " found at position " + result);
		} else {
			logger.info(data + " not found.");
		}
	}
}

/*
 * Output: 
 * Mar 24, 2018 4:45:14 PM algorithms.BinarySearchIterative main 
 * INFO: Binary Search: 
 * 3 found at position 2
 */
