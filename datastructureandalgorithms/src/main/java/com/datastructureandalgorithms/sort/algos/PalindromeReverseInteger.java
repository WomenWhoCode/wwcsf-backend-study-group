package coding.problems;

public class PalindromeReverseInteger {

    public static void main(String[] args) {
        PalindromeReverseInteger pal = new PalindromeReverseInteger();
        pal.isPalindrome(131);
        pal.isPalindrome(132);
    }

    private void isPalindrome(int number) {
        int palindrome = number;
        int reverse = 0;

        // calculate the reverse
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // compare number and reverse
        if (number == reverse) {
            System.out.println(number + " is a Palindrome");
        } else {
            System.out.println(number + " is not a Palindrome");
        }
    }

}
