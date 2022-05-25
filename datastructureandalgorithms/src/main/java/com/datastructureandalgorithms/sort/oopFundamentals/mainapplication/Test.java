package com.mainapplication;

//https://www.geeksforgeeks.org/can-we-overload-or-override-static-methods-in-java/ 
//Related to class Base

//Driver class
public class Test {
	public static void main(String args[]) {
		Base obj1 = new Derived();

		// As per overriding rules this should call to class Derived's static
		// overridden method. Since static method can not be overridden, it
		// calls Base's display()
		Base.display();

		// Here overriding works and Derive's print() is called
		obj1.print();
	}
}
/* OUTPUT:
Static or class method from Base
Non-static or Instance method from Derived
*/