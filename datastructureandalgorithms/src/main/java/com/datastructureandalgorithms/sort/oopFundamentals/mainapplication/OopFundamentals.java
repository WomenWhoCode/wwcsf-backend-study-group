package com.mainapplication;

import java.util.logging.Logger;

/* 
 * @author prachi.shah
 * @date 12-10-2017
 * Sample Class to show fields, instance variables, methods, class, object and constructor in Java.
 * This class is also the main class of the whole project and it's starting point.
 */
class OopFundamentals {
	
	static Logger log = Logger.getLogger(OopFundamentals.class.getName());

	// fields (or instance variable)
	int age;
	String name;
	
	// Parameterized constructor
	OopFundamentals(int myAge, String myName) {
		this.age = myAge;
		this.name = myName;
	}

	// constructor
	OopFundamentals() {
		this.age = 27;
		this.name = "Cat Woman";
	}

	// method
	public static void main(String[] args) {

		// object created
		OopFundamentals instanceFirst = new OopFundamentals(29, "Wonder Woman");
		// instance variable
		OopFundamentals instanceSecond = new OopFundamentals(28, "Super Woman");
		OopFundamentals instanceThird = new OopFundamentals();

		log.info(instanceFirst.age + " ; " + instanceFirst.name);
		log.info(instanceSecond.age + " ; " + instanceSecond.name);
		log.info(instanceThird.age + " ; " + instanceThird.name);
	}
}

/*
29 ; Wonder Woman
28 ; Super Woman
27 ; Cat Woman
 */
/* Mar 14, 2018 1:47:07 AM com.mainapplication.OopFundamentals main
INFO: 29 ; Wonder Woman
Mar 14, 2018 1:47:07 AM com.mainapplication.OopFundamentals main
INFO: 28 ; Super Woman
Mar 14, 2018 1:47:07 AM com.mainapplication.OopFundamentals main
INFO: 27 ; Cat Woman
*/