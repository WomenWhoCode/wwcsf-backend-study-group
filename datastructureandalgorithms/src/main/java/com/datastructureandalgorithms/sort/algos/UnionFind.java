package algorithms;

/**
 * @author prachi.shah
 * @date 2/6/16
 * @program An array of N - elements initialized with their respective index values If
 * two objects are connected, their values in the array would se same. Example:
 * if 6 and 7 are connected values of 6 would be the same as 7, that is, 7 A
 * union would make sure if the elements are not connected and then connect them
 * by seeing their values in the array
 * ----
 * Algorithm time: Quadratic Takes N x N time to process sequence of N unions on
 * N objects
 */
public class UnionFind {

	public static int[] totalElements;

	// Constructor
	public UnionFind(int numberOfElements) {
		totalElements = new int[numberOfElements];

		// Initialize the array - set id of each object to itself
		// N array accesses
		for (int i = 0; i < numberOfElements; i++) {
			totalElements[i] = i;
		}
	}

	// Check if two objects are connected. If yes, either values in the array
	// would be same
	// 2 array accesses
	public static boolean Connected(int objOne, int objTwo) {
		return totalElements[objOne] == totalElements[objTwo];
	}

	// Connect two objects
	// 2N + 2 array accesses
	public static void Union(int objOne, int objTwo) {
		int objOneValue = totalElements[objOne];
		int objTwoValue = totalElements[objTwo];

		if (!Connected(objOne, objTwo)) {
			// Change all entries with totalElements[objOne] to
			// totalElements[objTwo]
			for (int i = 0; i < totalElements.length; i++) {
				if (totalElements[i] == objOneValue) {
					totalElements[i] = objTwoValue;
				}
			}
		}
	}

	// Find an element in an array
	// Constant time, 1 array access
	public static void findElement(int elementID) {
		System.out.println("Value of " + elementID + ": " + totalElements[elementID]);
	}

	// Print entire array after connections have been made
	public static void printArrayElements() {
		int[] arrayElements = new int[totalElements.length];

		for (int i = 0; i < arrayElements.length; i++) {
			arrayElements[i] = totalElements[i];
			System.out.print(arrayElements[i] + " ");
		}
	}

	public static void main(String[] args) {

		// Static methods so can be accessed without creating an object of the
		// class.
		@SuppressWarnings("unused")
		UnionFind unf = new UnionFind(10);

		// Static methods so do not need an object to initialize them
		Union(1, 2);
		Union(4, 5);
		Union(6, 7);

		findElement(6);

		printArrayElements();
	}
}