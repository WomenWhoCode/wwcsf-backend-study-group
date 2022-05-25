package com.datastructureandalgorithms.algorithms.leetcode;

import java.util.stream.Stream;

/**
 * @author prachi.shah Leetcode: https://leetcode.com/problems/valid-palindrome/solution/ A phrase
 * is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters
 * include letters and numbers. Given a string s, return true if it is a palindrome, or false
 * otherwise. Example 1: Input: s = "A man, a plan, a canal: Panama" Output: true Explanation:
 * "amanaplanacanalpanama" is a palindrome. Example 2: Input: s = "race a car" Output: false
 * Explanation: "raceacar" is not a palindrome. Example 3: Input: s = " " Output: true Explanation:
 * s is an empty string "" after removing non-alphanumeric characters. Since an empty string reads
 * the same forward and backward, it is a palindrome.
 */
public class ValidPalindrome {

  public static void main(String[] args) {
    ValidPalindrome validPalindrome = new ValidPalindrome();
    // "amanaplanacanalpanama"
    System.out.println(validPalindrome.isPalindromeReversed("A man, a plan, a canal: Panama"));
    System.out.println(validPalindrome.isPalindromeReversed("race a car")); // "raceacar"
    System.out.println(validPalindrome.isPalindromeJavaStreams("A man, a plan, a canal: Panama"));
    System.out.println(validPalindrome.isPalindromeJavaStreams("race a car"));
    System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(validPalindrome.isPalindrome("race a car"));
    System.out.println(validPalindrome.isPalindrome(" "));  // Is a palindrome
  }

  public boolean isPalindromeReversed(String input) {
    StringBuilder sbInput = new StringBuilder();
    for (char character : input.toCharArray()) {
      if (Character.isLetterOrDigit(character)) {
        sbInput.append(Character.toLowerCase(character));
      }
    }
    String inputFiltered = sbInput.toString();
    String inputReversed = sbInput.reverse().toString();
    return inputFiltered.equals(inputReversed);
  }

  public boolean isPalindromeJavaStreams(String input) {
    // https://www.baeldung.com/java-string-to-stream
    StringBuilder sbInput = new StringBuilder();
    Stream<Character> characters = input.chars().mapToObj(ch -> (char) ch);
    characters.filter(Character::isLetterOrDigit).map(Character::toLowerCase)
        .forEach(sbInput::append);
    return sbInput.toString().equals(sbInput.reverse().toString());
  }

  public boolean isPalindrome(String input) {
    // Remove spaces. Check the string is alphanumeric. Change to lowercase and then compare.
    // Base cases
    if (input == null) {
      return false;   // null is not a palindrome
    } else if (input.isEmpty()) {
      return true;    // Empty string is a palindrome
    }

    // Compare with two pointers
    // Length of string is 21.
    int lowIndex = 0;
    int highIndex = input.length() - 1; // 20
    while (lowIndex < highIndex) {
      while (lowIndex < highIndex && !Character.isLetterOrDigit(input.charAt(lowIndex))) {
        lowIndex++; // To skip spaces and non-alphanumeric characters. Move the index forward
      }
      while (lowIndex < highIndex && !Character.isLetterOrDigit(input.charAt(highIndex))) {
        highIndex--; // To skip spaces and non-alphanumeric characters. Move the index forward
      }

      if (lowIndex < highIndex
          && Character.toLowerCase(input.charAt(lowIndex)) != Character.toLowerCase(
          input.charAt(highIndex))) {
        return false; // Compare and fail-fast if not a palindrome
      }
      lowIndex++; // Increment to check next character
      highIndex--; // Decrement to check next character
    }
    return true;  // Its  palindrome
  }

}