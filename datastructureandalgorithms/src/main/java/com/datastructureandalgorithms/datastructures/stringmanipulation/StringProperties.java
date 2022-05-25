package com.datastructureandalgorithms.datastructures;

/**
 * Is String Lowercase or Uppercase.
 * Is String Lowercase or Uppercase.
 * Does String contains No Uppercase.
 * Does String contains all Letters.
 * Does String contains all Digits.
 * Is String Alphanumeric.
 */
public class StringProperties {

  public static void main(String[] args) {
    StringProperties stringProperties = new StringProperties();
    String hello = "hello";
    String Hello = "Hello";
    String heLLo = "heLLo";
    String HELLO = "HELLO";
    String allLetters = "allLetters";
    String allDigits = "1234567890";
    String alphanumeric = "alphanumeric1111";
    String alphaNumeric = "alphaNumeric2222";
    System.out.println("Is String Lowercase:");
    System.out.println(stringProperties.isStringLowercase(hello));
    System.out.println(stringProperties.isStringLowercase(Hello));
    System.out.println(stringProperties.isStringLowercase(heLLo));
    System.out.println(stringProperties.isStringLowercase(HELLO));
    System.out.println("Is String Uppercase:");
    System.out.println(stringProperties.isStringUppercase(hello));
    System.out.println(stringProperties.isStringUppercase(Hello));
    System.out.println(stringProperties.isStringUppercase(heLLo));
    System.out.println(stringProperties.isStringUppercase(HELLO));
    System.out.println("Does String contains no Uppercase:");
    System.out.println(stringProperties.doesStringContainsNoUppercase(hello));
    System.out.println(stringProperties.doesStringContainsNoUppercase(Hello));
    System.out.println(stringProperties.doesStringContainsNoUppercase(heLLo));
    System.out.println(stringProperties.doesStringContainsNoUppercase(HELLO));
    System.out.println("Does String contains all letters:");
    System.out.println(stringProperties.doesStringContainsAllLetters(allLetters));
    System.out.println(stringProperties.doesStringContainsAllLetters(allDigits));
    System.out.println(stringProperties.doesStringContainsAllLetters(alphanumeric));
    System.out.println(stringProperties.doesStringContainsAllLetters(alphaNumeric));
    System.out.println("Does String contains all digits:");
    System.out.println(stringProperties.doesStringContainsAllDigits(allDigits));
    System.out.println(stringProperties.doesStringContainsAllDigits(allLetters));
    System.out.println(stringProperties.doesStringContainsAllDigits(alphanumeric));
    System.out.println(stringProperties.doesStringContainsAllDigits(alphaNumeric));
    System.out.println("Does String contains some letters and some digits:");
    System.out.println(stringProperties.doesStringContainsAlphanumeric(allDigits));
    System.out.println(stringProperties.doesStringContainsAlphanumeric(allLetters));
    System.out.println(stringProperties.doesStringContainsAlphanumeric(alphanumeric));
    System.out.println(stringProperties.doesStringContainsAlphanumeric(alphaNumeric));
  }

  private boolean isStringLowercase(String input) {
    return input.chars().allMatch(Character::isLowerCase);
  }

  private boolean isStringUppercase(String input) {
    return input.chars().allMatch(Character::isUpperCase);
  }

  private boolean doesStringContainsNoUppercase(String input) {
    return input.chars().noneMatch(Character::isUpperCase);
  }

  private boolean doesStringContainsAllLetters(String input) {
    return input.chars().allMatch(Character::isLetter);
  }

  private boolean doesStringContainsAllDigits(String input) {
    return input.chars().allMatch(Character::isDigit);
  }

  private boolean doesStringContainsAlphanumeric(String input) {
    return input.chars().allMatch(Character::isLetterOrDigit);
  }

}