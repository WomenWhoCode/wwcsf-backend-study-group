package coding.problems;

public class PalindromeReverse {

    public static void main(String[] args) {
        PalindromeReverse pal = new PalindromeReverse();
        String bob = "bob";
        String bobo = "bobo";
        String palindromeamordnilap = "palindromeamordnilap";
        String palindromeemordnilap = "palindromeemordnilap";
        String oboobo = "oboobo";
        String obobo = "obobo";
        String oboebo = "oboebo";

        System.out.println("\nString Builder: Reverse():");

        System.out.println(pal.getPalindromeStringBuilder(bob));  // true
        System.out.println(pal.getPalindromeStringBuilder(bobo)); // false
        System.out.println(pal.getPalindromeStringBuilder(palindromeamordnilap)); // false
        System.out.println(pal.getPalindromeStringBuilder(palindromeemordnilap)); // true
        System.out.println(pal.getPalindromeStringBuilder(oboobo)); // true
        System.out.println(pal.getPalindromeStringBuilder(obobo)); // true
        System.out.println(pal.getPalindromeStringBuilder(oboebo)); // false

        System.out.println("\nString Builder: Iteratively:");

        System.out.println(pal.getPalindromeStringBuilderIteratively(bob));  // true
        System.out.println(pal.getPalindromeStringBuilderIteratively(bobo)); // false
        System.out.println(pal.getPalindromeStringBuilderIteratively(palindromeamordnilap)); // false
        System.out.println(pal.getPalindromeStringBuilderIteratively(palindromeemordnilap)); // true
        System.out.println(pal.getPalindromeStringBuilderIteratively(oboobo)); // true
        System.out.println(pal.getPalindromeStringBuilderIteratively(obobo)); // true
        System.out.println(pal.getPalindromeStringBuilderIteratively(oboebo)); // false


        System.out.println("\nRecursion:");

        System.out.println(pal.getPalindromeRecursive(bob, 0, bob.length() - 1));  // true
        System.out.println(pal.getPalindromeRecursive(bobo, 0, bobo.length() - 1)); // false
        System.out.println(pal.getPalindromeRecursive(palindromeamordnilap, 0, palindromeamordnilap.length() - 1));
        // false
        System.out.println(pal.getPalindromeRecursive(palindromeemordnilap, 0, palindromeemordnilap.length() - 1));
        // true
        System.out.println(pal.getPalindromeRecursive(oboobo, 0, oboobo.length() - 1)); // true
        System.out.println(pal.getPalindromeRecursive(obobo, 0, obobo.length() - 1)); // true
        System.out.println(pal.getPalindromeRecursive(oboebo, 0, oboebo.length() - 1)); // false
    }

    private boolean getPalindromeStringBuilder(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    private boolean getPalindromeStringBuilderIteratively(String word) {
        StringBuilder reversedString = new StringBuilder(word.length());
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedString.append(word.charAt(i));
        }
        return word.equals(reversedString.toString());
    }

    private boolean getPalindromeRecursive(String word, int forward, int backward) {
        char[] wordToChar = word.toCharArray();
        // Provide 0 and length-1 index values; Compare till values ar both indexes are equal then return true else
        // return false.

        if (word.isEmpty() || word.length() == 1) { // Base case
            return false;
        }

        if (forward == backward) {  // String is of odd size
            return wordToChar[forward] == wordToChar[backward];
        }

        if (wordToChar[forward] != wordToChar[backward]) {
            return false;
        }

        if (forward < backward) {
            return getPalindromeRecursive(word, forward + 1, backward - 1);
        }

        if (backward == forward - 1) {  // Compare two characters in the middle of the string
            return wordToChar[backward] == wordToChar[forward];
        }
        return true;
    }

}
