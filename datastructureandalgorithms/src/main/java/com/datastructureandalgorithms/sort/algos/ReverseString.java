package data.structures;

import coding.problems.ReverseSentence;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverse = new ReverseString();
        String sentence = "Interviews are hard and tough";
        System.out.println(reverse.reverseWordRecursively(sentence));
    }

    private String reverseWordRecursively(String word) {
        // Base case to handle one char string and empty string
        if (word.length() < 2) {
            return word;
        }
        return reverseWordRecursively(word.substring(1)) + word.charAt(0);
    }

}
