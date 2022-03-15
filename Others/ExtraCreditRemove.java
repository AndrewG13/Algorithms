import java.util.*;

public class ExtraCreditRemove<T extends Comparable<T>> {
	// A Java implementation of BST
	// T is a Java generic type

	private Node<T> root;
	private Comparator<T> comparator;

	public ExtraCreditRemove()// constructor
	{
		root = null;
		comparator = null;
	}

	public ExtraCreditRemove(Comparator<T> comp) {
		root = null;
		comparator = comp;
	}

	private int compare(T x, T y) {
		if (comparator == null) {
			return x.compareTo(y);
		} else
			return comparator.compare(x, y);
	}

	public void insert(T toInsert)// Insert a value into the tree
	{
		root = insert(root, toInsert);
	}

	private Node insert(Node<T> p, T toInsert) {
		if (p == null)
			return new Node(toInsert);

		if (compare(toInsert, p.data) == 0)
			return p;

		if (compare(toInsert, p.data) < 0)
			// If the value to insert is less than that of root, insert to the left subtree
			p.left = insert(p.left, toInsert);
		else
			p.right = insert(p.right, toInsert);

		return p;
	}

	public boolean search(T toSearch)// Search for a value in the tree
	{
		return search(root, toSearch);
	}

	private boolean search(Node<T> p, T toSearch) {
		if (p == null)
			return false;
		else if (compare(toSearch, p.data) == 0)
			return true;
		else if (compare(toSearch, p.data) < 0)
			// If the value is less than that of root, search in the left subtree
			return search(p.left, toSearch);
		else
			return search(p.right, toSearch);
	}

	public void delete(T toDelete)// Remove a value in the tree
	{
		// Calls the Helper Delete method starting with the root
		delete(toDelete, root, null);
	}

	private void delete(T toDelete, Node<T> current, Node<T> previous)// Helper Remove
	{
		if (current == null) { // if node is not found
			System.out.print(toDelete + " does not exist\n");
		} else if (compare(toDelete, current.data) == 0) { // if node is found
			if (current.right == null || current.left == null) { // if node has 0 or 1 children
				previous.right = current.right;
				previous.left = current.left;
			} else if (current.right != null && current.left != null) { // if node has two children
				// finding Node to remove's successor
				Node<T> successor = new Node<T>(current.right.data, current.right.left, current.right.right);
				previous = current;
				while (successor.left != null) {
					previous = successor;
					successor = successor.left;
				}
				// replace Node with its successor, then remove successor link
				current.data = successor.data;
				previous.right = successor.right;
				successor = null;
			}
			// Node has now been removed
			System.out.println("[" + toDelete + "] has been removed");

		} else if (compare(toDelete, current.data) < 0) {
			delete(toDelete, current.left, current);
		} else {
			delete(toDelete, current.right, current);
		}
	}

	public void preOrderTraversal() {
		preOrderHelper(root);
	}

	private void preOrderHelper(Node<T> r) {
		if (r != null) {
			System.out.print(r.data + " ");
			preOrderHelper(r.left);
			preOrderHelper(r.right);
		}
	}

	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(Node p) {
		if (p == null)
			return 0;
		else if (p.left == null && p.right == null)
			return 1;
		else
			return countLeaves(p.left) + countLeaves(p.right);
	}

	private class Node<T> {
		private T data;
		private Node<T> left, right;

		public Node(T data, Node l, Node r) // constructor
		{
			left = l;
			right = r;
			this.data = data;
		}

		public Node(T data) {
			this(data, null, null);
		}

	} // end of Node

	public static void main(String[] args) {
		// example code to create a tree and print the tree inorder
		Integer[] a = { 4, 5, 2, 7, 1 };
		ExtraCreditRemove bst = new ExtraCreditRemove();
		for (Integer n : a)
			bst.insert(n);
		bst.preOrderTraversal();
		// the output should be 4, 2, 1, 5, 7
		System.out.println();
		bst.delete(5);
		bst.preOrderTraversal();
		// the output should be 4, 2, 1, 7

	}

}// end of BST
