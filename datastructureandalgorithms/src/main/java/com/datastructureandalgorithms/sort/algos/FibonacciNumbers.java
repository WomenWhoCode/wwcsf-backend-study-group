package coding.problems;

import java.util.logging.Logger;

/*
 * The Fibonacci numbers are the numbers in the following integer sequence. 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,
 * 144, ...
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
 * Fn = Fn-1 + Fn-2
 * with seed values, F0 = 0 and F1 = 1.
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *
 * Recursion https://www.javatpoint.com/recursion-in-java Fibonacchi of 4
 * numbers Xn = X(n-1) + X(n-2)
 *
 * static int number1 = 0, number2 = 1, sum = 0; static void fibonacci(int
 * count) { //optimize the space used in method 2 by storing the previous two
 * numbers only because that is all we need to get the next Fibonacci number in
 * series. if (count > 0) { // base case/end condition sum = number1 + number2;
 * number1 = number2; number2 = sum;
 *
 * System.out.print(" " + sum); // print the sum/third number in the sequence
 *
 * fibonacci(count - 1); // calling same method } }

 * @author prachi.shah
 */
public class FibonacciNumbers {

    private static final Logger logger = Logger.getLogger(FibonacciNumbers.class.getName());

    public static void main(String[] args) {


        FibonacciNumbers fib = new FibonacciNumbers();
        logger.info("Fibonacci numbers using Recursion:");
        int num = fib.generateFibonacciNumberSequenceRecursion(9);
        logger.info(String.valueOf(num));
        logger.info("Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.");
        logger.info("Extra Space: O(n) if we consider the function call stack size, otherwise O(1).");

        logger.info("Fibonacci numbers using Dynamic Programming:");
        num = fib.generateFibonacciNumberSequenceDynamicProgramming(9);
        logger.info(String.valueOf(num));
        logger.info("Time Complexity: O(n)which is linear.");
        logger.info("Extra Space: O(n) if we consider the function call stack size, otherwise O(1).");

        logger.info("Fibonacci numbers using Dynamic Programming: Save Space: ");
        num = fib.generateFibonacciNumberSequenceDynamicProgrammingSpaceComplexity(9);
        logger.info(String.valueOf(num));
        logger.info("Time Complexity: O(n)which is linear.");
        logger.info("Extra Space: O(1).");
    }

    private int generateFibonacciNumberSequenceRecursion(int numberToPrint) {
        // numberToPrint is the position in the sequence, we want to print the number at
        // this position

        if (numberToPrint <= 1) {
            return numberToPrint;
        } else {
            return generateFibonacciNumberSequenceRecursion(numberToPrint - 1)
                    + generateFibonacciNumberSequenceRecursion(numberToPrint - 2);
        }
    }

    private int generateFibonacciNumberSequenceDynamicProgramming(int numberToPrint) {
        // numberToPrint is the position in the sequence, we want to print the number at
        // this position

        // Declare an array to store Fibonacci numbers.
        int num[] = new int[numberToPrint + 1]; // 1 extra to handle case, n = 0

        // 0th and 1st number of the series are 0 and 1
        num[0] = 0;
        num[1] = 1;

        for (int i = 2; i <= numberToPrint; i++) {
            // Add the previous 2 numbers in the series and store it
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[numberToPrint];
    }

    private int generateFibonacciNumberSequenceDynamicProgrammingSpaceComplexity(int numberToPrint) {
        // numberToPrint is the position in the sequence, we want to print the number at
        // this position

        // Declare an array to store Fibonacci numbers.
        int first = 0;
        int second = 1;
        int sum;

        if (numberToPrint == 0) {
            return numberToPrint;
        }

        for (int i = 2; i <= numberToPrint; i++) {
            // Add the previous 2 numbers in the series and store it
            sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

}
