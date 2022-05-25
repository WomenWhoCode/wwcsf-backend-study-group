package oopFundamentals;

/**
 * @author prachi.shah
 * @date 3/4/2017
 * @concept Abstract Class. Can have both concrete and abstract methods in it.
 * @program An Abstract class can be inherited by a class or an abstract class
 * @study http://beginnersbook.com/2013/05/abstract-class-vs-interface-in-java/
 */
public class AbstractClasses {
	public static void main(String args[]) {
		Example4 obj = new Example4();

		System.out.println("Concrete class Example4 extends only one Abstract class Example3.");
		obj.displayExample2_1();
		obj.displayExample2_2();
		obj.displayExample3();
	}
}

/** Concrete Class */
class Example1 {
	public void displayExample1() {
		System.out.println("displayExample1()");
	}
}

/**
 * Abstract Class: Abstract class can have both abstract and concrete methods
 */
abstract class Example2 {
	// Concrete method defined.
	public void displayExample2_1() {
		System.out.println("displayExample2()");
	}

	// Abstract method declared. Needs to be compulsorily defined in the class that extends this abstract class.
	abstract public void displayExample2_2();
}

/**
 * An Abstract class can extend only ONE concrete/Abstract class at a time.
 * Here, Abstract class Example3 extends another Abstract class Example2
 */
abstract class Example3 extends Example2 {
	abstract void displayExample3();
}

/**
 * Concrete class Example4 extends only one Abstract class Example3. Since,
 * Example3 extends another abstract class called Example2, so Example4 class
 * needs to implement methods from both these abstract classes (Example3 and
 * Example4 are both Abstract classes.) A class can only extend one class.
 * 
 * @note Concrete class Example4 extends only one Abstract class Example3.
 */
class Example4 extends Example3 {

	public void displayExample2_1() {
		System.out.println("Example4 class -> concrete method displayExample2_1() of Example2 abstract class.");
	}

	public void displayExample3() {
		System.out.println("Example4 class -> displayExample3() of Example3 abstract class.");
	}

	// Defined abstract method displayExample2_2() of abstract class Example2
	// Abstract methods need to be explicitly overriden. That why, there is an @Override annotation to thsi method definition.
	@Override
	public void displayExample2_2() {
		System.out.println("Example4 class -> abstract method displayExample2_2() of Example2 abstract class.");
	}
}
