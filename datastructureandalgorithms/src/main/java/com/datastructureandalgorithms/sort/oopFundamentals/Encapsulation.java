package oopFundamentals;

/**
 * @author prachi.shah
 * @date 2/19/17
 * @concept Encapsulation example.
 * @program Uses class NumberOfEmployees.
 */
public class Encapsulation {

	public static void main(String args[]) {
		System.out.println("Encapsulation example...");
		NumberOfEmployees number = new NumberOfEmployees();
		number.setNumberOfEmployees(100);
		System.out.println("Number of Employees: " + number.getNumberOFEmployees());
	}
}