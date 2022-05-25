package com.mainapplication;

/**
 * Private Constructor
 * Used to create Singleton object only
 * https://beginnersbook.com/2013/12/java-private-constructor-example/
 * 
 * @author prachishah
 *
 */
public class PrivateConstructor {

	//Static Class Reference
	private static PrivateConstructor object = null;
	public int num = 10;

	// Private Constructor will prevent the instantiation of this class directly
	private PrivateConstructor() {
	}

	
	public static PrivateConstructor createSingletonObject() {

		//This logic will ensure that no more than one object can be created at a time
		if (object == null) {
			object = new PrivateConstructor();
		}
		return object;
	}

	public void display() {
		System.out.println("Singleton Object Created. number: " + num);
	}

	public static void main(String[] args) {
		
		/* Object cannot be created directly due to private constructor 
		 * This way it is forced to create object via our method where 
		 * we have logic for only one object creation */
		PrivateConstructor newObject1 = PrivateConstructor.createSingletonObject();
		newObject1.num = newObject1.num + 10; 	//20
		newObject1.display();
		
		// We changed value of newObject1.num, then value of newObject3.num also got updated because
		// both ‘newObject1’ and ‘newObject3’ refer to same one object, i.e., they are objects of a singleton class.
		PrivateConstructor newObject3 = PrivateConstructor.createSingletonObject();
		newObject3.display();
		
		/*This will work but it should not be allowed. you force only one object creation using the createSingletonObject()
		PrivateConstructor newObject2 = new PrivateConstructor();
		newObject2.display();
		
		//This will work but it should not be allowed. you force only one object creation using the createSingletonObject()
		PrivateConstructor newObject4 = new PrivateConstructor();
		newObject4.num = newObject4.num + 30; 	//40
		newObject4.display();*/
	}
}

/* OUTPUT: 
Singleton Object Created. number: 20
Singleton Object Created. number: 20 */
