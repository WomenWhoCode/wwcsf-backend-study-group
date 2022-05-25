package dataStructures.linkedLists;

/**
 * @author prachi.shah
 * @date 3/12/2017
 * @concept Singly Linked List
 * @program Add/Insert an element to an already sorted Singly Linked List - Code improved.
 * @study http://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/
 */
public class Add2ToSortedLinkedList {

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
		while (current != null) {
			System.out.println(current.data + " ");
			current = current.next;
		}
	}

	// Add element to an already sorted Singly Linked list
	public void addNode(Node head, Node newNode) {

		Node current = head;

		// if newNode == null
		if (newNode == null) { // Nothing to add to the list so back the list
								// (head)
			return; // return head with whatever the list is
		}

		// If list is empty, add newNode and return list
		// Or, if head data is greater than or euqal to the newNode data then,
		// add the newNode before head node and make the newNode as the new head
		if (head == null || head.data >= newNode.data) {
			System.out.println("List is empty. Creating new list with one new Node.");

			if (newNode != null) {
				newNode.next = head;
				head = newNode;
			}
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

		// return head; // return complete list after adding node.
	}

	// main()
	public static void main(String[] args) {

		// New empty list
		Add2ToSortedLinkedList newList = new Add2ToSortedLinkedList(); // This
																		// will
																		// give
																		// me
																		// head
		// node which is not
		// Create nodes in the list
		Node head = newList.createNode(1);
		// head.data = 1; head.next = null

		// Add node
		newList.addNode(head, null); // Added first node
		// head.data = 1; head.next = null
		// only one node in the list

		// Add more elements
		Node second = newList.createNode(2);
		// second.data = 3; second.next = null
		newList.addNode(head, second);

		Node third = newList.createNode(3);
		// third.data = 3; third.next = null
		newList.addNode(head, third);

		Node fourth = newList.createNode(4);
		newList.addNode(head, fourth);

		Node sixth = newList.createNode(6);
		newList.addNode(head, sixth);

		Node seventh = newList.createNode(7);
		newList.addNode(head, seventh);

		Node tenth = newList.createNode(10);
		newList.addNode(head, tenth);

		// Print list
		newList.printSinglyLinkedList(head);

		// Add new element to the sorted list
		Node fifth = newList.createNode(5);
		newList.addNode(head, fifth);

		// Print new list with the newly added node
		System.out.println("Sorted list with the new elements:");
		System.out.println("Added 5 to the list:");
		newList.printSinglyLinkedList(head);

		// Add new element to the sorted list
		Node eighth = newList.createNode(8);
		newList.addNode(head, eighth);

		// Print new list with the newly added node
		System.out.println("Added 8 to the list:");
		newList.printSinglyLinkedList(head);

		// Add new element to the sorted list
		Node ninth = newList.createNode(9);
		newList.addNode(head, ninth);

		// Print new list with the newly added node
		System.out.println("Added 9 to the list:");
		newList.printSinglyLinkedList(head);
		
		// Add new element to the sorted list
		Node ninthAgain = newList.createNode(9);
		newList.addNode(head, ninthAgain);

		// Print new list with the newly added node
		System.out.println("Added 9 AGAIN to the list:");
		newList.printSinglyLinkedList(head);
	}
}
