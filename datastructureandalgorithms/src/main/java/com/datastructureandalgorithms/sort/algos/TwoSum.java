package coding.problems;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/solution/
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 5, 7, 9};
        System.out.println("Two Sum: " + Arrays.toString(getTwoSumBruteForce(numbers, 12)));
        System.out.println("Two Sum Optimized: " + Arrays.toString(getTwoSumOptimized(numbers, 12)));
    }

    // Brute force solution
    // Time: O(n square)
    // Space: O(1)
    private static int[] getTwoSumBruteForce(int[] numbers, int targetSum) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Input is empty");
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == targetSum - numbers[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("Two sum solution not available");
    }

    // Optimized
    // HashMap: key value pairs
    // create key, value are numbers
    // key is number; value is it's index
    // target - given number = a key in HashMap? then return value. if not key then
    // assign the given number to the HashMap
    // Time: O(n)
    // Space: O(n)
    private static int[] getTwoSumOptimized(int[] numbers, int targetSum) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Input is empty");
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= numbers.length; i++) {
            int complement = targetSum - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("Two sum solution not available");
    }

}