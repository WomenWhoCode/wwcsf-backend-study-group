package com.datastructureandalgorithms.datastructures.stringmanipulation;

/**
 * Search a Character in String (Character(s) are case-sensitive).
 * Search a Character in a Normalized String (Character(s) are case-insensitive).
 * Search a Character in String (Iterate and check each Character).
 */
public class SearchCharacterInString {

  public static void main(String[] args) {
    SearchCharacterInString searchCharacterInString = new SearchCharacterInString();
    String hello = "Hello, Dear Friend";
    String bye = "Bye, Dear Friend";
    String seeYou = "See you, Dear Friend";
    System.out.print("Parse String Contents: ");
    searchCharacterInString.parseStringContents(seeYou);
    System.out.println("\nParse a Character in a String (Iterated):");
    searchCharacterInString.parseCharactersIterated(hello);
    searchCharacterInString.parseCharactersIterated(bye);
    searchCharacterInString.parseCharactersIterated(seeYou);
    System.out.println("\nSearch a Character in String:");
    System.out.println(searchCharacterInString.searchCharacters(hello, "h"));
    System.out.println(searchCharacterInString.searchCharacters(bye, "B"));
    System.out.println(searchCharacterInString.searchCharacters(seeYou, "Dear"));
    System.out.println("\nSearch a Character in a Normalized String:");
    System.out.println(searchCharacterInString.searchCharactersNormalized(hello, "h"));
    System.out.println(searchCharacterInString.searchCharactersNormalized(bye, "b"));
    System.out.println(searchCharacterInString.searchCharactersNormalized(seeYou, "dear"));
  }

  private void parseStringContents(String input) {
    for (char ch : input.toCharArray()) {
      System.out.print(ch);
    }
  }

  private boolean searchCharacters(String input, String character) {
    return input.contains(character);
  }

  private boolean searchCharactersNormalized(String input, String character) {
    return input.toLowerCase().contains(character);
  }


  private void parseCharactersIterated(String input) {
    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      System.out.print(ch);
    }
    System.out.println();
  }

}