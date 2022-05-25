package com.datastructureandalgorithms.datastructures.arrays;

import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author prachi.shah https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 * Write a program to reverse an array or string. Given an array (or string), the task is to reverse
 * the array/string. Input: arr[] = {1, 2, 3} Output : arr[] = {3, 2, 1} Input: arr[] = {4, 5, 1, 2}
 * Output : arr[] = {2, 1, 5, 4}
 */
public class ReverseArray {

  private static final Logger log = LoggerFactory.getLogger(ReverseArray.class);

  // Constructor
  public ReverseArray() {
  }

  // Time Complexity: O(n). Space Complexity: O(n)
  public String[] reverseArrayWitCollection(String[] inputArray) {
    Collections.reverse(java.util.Arrays.asList(inputArray));
    return inputArray;
  }

  // Time Complexity: O(n). Space Complexity: O(n)
  public void reverseArrayWithRecursion(String[] inputArray, int startIndex, int endIndex) {

    if (startIndex >= endIndex) {
      return;
    }
    String temp = inputArray[startIndex];
    inputArray[startIndex] = inputArray[endIndex];
    inputArray[endIndex] = temp;
    reverseArrayWithRecursion(inputArray, startIndex + 1, endIndex - 1);
  }

  // Time Complexity: O(n). Space Complexity: O(n)
  public String[] reverseArrayWithSwapping(String[] inputArray) {

    int startIndex = 0;
    int endIndex = inputArray.length - 1;

    while (startIndex < endIndex) {
      String temp = inputArray[startIndex];
      inputArray[startIndex] = inputArray[endIndex];
      inputArray[endIndex] = temp;
      startIndex++;
      endIndex--;
    }
    return inputArray;
  }

  // Time Complexity: O(n). Space Complexity: O(2n) = O(n)
  public String[] reverseArrayWithExtraStorage(String[] inputArray) {

    // create auxiliary array of same size as inputArray
    String[] outputArray = new String[inputArray.length];

    int endIndexOfOutputArray = 0;
    for (int i = inputArray.length - 1; i >= 0; i--) {
      outputArray[endIndexOfOutputArray] = inputArray[i];
      endIndexOfOutputArray++;
    }
    return outputArray;
  }

  public List<String> printInputArrayAsList(String[] inputArray) {
    return java.util.Arrays.asList(inputArray);
  }

  public void printInputArray(String[] inputArray) {
    for (String s : inputArray) {
      System.out.printf(s);
    }
  }
}