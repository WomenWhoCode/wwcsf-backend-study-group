package oopFundamentals;

/**
 * @author prachi.shah
 * @date 3/4/17
 * @concept Interface in Java. Interface can only have abstract methods it it.
 * @program Class Interfaces is a concrete non-Interface class that IMPLEMENTS InterfaceB
 */
interface InterfaceB {

	// Variables in an Interface are public static final by default, that is, they are Constants.
	// Variables cannot be re-initialized
	int Y = 20;

	// Interface methods are abstract and public by default.
	// Interface methods do not have a body
	// Method is just DECLARED here. It will be DEFINED in the class that
	// IMPLEMENTS this InterfaceB.
	void returnY();
}
