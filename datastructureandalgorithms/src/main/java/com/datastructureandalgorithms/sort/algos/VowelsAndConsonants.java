package data.structures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VowelsAndConsonants {

    public static void main(String[] args) {
        VowelsAndConsonants findVowelsAndConsonants = new VowelsAndConsonants();
        String hello = "HellO";
        String mouse = " there is a quiet Mouse";
        String happy = " I am happy ";

        findVowelsAndConsonants.countVowelsAndConsonants(hello);
        findVowelsAndConsonants.countVowelsAndConsonants(mouse);
        findVowelsAndConsonants.countVowelsAndConsonants(happy);
    }

    private void countVowelsAndConsonants(String sentence) {
        int countOfVowels = 0;
        int countOfConsonants = 0;
        String vowels = "aeiouy";
        String normalizedSentence = sentence.trim().toLowerCase();
        char[] sentenceCharacters = normalizedSentence.toCharArray();   // Contains space between words

        for (char ch : sentenceCharacters) {
            if (vowels.indexOf(ch) != -1) { // Character exists in vowels
                countOfVowels++;
            } else if (ch != ' ') { // Character is not a space between words in the sentence
                countOfConsonants++;
            }
        }

        System.out.println("There are " + countOfVowels + " Vowels in: " + sentence);
        System.out.println("There are " + countOfConsonants + " Consonants in: " + sentence);


// Count and print vowels and consonants
//        char[] sentenceCharacters = sentence.trim().replace(" ", "").toLowerCase().toCharArray();
//        HashMap<Integer, Character> allVowels = new HashMap<>();    // char at index
//        HashMap<Integer, Character> allConsonants = new HashMap<>();    // char at index
//        int countOfVowels = 0;
//        int countOfConsonants = 0;
//
//        System.out.println(Arrays.toString(sentenceCharacters));
//
//        for (int i = 0; i < sentenceCharacters.length; i++) {   // hello
//            for (char ch : vowels)  // a e i o u y
//                if (sentenceCharacters[i] == ch) {
//                    countOfVowels++;
//                    allVowels.put(i, sentenceCharacters[i]);
//                }
//        }
//
//        // Count and populate consonants
//        countOfConsonants = sentenceCharacters.length - countOfVowels;
//        for (int i = 0; i < sentenceCharacters.length; i++) {
//            if (!allVowels.containsKey(i)) {
//                allConsonants.put(i, sentenceCharacters[i]);
//            }
//        }
//
//        System.out.println("Vowels: " + allVowels.toString());
//        System.out.println("Consonants: " + allConsonants.toString());
//        return new int[]{countOfVowels, countOfConsonants};
//    }

    }
}
