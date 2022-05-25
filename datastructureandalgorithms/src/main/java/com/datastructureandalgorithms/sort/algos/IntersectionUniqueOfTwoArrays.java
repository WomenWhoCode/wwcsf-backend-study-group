package data.structures;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/* Problem:
 * Given two arrays, write a function to compute their intersection. Result must be an array[]
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * NOTE: The results need to be unique. The result can be in any order
 * NOTE: The two arrays can be of variable sizes
 * https://leetcode.com/problems/intersection-of-two-arrays/discuss/139972/Java-solution-(76)
 * @prachi.shah
 * 6-29-2018
 */
public class IntersectionUniqueOfTwoArrays {

    public static final Logger logger = Logger.getAnonymousLogger();
    static int[] arrayOne = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Holds first array elements
    static int[] arrayTwo = {7, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 10, 8}; // Holds common elements between the

    public static void main(String[] args) {
        logger.info("Program to find unique intersection elements in two arrays:");

        IntersectionUniqueOfTwoArrays obj = new IntersectionUniqueOfTwoArrays();
        obj.intersectionResult(arrayOne, arrayTwo);
    }

    private void intersectionResult(int[] one, int[] two) {

        //printInputs(one, two);

        Set<Integer> setOne = getSetOne(one);
        Set<Integer> intersectionSet = performIntersection(setOne, two);
        System.out.println(Arrays.toString(intersectionSet.toArray()));
    }

    private Set<Integer> getSetOne(int[] one) {

        Set<Integer> setOne = new HashSet<>(one.length);
        for (int i : one) {
            setOne.add(i);
        }
        return setOne;
    }

    private Set<Integer> performIntersection(Set<Integer> setOne, int[] two) {

        // We are using set to avoid duplicate elements, also the result will be sorted
        Set<Integer> intersectionSet = new HashSet<>();
        for (Integer i : two) {
            if (setOne.contains(i)) {
                intersectionSet.add(i);
            }
        }
        return intersectionSet;
    }

    /*
     * Integer[] intersectionArray = intersectionSet.toArray(new Integer[] {});
     * int[] resultArray = new int[intersectionArray.length]; for (int i = 0; i
     * <resultArray.length; i++) { resultArray[i] = resultArray[i]; } return
     * resultArray;
     */

}

/* OUTPUT:
Jul 01, 2018 1:50:28 PM algorithms.IntersectionUniqueOfTwoArrays main
INFO: Program to find unique intersection elements in two arrays:
Jul 01, 2018 1:50:28 PM algorithms.IntersectionUniqueOfTwoArrays printInputs
INFO: First Array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Jul 01, 2018 1:50:28 PM algorithms.IntersectionUniqueOfTwoArrays printInputs
INFO: Second Array: [7, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 10, 8]
Jul 01, 2018 1:50:28 PM algorithms.IntersectionUniqueOfTwoArrays printResults
INFO: Common elements are: [7, 8, 10]
*/
