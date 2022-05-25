package coding.problems;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ReverseSentence {
    public static void main(String[] args) {
        ReverseSentence reverseSentence = new ReverseSentence();
        String sentence = "Interviews are hard and tough";
        reverseSentence.reverseSentence(sentence);
        reverseSentence.reverseSentenceUsingCollections(sentence);
        System.out.println(reverseSentence.reverseWordRecursively(sentence));
    }

    private void reverseSentenceUsingCollections(String sentence) {
        List<String> words = new ArrayList<>(Arrays.asList(sentence.split("\\s")));

        Collections.reverse(words); // Reverses order of elements

        StringBuilder reversedSentence = new StringBuilder();
        for (String word : words) {
            reversedSentence.append(word);
            reversedSentence.append(" ");
        }

        System.out.println(reversedSentence.toString());
    }

    private void reverseSentence(String sentence) {
        String[] words = sentence.trim().split("\\s");
        StringBuilder reversedSentence = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]);
            reversedSentence.append(" ");
        }

        System.out.println(reversedSentence.toString());
    }

    private String reverseWordRecursively(String sentence) {
        //base case to handle one char string and empty string
        if (sentence.length() < 2) {
            return sentence;
        }
        return reverseWordRecursively(sentence.substring(1)) + sentence.charAt(0);
    }

}
