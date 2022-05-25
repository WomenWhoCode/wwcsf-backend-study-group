package com.wwcodesf.backendstudygroup.codedebugging;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author prachi.shah Leetcode: https://leetcode.com/problems/replace-words/ In English, we have a
 * concept called root, which can be followed by some other word to form another longer word - let's
 * call this word successor. For example, when the root "an" is followed by the successor word
 * "other", we can form a new word "another". Given a dictionary consisting of many roots and a
 * sentence consisting of words separated by spaces, replace all the successors in the sentence with
 * the root forming it. If a successor can be replaced by more than one root, replace it with the
 * root that has the shortest length. Return the sentence after the replacement. Example 1: Input:
 * dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery" Output: "the
 * cat was rat by the bat" Example 2: Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs
 * bbab cadsfafs" Output: "a a b c"
 */
public class ReplaceWords {

  public static void main(String[] args) {
    ReplaceWords replaceWords = new ReplaceWords();
    Set<String> cat = new HashSet<>(); // Root words
    cat.add("cat");
    cat.add("bat");
    cat.add("rat"); //Output: "the cat was rat by the bat"
    Set<String> a = new HashSet<>();
    a.add("a");
    a.add("b");
    a.add("c"); // Output: "a a b c"
    String sentenceCat = "the cattle was rattled by the battery";
    String sentenceA = "aadsfasf absbs bbab cadsfafs";
    System.out.println(replaceWords.replaceWords(cat, sentenceCat));
    System.out.println(replaceWords.replaceWords(a, sentenceA));

    List<String> car = new ArrayList<>(); // Root words
    car.add("cat");
    car.add("bat");
    car.add("ba");
    car.add("rat"); //Output: "the cat was rat by the ba"
    System.out.println(replaceWords.replaceWordsWithTrie(car, sentenceCat));
  }

  public String replaceWords(Set<String> dictionary, String sentence) {
    if (dictionary == null || sentence == null || sentence.isEmpty()) {
      System.out.println("Error replacing words in the sentence. Please enter correct input");
      return sentence;
    }
    // Dictionary equals root words
    // Match prefix/successor in each work and replace the word with just the matching root
    // If shortest root found then replace with the shortest root
    // Iterate through every word in the sentence
    // Iterate through every character in each word to find the shortest root to prefix matched
    // Then replace the word with the root.
    // Assumption: The sentence has spaces and alphabets only.
    StringBuilder result = new StringBuilder();
    for (String word : sentence.split("\\s+")) { // Split sentence by spaces.
      String prefix = "";
      for (int i = 1; i <= word.length(); ++i) {
        prefix = word.substring(0, i);
        if (dictionary.contains(prefix)) {
          break;  // Done with this word. Move-on to next word
        }
      }
      if (result.length() > 0) {
        result.append(" ");
      }
      result.append(prefix);
    }
    return result.toString();
  }

  public String replaceWordsWithTrie(List<String> dictionary, String sentence) {
    TrieNode trie = new TrieNode();

    for (String root : dictionary) {
      TrieNode currentNode = trie;
      for (Character letter : root.toCharArray()) {
        if (currentNode.childrenNodes[letter - 'a'] == null) {
          currentNode.childrenNodes[letter - 'a'] = new TrieNode();
        }
        currentNode = currentNode.childrenNodes[letter - 'a'];
      }
      currentNode.word = root;
    }

    StringBuilder result = new StringBuilder();
    for (String word : sentence.split("\\s+")) {
      if (result.length() > 0) {
        result.append(" ");
      }

      TrieNode currentNode = trie;
      for (char letter : word.toCharArray()) {
        if (currentNode.childrenNodes[letter - 'a'] == null || currentNode.word != null) {
          break;
        }
        currentNode = currentNode.childrenNodes[letter - 'a'];
      }
      result.append(currentNode.word != null ? currentNode.word : word);
    }
    return result.toString();
  }

  public static class TrieNode {

    public String word;
    public TrieNode[] childrenNodes;

    // Initialize/create a node
    public TrieNode() {
      this.childrenNodes = new TrieNode[26];  // 26-characters in English Alphabet so 26 possibilities of that word
    }

    // Initialize/create a node
    public TrieNode(String word) {
      this.word = word;
      this.childrenNodes = new TrieNode[26];  // 26-characters in English Alphabet so 26 possibilities of that word
    }
  }

}