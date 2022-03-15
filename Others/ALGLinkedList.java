
public class ALGLinkedList {

	// The LinkedList Node class
	private class Node {

		int data;
		Node next;

		Node(int gdata) {
			this.data = gdata;
			this.next = null;
		}

	}

	// The LinkedList fields
	Node head;

	// Constructor
	ALGLinkedList(int gdata) {
		this.head = new Node(gdata);
	}

	public void Insertend(int gdata) {
		Node current = this.head;

		while (current.next != null) {
			current = current.next;
		}

		Node newnode = new Node(gdata);
		current.next = newnode;

	}

	public void Listprint() {
		Node current = this.head;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}

		System.out.println();

	}

	public void Removemin() {

		// Begin Searching for minimum
		Node current = this.head;
		int min = current.data;
		while (current != null) {
			if (current.data < min) {
				min = current.data;
			}
			current = current.next;
		}
		// Begin Removal of minimum Node
		current = this.head;
		boolean found = false;

		// - Case: Minimum is the Head Node
		if (current.data == min) {
			found = true;
			head = current.next;
		}
		

		// - Case: Minimum is within the LinkedList
		while (current != null && !found) {
			if (current.next.data == min) {
				found = true;
				current.next = current.next.next;
			} else {
			current = current.next;
			}
		}
	}

	public static void main(String[] args) {

		ALGLinkedList exlist = new ALGLinkedList(8);

		exlist.Insertend(1);
		exlist.Insertend(5);
		exlist.Insertend(2);
		exlist.Insertend(7);
		exlist.Insertend(10);
		exlist.Insertend(3);
		
		exlist.Listprint();
		// output: 8 1 5 2 7 10 3

		exlist.Removemin();

		exlist.Listprint();
		// output should be: 8 5 2 7 10 3

/*		// - Test Case: Minimum is Head Node
		ALGLinkedList exlist1 = new ALGLinkedList(1);

		exlist1.Insertend(8);
		exlist1.Insertend(5);
		exlist1.Insertend(2);
		exlist1.Insertend(7);
		exlist1.Insertend(10);
		exlist1.Insertend(3);
		
		exlist1.Listprint();
		// output: 1 8 5 2 7 10 3

		exlist1.Removemin();

		exlist1.Listprint();
		// output should be: 8 5 2 7 10 3
*/
		
/*		// - Test Case: Minimum is Tail Node
		ALGLinkedList exlist2 = new ALGLinkedList(8);

		exlist2.Insertend(3);
		exlist2.Insertend(5);
		exlist2.Insertend(2);
		exlist2.Insertend(7);
		exlist2.Insertend(10);
		exlist2.Insertend(1);
		
		exlist2.Listprint();
		// output:  8 3 5 2 7 10 1

		exlist2.Removemin();

		exlist2.Listprint();
		// output should be: 8 3 5 2 7 10
*/
	}

}
