package oopFundamentals;

/**
 * @author prachi.shah
 * @date 3/4/17
 * @concept Interface in Java. A class can extend only one class (Inheritance)
 *          but, can implement any number of interfaces (Multiple Inheritance).
 *          Interface can only have abstract methods it it.
 * @program Interface Example. This class implements two interfaces.
 * @study http://beginnersbook.com/2013/05/java-interface/
 * @note Abstract class vs. Interface:
 *       http://beginnersbook.com/2013/05/abstract-class-vs-interface-in-java/
 * @codeExample1 Interface InterfaceA extends InterfaceB { //methods }
 * @codeExample2 interface MainInterface extends inter1, inter2, inter3 {
 *               //methods }
 */
class Interfaces implements InterfaceA, InterfaceB {
	public static void main(String args[]) {
		// reference to x is ambiguous both the interfaces have the same one
		// variables called x
		// System.out.println(x); // Compile time warning: " The filed x is
		// ambiguous"
		System.out.println("Directly access variable of InterfaceA: X: " + InterfaceA.X);
		System.out.println("Directly access variable of InterfaceB: Y: " + InterfaceB.Y);

		Interfaces in = new Interfaces();
		// Because these two methods are defined in this class, they will need
		// to be called by creating an object of this class.
		in.returnX();
		in.returnY();
	}

	// Needs to implement all methods of InterfaceA
	// Method is now DEFINED here.
	public void returnX() {
		System.out.println("Inside returnX() of InterfaceA: X: " + InterfaceA.X);
	}

	// Needs to implement all methods of InterfaceB
	// Method is now DEFINED here.
	public void returnY() {
		System.out.println("Inside returnY() of InterfaceB: Y: " + InterfaceB.Y);
	}
}
