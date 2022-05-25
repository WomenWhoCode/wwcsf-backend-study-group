

/**
 * @author prachi.shah
 * @date 3/14/2017
 * @concept Singly Linked List
 * @program Add two numbers represented by linked lists
 * @study http://www.geeksforgeeks.org/sum-of-two-linked-lists/
 * @code http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 * @problem Given two numbers represented by two linked lists, write a function
 *          that returns sum list. The sum list is linked list representation of
 *          addition of two input numbers. It is not allowed to modify the
 *          lists. Also, not allowed to use explicit extra space (Hint: Use
 *          Recursion).
 * @discussion We have discussed a solution here which is for linked lists where
 *             least significant digit is first node of lists and most
 *             significant digit is last node. In this problem, most significant
 *             node is first node and least significant digit is last node and
 *             we are not allowed to modify the lists. Recursion is used here to
 *             calculate sum from right to left.
 * 
 *             Following are the steps. 1) Calculate sizes of given two linked
 *             lists. 2) If sizes are same, then calculate sum using recursion.
 *             Hold all nodes in recursion call stack till the rightmost node,
 *             calculate sum of rightmost nodes and forward carry to left side.
 *             3) If size is not same, then follow below steps: ….a) Calculate
 *             difference of sizes of two linked lists. Let the difference be
 *             diff ….b) Move diff nodes ahead in the bigger linked list. Now
 *             use step 2 to calculate sum of smaller list and right sub-list
 *             (of same size) of larger list. Also, store the carry of this sum.
 *             ….c) Calculate sum of the carry (calculated in previous step)
 *             with the remaining left sub-list of larger list. Nodes of this
 *             sum are added at the beginning of sum list obtained previous
 *             step.
 * @Assumption Here, both the linked list are stored in reverse order. example:
 *             number 345 is stored in the linked list as 5->4->3 This helps do
 *             the sum.
 */
public class AddTwoNumbersLinkedList {

	// head node
	// Node class
	// Create a node
	// Add nodes to the list/ Create a list
	// Print the list
	// Add the numbers in the two lists
	// main()
	// Create two lists
	// add two lists
	// Print the lists

	// Create head node for the list
	Node head;

	// Inner class
	// Node class: to create a Node in the Singly Linked List
	public class Node {
		int data;
		Node next;

		Node(int intInNode) { // Add data to a new node
			data = intInNode;
			next = null;
		}
	}

	// Create a new node
	public Node createNode(int intInNode) {
		Node newNode = new Node(intInNode);
		return newNode;
	}

	// Print Singly Linked List
	void printSinglyLinkedList(Node listHead) {
		Node current = listHead;

		if (current == null) {
			System.out.println("Empty Singly Linked List.");
		}
		while (current.next != null) {
			System.out.println(current.data + " ");
			current = current.next;
		}

		// Print last element
		System.out.println(current.data);
	}

	// Add element to an already sorted Singly Linked list
	public Node addNode(Node head, Node newNode) {

		Node current = head;

		// If list is empty, add newNode and return list
		if (current == null) {
			System.out.println("List is empty. Creating new list with one new Node.");
			head = newNode;
			newNode.next = null;
			return head;
		}

		// if newNode == null
		if (newNode == null) {
			return current; // return head with whatever the list is
		}

		// If list is not empty, add new Node after the last position in the
		// sorted list
		while (current.next != null) {
			current = current.next;
		}

		// Add node at the right position
		newNode.next = current.next;
		current.next = newNode;

		return head; // return complete list after adding node.
	}

	// Add two lists
	public Node addTwoLists(Node headFirstList, Node headSecondList) {

		// both list null, return message
		// sum
		// carry
		// new list with result

		int sum = 0, carry = 0;
		Node headOfResult = null;
		Node previousOfResult = null;

		// both list null, return 0
		if (headFirstList == null && headSecondList == null) {
			System.out.println("Both lists are empty. Cannot calculate the sum of the list.");
		}

		// Start calculating sum from the first node i.e. from least significant
		// digit of the number.
		while (headFirstList != null || headSecondList != null) {

			sum = carry + (headFirstList != null ? headFirstList.data : 0)
					+ (headSecondList != null ? headSecondList.data : 0); // 5 +
																			// 5
																			// +
																			// carry=0
																			// ==
																			// sum=10

			carry = (sum >= 10) ? 1 : 0; // carry = 1

			sum = sum % 10; // 5 + 5 = sum=0; carry = 1

			Node tempNode = new Node(sum);

			if (headOfResult == null) {
				headOfResult = tempNode;
			} else {
				previousOfResult.next = tempNode;
			}

			previousOfResult = tempNode;

			if (headFirstList != null) {
				headFirstList = headFirstList.next;
			}
			if (headSecondList != null) {
				headSecondList = headSecondList.next;
			}

			if (carry > 0) {
				tempNode.next = new Node(carry);
			}

		}
		return headOfResult;

	}

	// main()
	public static void main(String[] args) {

		// New empty lists
		AddTwoNumbersLinkedList firstList = new AddTwoNumbersLinkedList();
		AddTwoNumbersLinkedList secondList = new AddTwoNumbersLinkedList();

		// Create head node in the FIRST list
		Node headFirst = firstList.createNode(5);
		// Add head node to the first list
		headFirst = firstList.addNode(headFirst, null); // Added first node. Only one node in the list
		// Add more elements to the first list
		Node six = firstList.createNode(6);
		headFirst = firstList.addNode(headFirst, six);
		Node three = firstList.createNode(3);
		headFirst = firstList.addNode(headFirst, three);


		// Create head node in the SECOND list
		Node headSecond = secondList.createNode(8);
		// Add head node to the second list
		headSecond = secondList.addNode(headSecond, null); // Added first node. Only one node in the list
		// Add more elements to the second list
		Node four = secondList.createNode(4);
		headSecond = secondList.addNode(headSecond, four);
		Node two = secondList.createNode(2);
		headSecond = secondList.addNode(headSecond, two);

		// PRINT lists
		System.out.println("First list:");
		firstList.printSinglyLinkedList(headFirst);
		System.out.println("Second list:");
		secondList.printSinglyLinkedList(headSecond);

		// ADD lists
		Node result = secondList.addTwoLists(headFirst, headSecond);
		System.out.println("Result of the sum of the two lists:");
		secondList.printSinglyLinkedList(result);
	}
}
