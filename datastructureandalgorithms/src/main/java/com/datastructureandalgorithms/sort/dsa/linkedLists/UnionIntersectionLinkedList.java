package dataStructures.linkedLists;

/**
 * @author prachi.shah
 * @date 3/15/2017
 * @TODO Improve code
 * @concept Singly Linked List
 * @program Union and Intersection of two Linked Lists
 * @main http://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
 * @study http://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
 * @notes Union will add duplicate elements as well.
 */
public class UnionIntersectionLinkedList {

	// head node
	// Node class
	// Create a node
	// Add nodes to the list/ Create a list
	// Print the list
	// Union of two lists
	// Intersection of two lists
	// Check if an element present in a specific list
	// main()
	// Create two lists
	// Union of two lists
	// Intersection of two lists
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

	// Union of two lists. Add duplicate numbers as well.
	public Node getUnionOfLists(Node headFirstList, Node headSecondList) {
		Node unionResult = null;
		Node headFirst = headFirstList;
		Node headSecond = headSecondList;

		if (headFirstList == null && headSecondList != null) {
			System.out.println("First list is empty. Cannot perform intersection on empty lists.");
			return headSecondList;
		}

		if (headFirstList != null && headSecondList == null) {
			System.out.println("Second list is empty. Cannot perform intersection on empty lists.");
			return headFirstList;
		}

		if (headFirstList == null && headSecondList == null) {
			System.out.println("Empty lists. Cannot perform union on empty lists.");
			return unionResult;	// this will return null. Calling method should handle null
		}

		// Insert all elements of first list in the result list
		while (headFirst != null) {
			unionResult = pushNode(unionResult, headFirst.data);
			headFirst = headFirst.next;
		}
		// Insert all elements of second list in the result list
		while (headSecond != null) {
			unionResult = pushNode(unionResult, headSecond.data);
			headSecond = headSecond.next;
		}
		return unionResult;

	}

	public Node getIntersectionOfLists(Node headFirstList, Node headSecondList) {

		Node intersectionResult = null;
		Node headFirst = headFirstList;
		Node headSecond = headSecondList;

		if (headFirstList == null && headSecondList != null) {
			System.out.println("First list is empty. Cannot perform intersection on empty lists.");
			return headSecondList;
		}

		if (headFirstList != null && headSecondList == null) {
			System.out.println("Second list is empty. Cannot perform intersection on empty lists.");
			return headFirstList;
		}

		if (headFirstList == null && headSecondList == null) {
			System.out.println("Empty lists. Cannot perform intersection on empty lists.");
			return intersectionResult; 	// this will return null. Calling method should handle null
		}

		// Traverse list1 and search each element of it in list2.
		// If the element is present in list 2, then insert the
		// element to result
		while (headFirst != null) {
			if (isNodePresent(headSecond, headFirst.data)) {
				intersectionResult = pushNode(intersectionResult, headFirst.data);
			}
			headFirst = headFirst.next;
		}
		return intersectionResult;

	}

	private Node pushNode(Node result, int data) {

		Node newNode = new Node(data);
		newNode.next = result;
		result = newNode;
		return result;
	}

	public boolean isNodePresent(Node listHead, int nodeData) {

		Node head = listHead;

		if (listHead == null) {
			return false;
		}

		while (head != null) {
			if (head.data == nodeData) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	// main()
	public static void main(String[] args) { // HANDLE NULL

		// New empty lists
		UnionIntersectionLinkedList firstList = new UnionIntersectionLinkedList();
		UnionIntersectionLinkedList secondList = new UnionIntersectionLinkedList();

		// Create head node in the FIRST list
		Node headFirst = firstList.createNode(5);
		// Add head node to the first list
		headFirst = firstList.addNode(headFirst, null);
		// Add more elements to the first list
		Node six = firstList.createNode(6);
		headFirst = firstList.addNode(headFirst, six);
		Node three = firstList.createNode(3);
		headFirst = firstList.addNode(headFirst, three);
		Node fourAgain = firstList.createNode(4);
		headFirst = firstList.addNode(headFirst, fourAgain);

		// Create head node in the SECOND list
		Node headSecond = secondList.createNode(8);
		// Add head node to the second list
		headSecond = secondList.addNode(headSecond, null);
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

		// INTERSECTION of two lists
		Node resultIntersection = firstList.getIntersectionOfLists(headFirst, headSecond);
		if (resultIntersection == null) { // Handling result = null
			System.out.println("Intersection did not return any common elements between the lists.");
		} else {
			System.out.println("Intersection of two lists:");
			firstList.printSinglyLinkedList(resultIntersection);
		}

		// UNION of two lists
		Node resultUnion = firstList.getUnionOfLists(headFirst, headSecond);
		if (resultUnion == null) { // Handling result = null
			System.out.println("Union did not return any elements beacuse the lists may be empty.");
		} else {
			System.out.println("Union of two lists:");
			firstList.printSinglyLinkedList(resultUnion);
		}
	}
}
