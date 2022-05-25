package dataStructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author prachi.shah
 * @date 3/15/2017
 * @concept Binary Tree
 * @definition Every node has 0, 1 or 2 children.
 * @program Print contents of a Binary Tree: Pre-order, In-order, Post-order and
 *          Level-order traversal
 * @pre_order http://www.java2blog.com/2014/07/binary-tree-preorder-traversal-in-java.html
 * @in_order http://www.java2blog.com/2014/07/binary-tree-inorder-traversal-in-java.html
 * @post_order http://www.java2blog.com/2014/07/binary-tree-postorder-traversal-in-java.html
 * @level_order http://algorithms.tutorialhorizon.com/level-order-traversal-print-each-level-in-separate-line/
 */
public class TraversalBinaryTree {

	// root node
	// Node class with constructor
	// Create a node
	// Pre-order traversal
	// In-order traversal
	// Post-order traversal
	// Level-order traversal
	// main()
	// Create a binary tree
	// Pre-order traversal print
	// In-order traversal print
	// Post-order traversal print
	// Level-order traversal print

	
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
			// left = right = null;
		}
	}

	// Create a new node
	public Node createNode(int dataInNode) {
		Node newNode = new Node(dataInNode);
		return newNode;
	}

	// Print Binary Tree with pre-order traversal
	void printPreOrderTraversal(Node rootNode) {

		if (rootNode != null) {
			System.out.print(rootNode.data + " ");
			printPreOrderTraversal(rootNode.left);
			printPreOrderTraversal(rootNode.right);
		}
	}

	// Print Binary Tree with in-order traversal
	void printInOrderTraversal(Node rootNode) {

		if (rootNode != null) {
			printInOrderTraversal(rootNode.left);
			System.out.print(rootNode.data + " ");
			printInOrderTraversal(rootNode.right);
		}
	}

	// Print Binary Tree with post-order traversal
	void printPostOrderTraversal(Node rootNode) {

		if (rootNode != null) {
			printPostOrderTraversal(rootNode.left);
			printPostOrderTraversal(rootNode.right);
			System.out.print(rootNode.data + " ");
		}
	}

	// Print Binary Tree with level-order traversal
	void printLevelOrderTraversal(Node rootNode) {

		Queue<TraversalBinaryTree.Node> newTree = new LinkedList<TraversalBinaryTree.Node>();
		newTree.add(rootNode);

		// Has at-least root node; checks if root node is not null
		while (!newTree.isEmpty()) {
			Node tempNode = newTree.poll();
			System.out.print(tempNode.data + " ");
			if (tempNode.left != null) {
				newTree.add(tempNode.left);
			}
			if (tempNode.right != null) {
				newTree.add(tempNode.right);
			}
		}
	}

	// main()
	public static void main(String[] args) {

		// New binary tree with the root node
		TraversalBinaryTree newBinaryTree = new TraversalBinaryTree();

		// Create binary tree
		newBinaryTree.root = newBinaryTree.createNode(40);
		newBinaryTree.root.left = newBinaryTree.createNode(20);
		newBinaryTree.root.right = newBinaryTree.createNode(60);
		newBinaryTree.root.left.left = newBinaryTree.createNode(10);
		newBinaryTree.root.left.right = newBinaryTree.createNode(30);
		newBinaryTree.root.right.left = newBinaryTree.createNode(50);
		newBinaryTree.root.right.right = newBinaryTree.createNode(70);

		// TRAVERSAL
		// Print binary tree with pre-order traversal: 40 20 10 30 60 50 70
		System.out.println("Binary Tree with Pre-order traversal");
		newBinaryTree.printPreOrderTraversal(newBinaryTree.root);

		// Print binary tree with in-order traversal: 10 20 30 40 50 60 70
		System.out.println("\nBinary Tree with In-order traversal");
		newBinaryTree.printInOrderTraversal(newBinaryTree.root);

		// Print binary tree with post-order traversal: 10 30 20 50 70 60 40
		System.out.println("\nBinary Tree with Post-order traversal");
		newBinaryTree.printPostOrderTraversal(newBinaryTree.root);

		// Print binary tree with level-order traversal: 40 20 60 10 30 50 70
		System.out.println("\nBinary Tree with Level-order traversal");
		newBinaryTree.printLevelOrderTraversal(newBinaryTree.root);
	}
}
