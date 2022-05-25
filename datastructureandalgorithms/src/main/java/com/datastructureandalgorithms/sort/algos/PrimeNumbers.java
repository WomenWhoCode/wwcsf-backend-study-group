package coding.problems;

/*
Prime Numbers: 2 3 5 7 11 13 ...
Only divisible by 1 or itself
Check if a number is prime or not.
https://www.java67.com/2014/01/how-to-check-if-given-number-is-prime.html
 */
public class PrimeNumbers {

    public static void main(String[] args) {
        PrimeNumbers pn = new PrimeNumbers();
        System.out.println(pn.getPrimeNumbers(0));  // false
        System.out.println(pn.getPrimeNumbers(2));  // true
        System.out.println(pn.getPrimeNumbers(6));  // false
        System.out.println(pn.getPrimeNumbers(7));  // true
        System.out.println(pn.getPrimeNumbers(53)); // true
    }

    private boolean getPrimeNumbers(int number) {
        if (number <= 1) {  // Not prime numbers
            System.out.println("Not a prime number: " + number);
            return false;
        }

        if (number == 2 || number == 3) {   // Prime
            System.out.println("First couple prime number: " + number);
            return true;
        }

        if (number % 2 == 0) {  // Divisible by 2
            System.out.println("Divisible by 2 so, not a prime number: " + number);
            return false;
        }

        for (int i = 3; i <= number / 2; i += 2) {    // Divide by Odd numbers only, since divide by 2 covers all
            // even numbers.
            System.out.println("Is Prime: " + number);
            return number % i != 0;
        }
        return false;
    }

}
