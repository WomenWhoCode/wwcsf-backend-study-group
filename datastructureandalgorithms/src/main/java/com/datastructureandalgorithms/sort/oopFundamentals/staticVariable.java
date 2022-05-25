package oopFundamentals;

/**
 * @author prachi.shah
 * @date 3/3/17
 * @concept Static Variable.
 * @program Display static variable values.
 */
class staticVariable {

	static String helloWorld; // Static variable does not need initialization
	final static String byeWorld = "Bye, World!"; // final static variable needs
													// initialization
	public int luckyNumber;

	// Setters and Getters
	// No getter and setter for static variable as it can be set at any time
	// without creating object of the class.
	public int getLuckyNumber() {
		return luckyNumber;
	}

	public void setLuckyNumber(int luckyNumberValue) {
		luckyNumber = luckyNumberValue;
	}

	public static void main(String args[]) {

		// Create object of the class
		staticVariable newStaticClass = new staticVariable();

		// Static variable so does not need an object to initialize and set it's
		// value
		helloWorld = "Hello, World!";

		newStaticClass.setLuckyNumber(3);

		// Print values
		System.out.println("Static variable: " + helloWorld);
		System.out.println("final Static variable: " + byeWorld);
		System.out.println("Non-static variable: " + newStaticClass.getLuckyNumber());
	}
}
