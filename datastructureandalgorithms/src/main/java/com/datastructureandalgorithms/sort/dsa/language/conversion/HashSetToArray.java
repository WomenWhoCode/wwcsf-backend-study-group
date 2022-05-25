package language.conversion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Create an Array[] from user input
 * Convert Array[] to HashSet
 * Convert HashSet to Array[]
 * HashSet is an ordered/sorted collection/Set
 * @prachi.shah
 * 6-29-2018
 */
public class HashSetToArray {

	public static final Logger logger = Logger.getAnonymousLogger();

	int[] arrayInput = null;
	Set<Integer> hashSet = null;
	String contents = null;

	public static void main(String[] args) {
		logger.info("Program to convert HashSet to Array[]");

		HashSetToArray obj = new HashSetToArray();
		obj.userIput();
		obj.arrayToHashSet();
		obj.hashSetToArray();
	}

	public int[] userIput() {
		logger.info("Creating first array; enter the size of array and then the integers to be added to the array:");

		// Create an integer array from user input
		// Can be ordered or un-ordered array
		Scanner scan = new Scanner(System.in);
		arrayInput = new int[scan.nextInt()];
		for (int i = 0; i <= arrayInput.length - 1; i++) {
			arrayInput[i] = scan.nextInt();
		}
		scan.close();

		// Print contents and hash code
		contents = Arrays.toString(arrayInput);
		logger.log(Level.INFO, "Array[] elements are: {0}", contents);
		String hashcode = Integer.toString(Arrays.hashCode(arrayInput));
		logger.log(Level.INFO, "Hashcode: {0}", hashcode);

		return arrayInput;
	}

	public void arrayToHashSet() {
		logger.info("Converting Array[] to HashSet:");

		// Convert Array[] to HashSet
		// NOTE: It is non-duplicate so any duplicates shall be ignored, can cause loss
		// of data, change in data order
		// NOTE: HashSet is sorted data structure so you'll loose the order of the
		// Array[] data elements
		hashSet = new HashSet<>(arrayInput.length);
		for (int x : arrayInput) {
			hashSet.add(x);
		}

		contents = hashSet.toString();
		logger.log(Level.INFO, "HashSet elements are: {0}", contents);
	}

	public void hashSetToArray() {
		logger.info("Converting HashSet to Array[]:");

		// Convert HashSet to Array[]
		// Returns sorted set
		Integer[] arrayContent = hashSet.toArray(new Integer[hashSet.size()]);
		// This is Integer[] not int[] because HashSet contents cannot be converted to
		// primitive types directly, they need to be converted to Generic

		contents = Arrays.toString(arrayContent);
		logger.log(Level.INFO, "Array[] elements are: {0}", contents);
	}
}

/* OUTPUT:
Jun 29, 2018 8:26:17 PM conversions.HashSetToArray main
INFO: Program to convert HashSet to Array[]
Jun 29, 2018 8:26:17 PM conversions.HashSetToArray userIput
INFO: Creating first array; enter the size of array and then the integers to be added to the array:
3
3
1
2
Jun 29, 2018 8:26:21 PM conversions.HashSetToArray userIput
INFO: Array[] elements are: [3, 1, 2]
Jun 29, 2018 8:26:21 PM conversions.HashSetToArray userIput
INFO: Hashcode: 32707
Jun 29, 2018 8:26:21 PM conversions.HashSetToArray arrayToHashSet
INFO: Converting Array[] to HashSet:
Jun 29, 2018 8:26:21 PM conversions.HashSetToArray arrayToHashSet
INFO: HashSet elements are: [1, 2, 3]
Jun 29, 2018 8:26:21 PM conversions.HashSetToArray hashSetToArray
INFO: Converting HashSet to Array[]:
Jun 29, 2018 8:26:21 PM conversions.HashSetToArray hashSetToArray
INFO: Array[] elements are: [1, 2, 3]
*/
