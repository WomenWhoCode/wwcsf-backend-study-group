package dataStructures.linkedLists;

/**
 * @author prachi.shah
 * @date 3/12/2017
 * @concept Singly Linked List
 * @program Compare two strings represented as Singly Linked Lists
 * @study http://www.geeksforgeeks.org/compare-two-strings-represented-as-linked-lists/
 * @problem Given two linked lists, represented as linked lists (every character
 *          is a node in linked list). Write a function compare() that works
 *          similar to strcmp(), i.e., it returns 0 if both strings are same, 1
 *          if first linked list is lexicographically greater, and -1 if second
 *          string is lexicographically greater.
 */
public class StringCompareLinkedList {

	// head node
	// Node class
	// Create a node
	// Add notes to the list/ Create a list
	// Print the list
	// Compare the two lists
	// main()
	// Create two lists
	// compare two lists
	// Print the lists

	// Create head node for the list
	Node head;

	// Inner class
	// Node class: to create a Node in the Singly Linked List
	public class Node {
		char data;
		Node next;

		Node(char charInNode) { // Add data to a new node
			data = charInNode;
			next = null;
		}
	}

	// Create a new node
	public Node createNode(char charInNode) {
		Node newNode = new Node(charInNode);
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

	// Compare two lists
	public int compareLists(Node headFirstList, Node headSecondList) {

		// both list null, return 0
		// traverse list till data in both is equal:
		// if first list is null, return -1
		// if second list is null, return 1
		// if both list are same length, return 0

		// both list null, return 0
		if (headFirstList == null && headSecondList == null) {
			return 0;
		}

		// traverse list till data in both is equal:
		while (headFirstList != null && headSecondList != null && headFirstList.data == headSecondList.data) {
			headFirstList = headFirstList.next;
			headSecondList = headSecondList.next;
		}

		// check if one of the lists reached end then return 1 or -1 accordingly
		// if first list is null, return -1
		if (headFirstList == null && headSecondList != null) {
			return -1;
		}
		// if second list is null, return 11
		if (headFirstList != null && headSecondList == null) {
			return 1;
		}

		if (headFirstList != null && headSecondList != null) {
			return headFirstList.data > headSecondList.data ? 1 : -1;
		}

		return 0;
	}

	// main()
	public static void main(String[] args) {

		// New empty list
		StringCompareLinkedList firstList = new StringCompareLinkedList();
		StringCompareLinkedList secondList = new StringCompareLinkedList();

		int compareResult;

		// Create head node in the FIRST list
		Node headFirst = firstList.createNode('P');
		// Add head node to the first list
		headFirst = firstList.addNode(headFirst, null); // Added first node. Only one node in the list
		// Add more elements to the first list
		Node charR = firstList.createNode('R');
		headFirst = firstList.addNode(headFirst, charR);
		Node charA = firstList.createNode('A');
		headFirst = firstList.addNode(headFirst, charA);
		Node charC = firstList.createNode('C');
		headFirst = firstList.addNode(headFirst, charC);
		Node charH = firstList.createNode('H');
		headFirst = firstList.addNode(headFirst, charH);
		Node charI = firstList.createNode('I');
		headFirst = firstList.addNode(headFirst, charI);

		// Create head node in the SECOND list
		Node headSecond = secondList.createNode('P');
		// Add head node to the second list
		headSecond = secondList.addNode(headSecond, null); // Added first node. Only one node in the list
		// Add more elements to the second list
		Node chR = secondList.createNode('R');
		headSecond = secondList.addNode(headSecond, chR);
		Node chA = secondList.createNode('A');
		headSecond = secondList.addNode(headSecond, chA);
		Node chC = secondList.createNode('C');
		headSecond = secondList.addNode(headSecond, chC);
		Node chH = secondList.createNode('H');
		headSecond = secondList.addNode(headSecond, chH);
		Node chI = secondList.createNode('I');
		headSecond = secondList.addNode(headSecond, chI);
		Node chS = secondList.createNode('S');
		headSecond = secondList.addNode(headSecond, chS);

		// PRINT lists
		firstList.printSinglyLinkedList(headFirst);
		secondList.printSinglyLinkedList(headSecond);

		// COMPARE lists
		compareResult = secondList.compareLists(headFirst, headSecond);
		if (compareResult == 0) {
			System.out.println("The two strings are equal: " + compareResult);
		} else if (compareResult == 1) {
			System.out.println("First String is lexicographically greater than the second string: " + compareResult);
		} else if (compareResult == -1) {
			System.out.println("Second String is lexicographically greater than the first string: " + compareResult);
		}
	}
}
