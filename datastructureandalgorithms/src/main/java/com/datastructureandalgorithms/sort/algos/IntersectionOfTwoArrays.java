package data.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Problem:
 * Given two arrays, write a function to compute their intersection. Result must be an array[]
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2,2].
 * NOTE: The result can be in any order, result returns duplicate values as well, pure intersection
 * NOTE: The two arrays can be of variable sizes
 * https://leetcode.com/problems/intersection-of-two-arrays/discuss/139972/Java-solution-(76)
 * @prachi.shah
 * 6-29-2018
 */
public class IntersectionOfTwoArrays {

    public static final Logger logger = Logger.getAnonymousLogger();
    static int[] arrayOne = {1, 2, 3, 4, 5, 3, 7, 8, 9, 3}; // Holds first array elements
    static int[] arrayTwo = {7, 11, 12, 3, 14, 15, 9, 17, 18, 3, 20, 10, 8}; // Holds common elements between the

    public static void main(String[] args) {
        logger.info("Program to find intersection elements in two arrays:");

        IntersectionOfTwoArrays ob = new IntersectionOfTwoArrays();
        String result = Arrays.toString(ob.intersectionResult(arrayOne, arrayTwo));
        logger.log(Level.INFO, result);
    }

    private int[] intersectionResult(int[] arrayOne, int[] arrayTwo) {

        if (isEmptyArray(arrayOne, arrayTwo)) {
            logger.log(Level.INFO, "No intersection elements found");
            return new int[0];
        }

        printInputs(arrayOne, arrayTwo);

        HashMap<Integer, Integer> firstInput = new HashMap<>(); // all values initialized to 0

        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < arrayOne.length; i++) {
            if (firstInput.containsKey(arrayOne[i])) {
                firstInput.put(arrayOne[i], firstInput.get(arrayOne[i]) + 1); // key is number, value is it's count
                // For each occurrence, increment a
                // count (if number is repeated)
            } else {
                firstInput.put(arrayOne[i], 1);    // Not repeated numbers
            }
        }

        for (int i = 0; i < arrayTwo.length; i++) {
            if (firstInput.containsKey(arrayTwo[i]) && firstInput.get(arrayTwo[i]) > 0) { // If >0 occurrences means
                // number occurs twice
                resultList.add(arrayTwo[i]);
                firstInput.put(arrayTwo[i], firstInput.get(arrayTwo[i]) - 1); // Decrement count of occurrence
            }
        }

        if (resultList.isEmpty()) { // No intersection elements
            logger.log(Level.INFO, "No intersection elements found");
            return new int[0];
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    private void printInputs(int[] inputOne, int[] inputTwo) {

        String input1 = convertToString(inputOne);
        String input2 = convertToString(inputTwo);

        logger.log(Level.INFO, "First Array: {0}", input1);
        logger.log(Level.INFO, "Second Array: {0}", input2);
    }

    public String convertToString(int[] input) {

        String s = 50 + 30 + "Prachi" + 40 + 40;
        logger.log(Level.INFO, s); // Result: 80Prachi4040
        return Arrays.toString(input);
    }

    public boolean isEmptyArray(int[] arrayOne, int[] arrayTwo) {
        return (arrayOne.length == 0 || arrayTwo.length == 0);
    }
}

/* OUTPUT:
Jul 01, 2018 4:22:05 PM algorithms.IntersectionOfTwoArrays main
INFO: Program to find intersection elements in two arrays:
Jul 01, 2018 4:22:05 PM algorithms.IntersectionOfTwoArrays printInputs
INFO: First Array: [1, 2, 3, 4, 5, 3, 7, 8, 9, 3]
Jul 01, 2018 4:22:05 PM algorithms.IntersectionOfTwoArrays printInputs
INFO: Second Array: [7, 11, 12, 3, 14, 15, 9, 17, 18, 3, 20, 10, 8]
Jul 01, 2018 4:22:05 PM algorithms.IntersectionOfTwoArrays main
INFO: [7, 3, 9, 3, 8]
*/
