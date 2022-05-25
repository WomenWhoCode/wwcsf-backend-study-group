package com.datastructureandalgorithms.algorithms.dynamicprogramming;

/**
 * @author prachi.shah
 * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/m2G1pAq0OO0
 */
public class FibonacciSeries {

  public int calculateFibonacciMemoization(int n) {
    int[] memoize = new int[n + 1];
    int result = calculateFibonacciRecursiveTopDownWithMemoization(memoize, n);
    for (int value : memoize) {
      System.out.print(value + " ");
    }
    System.out.print(". ");
    return result;
  }

  // Top-down approach
  public int calculateFibonacciRecursiveTopDownWithMemoization(int[] memoize, int n) {
    if (n < 2) { // if (n == 0 || n == 1) { return n; }
      return n;
    }

    // if we have already solved this sub-problem, simply return the result from the cache
    if (memoize[n] != 0) {
      return memoize[n];
    }

    memoize[n] = calculateFibonacciRecursiveTopDownWithMemoization(memoize, n - 1)
        + calculateFibonacciRecursiveTopDownWithMemoization(memoize, n - 2);
    return memoize[n];  // final result
  }

  // Bottom-Up approach
  public int calculateFibonacciNonRecursive(int n) {
    // base case
    if (n == 0 || n == 1) {
      return n;
    }

    int[] fibonacciSeries = new int[n + 1]; // initialized to 0

    // base case
    fibonacciSeries[0] = 0;
    fibonacciSeries[1] = 1;

    for (int i = 2; i <= n; i++) {
      fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
    }
    for (int value : fibonacciSeries) {
      System.out.print(value + " ");
    }
    System.out.print(". ");
    return fibonacciSeries[n];
  }

  public static void main(String[] args) {
    FibonacciSeries fibonacci = new FibonacciSeries();
    System.out.println("5th Fibonacci is ---> " + fibonacci.calculateFibonacciMemoization(5));
    System.out.println("6th Fibonacci is ---> " + fibonacci.calculateFibonacciMemoization(6));
    System.out.println("7th Fibonacci is ---> " + fibonacci.calculateFibonacciMemoization(7));

    System.out.println("5th Fibonacci is ---> " + fibonacci.calculateFibonacciNonRecursive(5));
    System.out.println("6th Fibonacci is ---> " + fibonacci.calculateFibonacciNonRecursive(6));
    System.out.println("7th Fibonacci is ---> " + fibonacci.calculateFibonacciNonRecursive(7));
  }

}