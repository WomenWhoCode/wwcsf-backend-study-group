package dataStructures.linkedLists;

/**
 * @author prachi.shah
 * @date 3/15/2017
 * @concept Singly Linked List
 * @program Reverse a Linked List in groups of given size
 * @study http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 */
public class Reverse2LinkedList {

	// head node
	// Node class
	// Create a node
	// Add nodes to the list/ Create a list
	// Print the list
	// Reverse list as per the count
	// main()
	// Create a list
	// Reverse the list
	// Print the list

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
	public Node reverseList(Node headNode, int size) {

		// Both list null, return message
		// Reverse
		// Return new reversed list

		Node previous = null;
		Node current = headNode;
		Node next = null;

		int count = 0;

		// Reverse first k nodes of linked list
		while (count < size && current != null) {
			// Move the pointers in reverse direction. Do not move data.
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;

			count++;
		}

		/*
		 * next is now a pointer to (size+1)th node. Recursively call for the
		 * list starting from current. And make rest of the list as next of
		 * first node.
		 */
		if (next != null)
			headNode.next = reverseList(next, size);	// returns prev = 4 and list is 4->3

		// previous is now head of input list
		return previous; // Return reversed list	// returns prev = 2 and list is 2->!
	}

	// main()
	public static void main(String[] args) {

		// New empty list
		Reverse2LinkedList list = new Reverse2LinkedList();

		// Create head node in the list
		Node headFirst = list.createNode(1);
		// Add head node to the list, only one node in the list
		headFirst = list.addNode(headFirst, null);
		// Add more elements to the first list
		Node two = list.createNode(2);
		headFirst = list.addNode(headFirst, two);
		Node three = list.createNode(3);
		headFirst = list.addNode(headFirst, three);
		Node four = list.createNode(4);
		headFirst = list.addNode(headFirst, four);
		Node five = list.createNode(5);
		headFirst = list.addNode(headFirst, five);
		Node six = list.createNode(6);
		headFirst = list.addNode(headFirst, six); // 1->2->3->4->5->6

		// PRINT the list
		System.out.println("Original list:");
		list.printSinglyLinkedList(headFirst);

		// REVERSE the list
		Node reverseList = list.reverseList(headFirst, 3);
		System.out.println("Reversed list:");
		list.printSinglyLinkedList(reverseList); // 3->2->1->6->5->4
	}
}
