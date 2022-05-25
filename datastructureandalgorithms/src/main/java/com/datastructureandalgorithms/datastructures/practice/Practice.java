package com.datastructureandalgorithms.datastructures.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target. You may assume that each input would have exactly one solution, and
 * you may not use the same element twice. You can return the answer in any order. Example 1: Input:
 * nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because nums[0] + nums[1] == 9, we
 * return [0, 1]. Example 2: Input: nums = [3,2,4], target = 6 Output: [1,2] Example 3: Input: nums
 * = [3,3], target = 6 Output: [0,1]
 */
public class TwoSumPractice {

  /* Input: nums = {2, 7, 11, 15}, target = 9.
  Output: Indices of two numbers that sum up to target (in any order).
  Assumptions: array is not empty, array with positive numbers, two numbers are unique, target is not = 0, only one solution/pair.
  Brute-force: Traverse through the array till a sum is found. Alternatively, traverse through the array till a complement number is found. Complexity: O(nxn) time, O(n) space.
  Optimized: Store complement and index on a hashtable. For each number, check the complement in the hashtable and get the index. Complexity: O(n) time, O(n) space.
   */

  public static void main(String[] args) {
    TwoSumPractice twoSumPractice = new TwoSumPractice();
    int[] numsOne = {2, 7, 11, 15};
    int targetOne = 9;
    int[] numsTwo = {3, 2, 4};
    int targetTwo = 6;
    int[] numsThree = {3, 3};
    int targetThree = 6;
    int[] numsFour = {1};
    int[] resultOne = twoSumPractice.twoSumBruteForce(numsOne, targetOne);
    for (int one : resultOne) {
      System.out.println(one);
    }
    int[] resultTwo = twoSumPractice.twoSumBruteForce(numsTwo, targetTwo);
    for (int two : resultTwo) {
      System.out.println(two);
    }
    int[] resultThree = twoSumPractice.twoSumBruteForce(numsThree, targetThree);
    for (int three : resultThree) {
      System.out.println(three);
    }
    int[] resultFour = twoSumPractice.twoSumBruteForce(numsFour, targetThree);
    for (int four : resultFour) {
      System.out.println(four);
    }

    System.out.println("============= OPTIMIZED =============");
    int[] resultOneOptimized = twoSumPractice.twoSumOptimized(numsOne, targetOne);
    for (int one : resultOneOptimized) {
      System.out.println(one);
    }
    int[] resultTwoOptimized = twoSumPractice.twoSumOptimized(numsTwo, targetTwo);
    for (int two : resultTwoOptimized) {
      System.out.println(two);
    }
    int[] resultThreeOptimized = twoSumPractice.twoSumOptimized(numsThree, targetThree);
    for (int three : resultThreeOptimized) {
      System.out.println(three);
    }
    int[] resultFourOptimized = twoSumPractice.twoSumOptimized(numsFour, targetThree);
    for (int four : resultFourOptimized) {
      System.out.println(four);
    }
  }

  public int[] twoSumBruteForce(int[] nums, int target) {
    // Data validations
    if (nums.length == 0 || nums.length == 1 || target == 0) {
      System.out.println(
          "Cannot find two-sum. Kindly enter an array with at least two positive numbers.");
      return new int[2];
    }

    int complement;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        complement = target - nums[i];
        if (nums[j] == complement) {
          return new int[]{i, j};
        }
      }
    }
    return new int[2];
  }

  public int[] twoSumOptimized(int[] nums, int target) {
    // Data validations
    if (nums.length == 0 || nums.length == 1 || target == 0) {
      System.out.println(
          "Cannot find two-sum. Kindly enter an array with at least two positive numbers.");
      return new int[2];
    }

    Map<Integer, Integer> complementMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (complementMap.containsKey(complement)) {
        return new int[]{i, complementMap.get(nums[i])};
      } else {
        complementMap.put(nums[i], i);
      }
    }
    return new int[2];  //todo
  }

}