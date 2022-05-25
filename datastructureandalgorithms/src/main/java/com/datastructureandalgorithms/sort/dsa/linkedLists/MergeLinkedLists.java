package dataStructures.linkedLists;

/**
 * @author prachi.shah
 * @date 3/14/2017
 * @concept Singly Linked List
 * @program Merge a linked list into another linked list at alternate positions
 * @study http://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/
 * @discussion Given two linked lists, insert nodes of second list into first
 *             list at alternate positions of first list. For example, if first
 *             list is 5->7->17->13->11 and second is 12->10->2->4->6, the first
 *             list should become 5->12->7->10->17->2->13->4->11->6 and second
 *             list should become empty. The nodes of second list should only be
 *             inserted when there are positions available. For example, if the
 *             first list is 1->2->3 and second list is 4->5->6->7->8, then
 *             first list should become 1->4->2->5->3->6 and second list to
 *             7->8.
 * 
 *             Use of extra space is not allowed (Not allowed to create
 *             additional nodes), i.e., insertion must be done in-place.
 *             Expected time complexity is O(n) where n is number of nodes in
 *             first list.
 * 
 *             The idea is to run a loop while there are available positions in
 *             first loop and insert nodes of second list by changing pointers.
 *             Following are C and Java implementations of this approach.
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
 */
public class MergeLinkedLists {

	// head node
	// Node class
	// Create a node
	// Add nodes to the list/ Create a list
	// Print the list
	// Merge the two lists
	// main()
	// Create two lists
	// Merge two lists
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
	public Node mergeTwoLists(Node headFirstList, Node headSecondList) {

		// both list null, return message
		// merge
		// new list with result

		Node firstHead = headFirstList, firstCurrent = firstHead, firstNext = null;
		Node secondHead = headSecondList, secondCurrent = secondHead, secondNext = null;

		// both list null, return 0
		if (firstHead == null && secondHead == null) {
			System.out.println("Both lists are empty. Cannot merge the lists.");
		}

		while (firstCurrent != null && secondCurrent != null) {

			// Save next nodes
			firstNext = firstCurrent.next;
			secondNext = secondCurrent.next;

			secondCurrent.next = firstNext;
			firstCurrent.next = secondCurrent;

			// Update current pointers for next iteration
			firstCurrent = firstNext;
			secondCurrent = secondNext;
		}

		// If second list is not empty
		secondHead = secondCurrent;

		return firstHead;	// Return merged list
	}

	// main()
	public static void main(String[] args) {

		// New empty lists
		MergeLinkedLists firstList = new MergeLinkedLists();
		MergeLinkedLists secondList = new MergeLinkedLists();

		// Create head node in the FIRST list
		Node headFirst = firstList.createNode(1);
		// Add head node to the first list
		headFirst = firstList.addNode(headFirst, null); // Added first node.
														// Only one node in the
														// list
		// Add more elements to the first list
		Node two = firstList.createNode(2);
		headFirst = firstList.addNode(headFirst, two);
		Node three = firstList.createNode(3);
		headFirst = firstList.addNode(headFirst, three);
		Node four = firstList.createNode(4);
		headFirst = firstList.addNode(headFirst, four);

		// Create head node in the SECOND list
		Node headSecond = secondList.createNode(5);
		// Add head node to the second list
		headSecond = secondList.addNode(headSecond, null); // Added first node.
															// Only one node in
															// the list
		// Add more elements to the second list
		Node six = secondList.createNode(6);
		headSecond = secondList.addNode(headSecond, six);
		Node seven = secondList.createNode(7);
		headSecond = secondList.addNode(headSecond, seven);

		// PRINT lists
		System.out.println("First list:");
		firstList.printSinglyLinkedList(headFirst);
		System.out.println("Second list:");
		secondList.printSinglyLinkedList(headSecond);

		// ADD lists
		Node result = firstList.mergeTwoLists(headFirst, headSecond);
		System.out.println("Merged list:");
		secondList.printSinglyLinkedList(result);
	}
}
