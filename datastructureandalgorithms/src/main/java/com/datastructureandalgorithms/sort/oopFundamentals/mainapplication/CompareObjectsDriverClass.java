package com.mainapplication;

// Driver class to test the Complex class
public class CompareObjectsDriverClass {

	public static void main(String[] args) {
		CompareObjects c1 = new CompareObjects(10, 15);
		CompareObjects c2 = new CompareObjects(10, 15);
		if (c1.equals(c2)) {
			System.out.println("Equal ");
		} else {
			System.out.println("Not Equal ");
		}
	}
}

/* Output: Equal */