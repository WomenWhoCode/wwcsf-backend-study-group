package language.conversion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Create an Array[] from user input
 * Convert Array[] to HashMap
 * Convert HashMap to Array[]
 * HashMap is an unordered collection
 * @prachi.shah
 * 6-29-2018
 */
public class HashMapToArray {

	public static final Logger logger = Logger.getAnonymousLogger ();

	int[] arrayInput = null;
	Map <Integer, Integer> hashMap = null;
	String contents = null;

	public static void main (String[] args) {
		logger.info ("Program to convert HashMap to Array[]");

		HashMapToArray obj = new HashMapToArray ();
		obj.userIput ();
		obj.arrayToHashMap ();
		obj.hashMapToArray ();
	}

	public int[] userIput () {
		logger.info ("Creating first array; enter the size of array and then the integers to be added to the array:");

		// Create an integer array from user input
		// Can be ordered or unordered array
		Scanner scan = new Scanner (System.in);
		arrayInput = new int[scan.nextInt ()];
		for (int i = 0 ; i <= arrayInput.length - 1 ; i++) {
			arrayInput[i] = scan.nextInt ();
		}
		scan.close ();

		// Print contents and hash code
		contents = Arrays.toString (arrayInput);
		logger.log (Level.INFO , "Array[] elements are: {0}" , contents);
		String hashcode = Integer.toString (Arrays.hashCode (arrayInput));
		logger.log (Level.INFO , "Hashcode: {0}" , hashcode);

		return arrayInput;
	}

	public void arrayToHashMap () {
		logger.info ("Converting Array[] to HashMap:");

		// Convert Array[] to HashMap
		// NOTE: It supports duplicate elements
		// NOTE: HashMap is unsorted data structure so it will maintain element order
		hashMap = new HashMap <> (arrayInput.length);
		for (int i = 0 ; i <= arrayInput.length - 1 ; i++) {
			hashMap.put (i , arrayInput[i]);
		}

		contents = hashMap.toString ();
		logger.log (Level.INFO , "HashMap elements are: {0}" , contents);
	}

	public void hashMapToArray () {
		logger.info ("Converting HashMap to Array[]:");

		// Convert HashMAp to Array[]
		// Returns ordered data
		Integer[] arrayContent = hashMap.values ().toArray (new Integer[hashMap.size ()]); // Don't need to use the key
		// This is Integer[] not int[] because HashMap contents cannot be converted to
		// primitive types directly, they need to be converted to Generic

		contents = Arrays.toString (arrayContent);
		logger.log (Level.INFO , "Array[] elements are: {0}" , contents);
	}
}

/* OUTPUT:
Jun 29, 2018 8:33:18 PM conversions.HashMapToArray main
INFO: Program to convert HashMap to Array[]
Jun 29, 2018 8:33:18 PM conversions.HashMapToArray userIput
INFO: Creating first array; enter the size of array and then the integers to be added to the array:
3
3
1
2
Jun 29, 2018 8:33:21 PM conversions.HashMapToArray userIput
INFO: Array[] elements are: [3, 1, 2]
Jun 29, 2018 8:33:21 PM conversions.HashMapToArray userIput
INFO: Hashcode: 32707
Jun 29, 2018 8:33:21 PM conversions.HashMapToArray arrayToHashMap
INFO: Converting Array[] to HashMap:
Jun 29, 2018 8:33:21 PM conversions.HashMapToArray arrayToHashMap
INFO: HashMap elements are: {0=3, 1=1, 2=2}
Jun 29, 2018 8:33:21 PM conversions.HashMapToArray hashMapToArray
INFO: Converting HashMap to Array[]:
Jun 29, 2018 8:33:21 PM conversions.HashMapToArray hashMapToArray
INFO: Array[] elements are: [3, 1, 2]
*/