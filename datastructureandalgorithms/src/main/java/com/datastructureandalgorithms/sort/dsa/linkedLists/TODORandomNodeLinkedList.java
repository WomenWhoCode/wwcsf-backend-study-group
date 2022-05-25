package dataStructures.linkedLists;

/**
 * @author prachi.shah
 * @date 3/12/2017
 * @concept Singly Linked List
 * @program Select a Random Node from a Singly Linked List
 * @study http://www.geeksforgeeks.org/select-a-random-node-from-a-singly-linked-list/
 */
public class TODORandomNodeLinkedList {

	// head node
	// Node class
	// Create a node
	// Add nodes to the list/ Create a list
	// Print the list
	// Pick random element from the list
	// main()
	// Create a list
	// Pick random element from the list
	// Print the list

	// Create head node for the list
	Node head;

	// Inner class
	// Node class: to create a Node in the Singly Linked List
	public class Node {
		int data;
		Node next;

		Node(int dataInNode) { // Add data to a new node
			data = dataInNode;
			next = null;
		}
	}

	// Create a new node
	public Node createNode(int dataInNode) {
		Node newNode = new Node(dataInNode);
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

		// If list is not empty, add new Node at the correct position in the
		// sorted list
		// Traverse to the node that has value less than the new Node. The
		// position after this node is where we need to add the new Node.
		// 1 2 3 4 6 7 NEED at add 5 before 6
		while (current.next != null && current.next.data < newNode.data) {
			current = current.next;
		}

		// Add node at the right position
		newNode.next = current.next;
		current.next = newNode;

		return head; // return complete list after adding node.
	}

	// Pick random element from the list
	public int pickRandomElement(Node headList) {
		int i = 1;
		
		return i;
	}

	// main()
	public static void main(String[] args) {

		// New empty list
		// This will give me head
		TODORandomNodeLinkedList newList = new TODORandomNodeLinkedList();
		// node which is not
		// Create nodes in the list
		Node head = newList.createNode(1);
		// head.data = 1; head.next = null

		// Add node
		head = newList.addNode(head, null); // Added first node
		// head.data = 1; head.next = null
		// only one node in the list

		// Add more elements
		Node second = newList.createNode(2);
		// second.data = 3; second.next = null
		head = newList.addNode(head, second);

		Node third = newList.createNode(3);
		// third.data = 3; third.next = null
		head = newList.addNode(head, third);

		Node fourth = newList.createNode(4);
		head = newList.addNode(head, fourth);

		Node sixth = newList.createNode(6);
		head = newList.addNode(head, sixth);

		Node seventh = newList.createNode(7);
		head = newList.addNode(head, seventh);

		Node tenth = newList.createNode(10);
		head = newList.addNode(head, tenth);

		// Print list
		newList.printSinglyLinkedList(head);

		// Add new element to the sorted list
		Node fifth = newList.createNode(5);
		head = newList.addNode(head, fifth);

		// Print new list with the newly added node
		System.out.println("Sorted list with the new elements:");
		System.out.println("Added 5 to the list:");
		newList.printSinglyLinkedList(head);

		// Add new element to the sorted list
		Node eighth = newList.createNode(8);
		head = newList.addNode(head, eighth);

		// Print new list with the newly added node
		System.out.println("Added 8 to the list:");
		newList.printSinglyLinkedList(head);

		// Add new element to the sorted list
		Node ninth = newList.createNode(9);
		head = newList.addNode(head, ninth);

		// Print new list with the newly added node
		System.out.println("Added 9 to the list:");
		newList.printSinglyLinkedList(head);
	}
}
