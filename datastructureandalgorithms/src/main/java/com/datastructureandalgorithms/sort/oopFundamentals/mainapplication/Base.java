package com.mainapplication;

/* Java program to show that if static method is redefined by
a derived class, then it is not overriding. 
https://www.geeksforgeeks.org/can-we-overload-or-override-static-methods-in-java/
//Related to class Test

*/

//Superclass
class Base {

	// Static method in base class which will be hidden in subclass
	public static void display() {
		System.out.println("Static or class method from Base");
	}

	// Non-static method which will be overridden in derived class
	public void print() {
		System.out.println("Non-static or Instance method from Base");
	}
}

// Subclass
class Derived extends Base {

	// This method hides display() in Base
	public static void display() {
		System.out.println("Static or class method from Derived");
	}

	// This method overrides print() in Base
	public void print() {
		System.out.println("Non-static or Instance method from Derived");
	}
}
