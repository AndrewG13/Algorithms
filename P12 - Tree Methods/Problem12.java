import java.util.*;

public class Problem12<T extends Comparable<T>> {
	// A Java implementation of BST
	// T is a Java generic type

	private Node<T> root;
	private Comparator<T> comparator;

	public Problem12()// constructor
	{
		root = null;
		comparator = null;
	}

	public Problem12(Comparator<T> comp) {
		root = null;
		comparator = comp;
	}

	private int compare(T x, T y) {
		if (comparator == null) {
			return x.compareTo(y);
		} else
			return comparator.compare(x, y);
	}

	public T minNode() {
		return minNode(root);
	}

	private T minNode(Node<T> root) {
		if (root == null) {
			return null;
		} else if (root.left != null) {
			return minNode(root.left);
		} else {
			return root.data;
		}
	}

	public T maxNode() {
		return maxNode(root);
	}

	private T maxNode(Node<T> root) {
		if (root == null) {
			return null;
		} else if (root.right != null) {
			return maxNode(root.right);
		} else {
			return root.data;
		}

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
		// if not found, false
		if (p == null) {
			return false;
		}
		// if found, true
		else if (compare(toSearch, p.data) == 0) {
			return true;
		}
		// if < parent, search left
		else if (compare(toSearch, p.data) < 0) {
			return search(p.left, toSearch);
		}
		// if > parent, search right
		else {
			return search(p.right, toSearch);
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

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node<T> r) {
		if (r != null) {
			// if left doesn't exist, print parent, check right
			if (r.left == null) {
				System.out.print(r.data + " ");
				inOrderTraversal(r.right);
			} else {
				// else check left entirely, then print parent, then check right
				inOrderTraversal(r.left);
				System.out.print(r.data + " ");
				inOrderTraversal(r.right);
			}
		}
	}

	public void kthElement(int count) {
		kthElement(root, count);
	}

	private void kthElement(Node<T> r, int count) {
		if (r != null) {
			// if left doesn't exist, print parent, check right
			if (r.left == null) {
				System.out.print(r.data + "[" + count + "]  ");
				count++;
				kthElement(r.right, count);
			} else {
				// else check left entirely, then print parent, then check right
				
				kthElement(r.left, count);
				System.out.print(r.data + "[" + count + "]  ");
				count++;
				kthElement(r.right, count);
				count++;
			}
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

	public int size() {
		return size(root);
	}

	private int size(Node p) {
		if (p == null) {
			// if node doesnt exist, dont count it
			return 0;
		} else {
			// node exists, count it and check children
			return 1 + size(p.left) + size(p.right);
		}

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
		Problem12 bst = new Problem12();
		for (Integer n : a)
			bst.insert(n);
		bst.inOrderTraversal();
		// the output should be 1, 2, 4, 5, 7
		System.out.println();
		System.out.println("The size of the tree is " + bst.size());
		// the output should be 5
		System.out.println("Does 5 exist in the tree?  " + bst.search(5));
		// the output should be true
		System.out.println("Does 10 exist in the tree?  " + bst.search(10));
		// the output should be false
		System.out.println("Min of Tree  " + bst.minNode());
		System.out.println("Max of Tree  " + bst.maxNode());
		System.out.println("Kth Element (k:2) =  ");
		bst.kthElement(0);

		// Additional Test Tree
		System.out.println("\nAdditional Test Tree\n");
		Integer[] b = { 100, 5, -22, 44, 0, 1, 9, 399 };
		Problem12 bstB = new Problem12();
		for (Integer n : b)
			bstB.insert(n);
		bstB.inOrderTraversal();
		System.out.println();
		System.out.println("The size of the tree B is " + bstB.size());
		// Should be 8
		System.out.println("Does 0 (smallest) exist in the tree?  " + bstB.search(0));
		// the output should be true
		System.out.println("Does 44 exist in the tree?  " + bstB.search(44));
		// the output should be true
		System.out.println("Does 399 (biggest) exist in the tree?  " + bstB.search(399));
		// the output should be true
		System.out.println("Does 10 exist in the tree?  " + bstB.search(10));
		// the output should be false
		System.out.println("Does 401 exist in the tree?  " + bstB.search(401));
		// the output should be false
		System.out.println("Min of Tree  " + bstB.minNode());
		System.out.println("Max of Tree  " + bstB.maxNode());

	}

}// end of BST
