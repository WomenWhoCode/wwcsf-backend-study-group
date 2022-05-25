package oopFundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author prachi.shah
 * @date 3/3/2017
 * @concept Checked and Unchecked Exception Handling 
 * @program Opens a file and reads it's contents.
 * @note Unchecked Exceptions: ArrayIndexOutOfBoundsException, NullPointerException
 * Occur at Runtime. Subclass of RuntimeException class. 
 * ----
 * Checked Exceptions:
 * Exception, IOException, FileNotFoundException Occur at Compile time. Subclass
 * of Exception class.
 * ----
 * Hierarchy of Exception calling: Object –> Throwable –> Exception –>
 * IOException –> FileNotFoundException
 * 
 */
public class CheckedExceptionHandling {

	public FileInputStream initializeFile() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					"/Users/prachi.shah/Documents/workspace/ps/OOD/src/main/java/oopFundamentals/mytext.txt");

		} catch (FileNotFoundException fe) {	// Checked Exception. Has a try and catch block.
			System.out.println("Error reading a file. " + fe.getMessage());
		}
		return fis;
	}

	public static void main(String args[]) {

		CheckedExceptionHandling ueh = new CheckedExceptionHandling();
		int k;

		FileInputStream fis = ueh.initializeFile();

		try {
			if (fis != null) {
				System.out.println("Starting:");
				while ((k = fis.read()) != -1) { // Not reached end of file.
					System.out.print(Character.toChars(k));	// Reads every character in the file.
				}
				fis.close();
			}
		} catch (IOException e) {	// Checked Exception. Has a try and catch block.
			System.out.println("Problem reading the file due to some IO Exception.");
		}
	}
}
