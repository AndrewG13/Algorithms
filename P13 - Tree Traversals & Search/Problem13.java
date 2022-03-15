import java.util.*;

public class Problem13<T extends Comparable<T>> {
	static int count = 1;
	// A Java implementation of BST
	// T is a Java generic type

	private Node<T> root;
	private Comparator<T> comparator;

	public Problem13()// constructor
	{
		root = null;
		comparator = null;
	}

	public Problem13(Comparator<T> comp) {
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

	public void inOrderTraversal() {
		inOrderHelper(root);
	}
	
	private void inOrderHelper(Node<T> r) {
		if (r != null) {
			inOrderHelper(r.left);
			System.out.print(r.data + " ");
			inOrderHelper(r.right);
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

	public void kthSmallestElement(int k) {
		// Call the helper function starting at root
		kthSmallestElement(k, root);
		// Reset our counter to 1 when done
		count = 1;
	}
	
	private void kthSmallestElement(int k, Node<T> r) {
		// if current Node exists & less than k
		// theres no need to continue once we find k
		if (r != null && count <= k) {
			kthSmallestElement(k, r.left);
			if (count == k) {
				// k found, print
				System.out.println(r.data);
			}
			// index increment
			count++;
			kthSmallestElement(k, r.right);
		}
	}

	public void k1k2Range(T k1, T k2) {
		// Call the helper function starting at the root
		k1k2Range(k1, k2, root);
	}
	
	private void k1k2Range(T k1, T k2, Node<T> r) {
		if (r != null) {
			k1k2Range(k1, k2, r.left);
			
			// if inclusively within k1,k2 range, print 
			if (compare(k1, r.data) <= 0 && compare(k2, r.data) >= 0) {
				System.out.print(r.data + " ");
			}
			k1k2Range(k1, k2, r.right);
		}
	}



	public T findmin() {
		Node<T> find = new Node<T> (root.data, root.left, root.right);
		while (find.left != null) {
			find = find.left;
		}
		return find.data;
	}

	public T findmax() {
		Node<T> find = new Node<T> (root.data, root.left, root.right);
		while (find.right != null) {
			find = find.right;
		}
		return find.data;
	}

	public static void main(String[] args) {
		// example code to create a tree and print the tree inorder
		System.out.print("--- Original Test Tree ---\n");
		Integer[] a = { 4, 5, 2, 7, 1 };
		Problem13 bst = new Problem13();
		for (Integer n : a)
			bst.insert(n);
		System.out.println("PreOrder:");
		bst.preOrderTraversal();
		System.out.println("\nInOrder:");
		bst.inOrderTraversal();
		System.out.println();
		System.out.print("\nThe 3rd smallest node is ");
		bst.kthSmallestElement(3);
		// the output should be 4
		System.out.println("The smallest node is " + bst.findmin());
		// the output should be 1
		System.out.println("The largest node is " + bst.findmax());
		// the output should be 7
		Integer r1 = 2;
		Integer r2 = 5;
		System.out.println("Values in [2,5] ");
		bst.k1k2Range(r1, r2);
		// the output should be 2, 4, 5
		
		// Additional Test Case
		System.out.print("\n\n--- Additional Test Tree ---\n");
		Integer[] b = { 100, 400, 99, 2, -1, 0, 300, 250 };
		Problem13 bst2 = new Problem13();
		for (Integer n : b)
			bst2.insert(n);
		System.out.println("PreOrder:");
		bst2.preOrderTraversal();
		System.out.println("\nInOrder:");
		bst2.inOrderTraversal();
		System.out.println();
		System.out.print("\nThe 2nd smallest node is ");
		bst2.kthSmallestElement(2);
		// the output should be 0
		System.out.print("The 4th smallest node is ");
		bst2.kthSmallestElement(4);
		// the output should be 99
		System.out.println("The smallest node is " + bst2.findmin());
		// the output should be -1
		System.out.println("The largest node is " + bst2.findmax());
		// the output should be 400
		Integer r3 = 99;
		Integer r4 = 400;
		System.out.println("Values in [99,400] ");
		bst2.k1k2Range(r3, r4);
		// the output should be 99, 100, 250, 300, 400

	}

}// end of BST
