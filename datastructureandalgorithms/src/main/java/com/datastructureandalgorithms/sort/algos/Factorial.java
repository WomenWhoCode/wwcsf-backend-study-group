package coding.problems;

/**
 * Recursion
 * https://www.javatpoint.com/recursion-in-java
 * Factorial of 5
 * n!=n * n-1    OR
 * n!=n×(n−1)×(n−2)×…×2×1
 * If n is 1, the factorial of n is 1
 *
 * @author prachi.shah
 */
/* 
 Syntax:
	return_type method_name()
	{  
		//code logic to be executed  
		method_name(); //calling same method
	}  
*/
public class Factorial {

    public static void main(String[] args) {
        System.out.println("Factorial of 6 is: " + getFactorialRecursively(6)); // 720
        System.out.println("Factorial of 6 is: " + getFactorialIteratively(6));
    }

    private static int getFactorialRecursively(int number) {
        if (number == 0) {  // Base case/end condition
            return 0;
        }
        if (number == 1) {  // Base case/end condition
            return 1;
        }
        return (number * getFactorialRecursively(number - 1));    //calling same method
    }

    private static int getFactorialIteratively(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        int factorial = 1;
        while (number != 1) {
            factorial *= number;
            number--;
        }
        return factorial;
    }

}

/* Working:
factorial(5) 
   factorial(4) 
      factorial(3) 
         factorial(2) 
            factorial(1) 
               return 1 
            return 2*1 = 2 
         return 3*2 = 6 
      return 4*6 = 24 
   return 5*24 = 120 
 */
/*
 * OUTPUT:
 * 5
 * 4
 * 3
 * 2
 * Factorial of 5 is: 120
 */
