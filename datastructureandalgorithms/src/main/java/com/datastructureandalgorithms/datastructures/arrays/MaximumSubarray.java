package com.datastructureandalgorithms.datastructures.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author prachishah Leetcode: https://leetcode.com/problems/contains-duplicate/
 */
public class DuplicatesInArray {

  public static void main(String[] args) {
    DuplicatesInArray duplicatesInArray = new DuplicatesInArray();
    int[] numsOne = {1, 2, 3, 1}; // true
    int[] numsTwo = {1, 2, 3, 4}; // false
    int[] numsThree = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}; // true
    System.out.println(duplicatesInArray.calculateDuplicatesOptimized(numsOne));
    System.out.println(duplicatesInArray.calculateDuplicatesOptimized(numsTwo));
    System.out.println(duplicatesInArray.calculateDuplicatesOptimized(numsThree));
  }

  /* Linear Search:
  public boolean containsDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
      for (int j = 0; j < i; ++j) {
        if (nums[j] == nums[i]) return true;
      }
    }
    return false;
  } // Time: O(nxn). Space: O(n)
  */
  /* Sorting first and then compare. Consecutive numbers would be duplicates:
  public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; ++i) {
        if (nums[i] == nums[i + 1]) return true;
    }
    return false;
  }
  */ // Time: O(n log n) for sorting + O(n) for search. Space: O(n) + auxiliary space O(1) for sorting.
  private boolean calculateDuplicatesOptimized(int[] input) {
    // Input: Array with duplicates.
    // Output: If at least one duplicate found then return true.
    // Assumptions: Zeros allowed. No negative numbers. If array empty or one element then handle the error.
    // Data validations
    if (input == null || input.length < 2) {
      System.out.println("Cannot find duplicates. Kindly enter at least two numbers.");
      return false;
    }

    // Hashset stores non-duplicates with all numbers. If first duplicate found, return true.
    Set<Integer> allNumbers = new HashSet<>();
    for (int i : input) {
      if (allNumbers.contains(i)) {
        return true;  // duplicate found
      } else {
        allNumbers.add(i);
      }
    }
    return false; // No duplicates
  }

}