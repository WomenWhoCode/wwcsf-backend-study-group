package oopFundamentals;

/**
 * @author prachi.shah
 * @date 3/4/2017.
 * @program Prints an array of 10 integers.
 * @concept Checked and Unchecked Exception Handling
 * @note Unchecked Exceptions: ArrayIndexOutOfBoundsException, NullPointerException, ArithmeticException
 * Occur at Runtime. Subclass of RuntimeException class.
 * ----
 * Checked Exceptions: Exception, IOException, FileNotFoundException Occur at
 * Compile time. Subclass of Exception class.
 * ----
 * Casting: ClassCastException Arrays: ArrayIndexOutOfBoundsException,
 * NullPointerException Collections: NullPointerException, ClassCastException
 * (if you're not using auto-boxing and you screw it up) IO:
 * java.io.IOException, java.io.FileNotFoundException, java.io.EOFException
 * Serialization: java.io.ObjectStreamException (AND ITS SUBCLASSES, which I'm
 * too lazy to enumerate) Threads: InterruptedException, SecurityException,
 * IllegalThreadStateException Potentially common to all situations:
 * NullPointerException, IllegalArgumentException You would do well to look at
 * Java site's Package Summary pages. Here's one:
 * http://java.sun.com/j2se/1.4.2/docs/api/java/io/package-summary.html
 */
public class UnCheckedExceptionHandling {

	// Initialize array based on the size
	public int[] initializeListOfNumbers(int[] listOfNumbersNew, int size) {
		for (int i = 0; i < size; i++) {
			// Throws ArrayIndexOutOfBoundsException which is a Runtime
			// Exception, an Unchecked exception.
			listOfNumbersNew[i] = i + 1;
		}
		return listOfNumbersNew;
	}

	// Divides two integers. Will throw Unchecked exception:
	// java.lang.ArithmeticException: / by zero
	public int divideNumbers(int numberOne, int numberTwo) {
		int divideAnswer = numberOne / numberTwo;
		return divideAnswer;
	}

	public static void main(String args[]) {

		UnCheckedExceptionHandling eh = new UnCheckedExceptionHandling();

		int size = 10;
		int[] newListOfNumbers = new int[size];

		newListOfNumbers = eh.initializeListOfNumbers(newListOfNumbers, size);

		// Will throw NullPointerException which is an Unchecked exception, a
		// Runtime exception.
		// newListOfNumbers = null;

		// Print contents of the array int[]
		for (int i = 0; i < size; i++) {
			System.out.println(newListOfNumbers[i]);
		}

		// Divides two integers. Throws Unchecked exception:
		// java.lang.ArithmeticException: / by zero
		int divideAnswer = eh.divideNumbers(10, 0);
		System.out.println(divideAnswer);
	}
}
