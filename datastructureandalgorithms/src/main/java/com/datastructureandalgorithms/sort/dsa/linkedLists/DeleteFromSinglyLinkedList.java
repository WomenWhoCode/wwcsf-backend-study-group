package dataStructures.linkedLists;

/**
 * @author prachi.shah
 * @date 3/12/2017
 * @concept Singly Linked List
 * @program Delete an element from a Singly Linked List; Delet the list.
 * @study http://www.geeksforgeeks.org/delete-a-given-node-in-linked-list-under-given-constraints/
 */
public class DeleteFromSinglyLinkedList {

	// create Node class
	// create a newnode
	// add a new node to the list
	// delete a node from the list
	// print list
	// main() : create list; delete element
	// delete the list

	// head of the list
	Node head;

	// Create Node class
	// Inner class
	public class Node {
		int data;
		Node next;

		Node(int dataInNode) { // Parameterized constructor
			data = dataInNode;
			next = null;
		}
	}

	// Create a new Node with a value
	public Node createNode(int data) {
		Node newNode = new Node(data);
		return newNode;
	}

	// Add node to the list; will also help create the list
	public void addNode(Node head, Node newNode) {

		// If head is null (List is empty)
		if (head == null) {
			System.out.println("List is empty. Creating a new list with just one new Node: " + newNode.data);
			head = newNode;
		}

		if (newNode == null) {
			return;
		}

		// If list is not empty, add element to the end of the list
		Node current = head;

		// Traverse the list and reach the last node
		while (current.next != null) {
			current = current.next;
		}

		current.next = newNode;
	}

	// Print the list
	public void printSinglyLinkedList(Node head) {

		Node current = head;

		if (current == null) {
			System.out.println("List is empty.");
		}

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	// Delete a node from the list
	public Node deleteNode(Node head, int datatoDelete) {
		Node current = head;

		// If head = null; list is empty
		if (head == null) {
			System.out.println("Empty list - nothing to delete.");
		}

		/*
		 * If head needs to be deleted: Consider, head is the only element in
		 * the list There are more elements in the list
		 */
		// head is the only element in the list
		if (head.next == null && head.data == datatoDelete) {
			System.out.println("Deleted element: " + head.data);
			head = null;
		}

		// If the list has more than one nodes and you have to delete the
		// HEAD/FIRST node.
		while (current.next != null && current.data == datatoDelete) { // 1 2 3 4 and delete 1

			// current points to the first node that also needs to be deleted
			Node temp = current;
			System.out.println("\nDeleting " + temp.data);
			current = current.next;
			head = current; // The next node is the new head now
			temp = null;
		}

		// If the list has more than one nodes and you do not delete the
		// head/first node.
		// Traverse the list till you reach the previous node of the element you
		// want to delete
		while (current.next != null && current.next.data != datatoDelete) { // 1 2 3 4 and delete 4
			current = current.next;
		}

		// current.next now points to the node to be deleted so, delete the next
		// node but, this node is not the last element in the list
		if (current.next != null && current.next.next != null && current.next.data == datatoDelete) {
			Node temp = current.next; // The node to be deleted
			System.out.println("\nDeleting " + temp.data);
			current.next = temp.next; // OR: current.next = current.next.next;
			temp = null; // Delete the node that needs to be deleted
		}

		// If the element needs to be deleted is the last element in the list
		else if (current.next != null && current.next.data == datatoDelete && current.next.next == null) {
			// The next node of the current node needs to be deleted because the
			// next node
			// will be the last node in the list
			Node temp = current.next;
			System.out.println("\nDeleting " + temp.data);
			current.next = temp.next;
			temp = null;
		} else { // Element not found in the list
			System.out.println("\nElement " + datatoDelete + " not found in the list. Cannot delete it.");
		}

		return head;
	}

	public Node deleteList(Node head) {

		Node current = head;
		while (current.next != null) {
			@SuppressWarnings("unused")
			Node temp = current;
			current = current.next;
			temp = null;
		}

		current = null;
		head = current;

		return head;
	}

	public static void main(String[] args) {

		DeleteFromSinglyLinkedList newList = new DeleteFromSinglyLinkedList();

		// Create a node
		Node head = newList.createNode(1);
		// Add node to the list
		newList.addNode(head, null);

		// Create more nodes and add them to the list
		Node second = newList.createNode(2);
		newList.addNode(head, second);

		Node third = newList.createNode(3);
		newList.addNode(head, third);

		Node fourth = newList.createNode(4);
		newList.addNode(head, fourth);

		Node fifth = newList.createNode(5);
		newList.addNode(head, fifth);

		Node sixth = newList.createNode(6);
		newList.addNode(head, sixth);

		Node seventh = newList.createNode(7);
		newList.addNode(head, seventh);

		// Print the list
		System.out.println("The initial list:");
		newList.printSinglyLinkedList(head);

		// Delete node from the list: 6
		head = newList.deleteNode(head, 6);

		// Print the new list
		System.out.println("\nThe modified list:");
		newList.printSinglyLinkedList(head);

		// Delete last node from the list: 7
		head = newList.deleteNode(head, 7);

		// Print the new list
		System.out.println("\nThe modified list:");
		newList.printSinglyLinkedList(head);

		// Delete first node from the list: 1
		head = newList.deleteNode(head, 1);

		// Print the new list
		System.out.println("\nThe modified list:");
		newList.printSinglyLinkedList(head);

		// Delete first node from the list: 1
		head = newList.deleteNode(head, 1);

		// Print the new list
		System.out.println("\nThe modified list:");
		newList.printSinglyLinkedList(head);

		// Delete the list
		head = newList.deleteList(head);
		System.out.println("\nList deleted.");
		newList.printSinglyLinkedList(head);
	}
}
