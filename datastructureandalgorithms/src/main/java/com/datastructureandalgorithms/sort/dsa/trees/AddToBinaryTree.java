package dataStructures.trees;

/**
 * @author prachi.shah
 * @date 3/15/2017
 * @concept Binary Tree
 * @definition Every node has 0, 1 or 2 children.
 * @program Find Minimum Depth of a Binary Tree
 * @study http://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
 * @description The minimum depth is the number of nodes along the shortest path
 *              from root node down to the nearest leaf node. The idea is to
 *              traverse the given Binary Tree. For every node, check if it is a
 *              leaf node. If yes, then return 1. If not leaf node then if left
 *              subtree is NULL, then recur for right subtree. And if right
 *              subtree is NULL, then recur for left subtree. If both left and
 *              right subtrees are not NULL, then take the minimum of two
 *              heights.
 */
public class AddToBinaryTree {

	// Create root for the binary tree
	Node root;

	// Inner class
	// Node class: to create a Node in the binary tree
	public class Node {
		int data;
		Node left, right;

		// Constructor to create a new node
		Node(int dataInNode) { // Add data to a new node
			data = dataInNode;
			left = right = null;
		}
	}

	// Create a new node
	public Node createNode(int dataInNode) {
		Node newNode = new Node(dataInNode);
		return newNode;
	}

	// Print Binary Tree
	void printBinaryTree(Node rootNode) {

	}

	// Add element to an already sorted Singly Linked list
	// public Node addNode(Node head, Node newNode) {

	// main()
	public static void main(String[] args) {

		// New binary tree with the root node
		AddToBinaryTree newBinaryTree = new AddToBinaryTree();

		// Create binary tree
		newBinaryTree.root = newBinaryTree.createNode(1);
		newBinaryTree.root.left = newBinaryTree.createNode(2);
		newBinaryTree.root.right = newBinaryTree.createNode(3);
		newBinaryTree.root.left.left = newBinaryTree.createNode(4);
		newBinaryTree.root.left.right = newBinaryTree.createNode(5);

		// Print binary tree
		newBinaryTree.printBinaryTree(newBinaryTree.root);
		System.out.println("Binary Tree");

		// Find minimum depth of the binary tree

	}
}
