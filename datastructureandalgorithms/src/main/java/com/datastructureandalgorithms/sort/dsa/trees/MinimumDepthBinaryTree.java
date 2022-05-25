package dataStructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author prachi.shah
 * @date 3/15/2017
 * @concept Binary Tree
 * @definition Every node has 0, 1 or 2 children.
 * @program Find Minimum Depth of a Binary Tree
 * @code http://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
 * @description The minimum depth is the number of nodes along the shortest path
 *              from root node down to the nearest leaf node. The idea is to
 *              traverse the given Binary Tree. For every node, check if it is a
 *              leaf node. If yes, then return 1. If not leaf node then if left
 *              subtree is NULL, then recur for right subtree. And if right
 *              subtree is NULL, then recur for left subtree. If both left and
 *              right subtrees are not NULL, then take the minimum of two
 *              heights.
 */
public class MinimumDepthBinaryTree {

	// root node
	// Node class with constructor
	// Create a node
	// Traverse binary tree: level-order traversal
	// Find minimum depth
	// Print tree in Level-order
	// main()
	// Create a binary tree
	// Print tree in Level-order
	// Find minimum depth

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

	// Print Binary Tree with level-order traversal
	void printLevelOrderTraversal(Node rootNode) {

		Queue<MinimumDepthBinaryTree.Node> newTree = new LinkedList<MinimumDepthBinaryTree.Node>();
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

	// Find Minimum Depth
	public int getMinimumDepth(Node rootNode) {

		Node tempNode = rootNode;

		if (tempNode == null) {
			System.out.println("\nEmpty Binary Tree. Cannot calculate the minimum depth.");
			return 0;
		}

		if (tempNode.left == null && tempNode.right == null) {
			System.out.println(
					"\nBinary Tree has only one (root) node: " + tempNode.data + ". Minimum depth of this tree is 1.");
			return 1;
		}

		// If left subtree is NULL, find depth of the right subtree
		if (tempNode.left == null) {
			// here, 1 is for the depth of the current root node provided in
			// this function
			return getMinimumDepth(tempNode.right) + 1;
		}
		// If right subtree is NULL, find depth of the left subtree
		if (tempNode.right == null) {
			return getMinimumDepth(tempNode.left) + 1;
		}

		// Calculate final minimum depth if no subtrees are NULL
		// 1 for counting the depth of the root node.
		return Math.min(getMinimumDepth(tempNode.left), getMinimumDepth(tempNode.right)) + 1;
	}

	// main()
	public static void main(String[] args) {

		// New binary tree with the root node
		MinimumDepthBinaryTree newBinaryTree = new MinimumDepthBinaryTree();

		int minimumDepth = 0;

		// Create binary tree
		newBinaryTree.root = newBinaryTree.createNode(40);
		newBinaryTree.root.left = newBinaryTree.createNode(20);
		newBinaryTree.root.right = newBinaryTree.createNode(60);
		newBinaryTree.root.left.left = newBinaryTree.createNode(10);
		newBinaryTree.root.left.right = newBinaryTree.createNode(30);
		newBinaryTree.root.right.left = newBinaryTree.createNode(50);
		newBinaryTree.root.right.right = newBinaryTree.createNode(70);

		// TRAVERSAL
		// Print binary tree with level-order traversal: 40 20 60 10 30 50 70
		System.out.println("Binary Tree with Level-order traversal");
		newBinaryTree.printLevelOrderTraversal(newBinaryTree.root);
		System.out.println();

		// MINIMUM DEPTH
		minimumDepth = newBinaryTree.getMinimumDepth(newBinaryTree.root);
		System.out.println("\nMinimum Depth of this Binary Tree is: " + minimumDepth);

	}
}
