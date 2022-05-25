package oopFundamentals;

/**
 * @author prachi.shah
 * @date 3/4/2017
 * @concept Inner Class example: Access variables of an Outer Class via instance of an
 * Inner Class.
 * @program This class display an integer via an inner class object instance.
 */
public class OuterClass { // Outer Class

	// Can be accessed by Inner class
	private String outerClassString = "I am a private String variable in the Outer class.";

	// Can be accessed by Inner class
	public boolean returnTrue() {
		return true;
	}

	// Creates an instance of Inner Class.
	public InnerClass createInnerClassInstance() {
		InnerClass inc = new InnerClass();
		return inc;
	}

	//////// Inner Class
	class InnerClass {

		private String innerClassString = "I am a private String variable of the Inner Class.";

		// Inner class method can access variable of outer class, private
		// variables as well.
		public void returnOuterClassString() {
			System.out.println(outerClassString);
		}

		// Can access Outer class methods
		public void returnTrueOuterClass() {
			System.out.println(true);
		}

		// Inner class method
		public void sumOfNumbers(int numberOne, int numberTwo) {
			if (numberOne > 0 && numberOne < Integer.MAX_VALUE && numberTwo > 0 && numberTwo < Integer.MAX_VALUE) {
				System.out.println(numberOne + numberTwo);
			}
		}

		// Inner class method
		public void returnInnerClassString() {
			System.out.println(innerClassString);
		}
	}

	public static void main(String args[]) {

		////// Method 1: Created an instance of Inner Class
		OuterClass.InnerClass ic = new OuterClass().new InnerClass();

		// Inner class object accessed method of Outer Class.
		ic.returnTrueOuterClass();
		// Inner class object accessed method and private variable of Outer
		// Class.
		ic.returnOuterClassString();

		// Inner class own method being called here.
		ic.sumOfNumbers(1, 2);

		////// Method 2: Created an instance of Inner Class
		OuterClass oc = new OuterClass();

		// Methods creates an instance of the Inner Class
		InnerClass inC = oc.createInnerClassInstance();
		// Inner class method called.
		inC.returnInnerClassString();
	}
}
