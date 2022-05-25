package dataStructures.linkedLists;

/**
 * @author prachi.shah
 * @date 3/14/2017
 * @concept Singly Linked List
 * @program Reverse a Linked List
 * @study http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
 */
public class ReverseLinkedList {

	// head node
	// Node class
	// Create a node
	// Add nodes to the list/ Create a list
	// Print the list
	// Reverse list
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
	public Node reverseList(Node headNode) {

		// Both list null, return message
		// Reverse
		// Return new reversed list

		Node prev = null;
		Node current = headNode;
		Node next = null;
		while (current != null) {	// Move the pointers in reverse direction. Do not move data.
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		headNode = prev;
		return headNode; // Return reversed list
	}

	// main()
	public static void main(String[] args) {

		// New empty list
		ReverseLinkedList list = new ReverseLinkedList();

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
		headFirst = list.addNode(headFirst, four); // 1->2->3->4

		// PRINT the list
		System.out.println("Original list:");
		list.printSinglyLinkedList(headFirst);

		// REVERSE the list
		Node reverseList = list.reverseList(headFirst);
		System.out.println("Reversed list:");
		list.printSinglyLinkedList(reverseList); // 4->3->2->1
	}
}
