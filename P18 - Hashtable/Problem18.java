
/*
    This file defines a HashTable class.  Keys and values in the hash table
    are of type Object.  Keys cannot be null.  The default constructor
    creates a table that initially has 64 locations, but a different
    initial size can be specified as a parameter to the constructor.
*/

public class Problem18 {

	public static void main(String[] args) {

		/*
		 * An example to create a hashtable and print its contents
		 */
		
		Problem18 myTest = new Problem18();

		// This is my own Testing procedure, block this and unblock the original to test yours!
		myTest.put(200251, "Kate");
		myTest.put(200277, "Peter");
		myTest.put(200239, "Roger");
		myTest.put(200213, "Test");
		myTest.put(200699, "Delta");
		myTest.put(200800, "Charlie");
		myTest.put(200888, "Omega");
		myTest.put(200100, "Tango");
		myTest.put(200655, "Bravo");
		myTest.put(200443, "Flank");
		myTest.put(200015, "Prop");
		System.out.println("Initial Hashmap");
		myTest.finePrint(); // finePrint skips over unnecessary null buckets

		myTest.remove(200277); // Remove Peter, testing front Node removal
		myTest.remove(200699); // Remove Delta, testing 'in the middle' Node removal
		myTest.remove(200015); // Remove Prop,  testing back Node Removal
		myTest.remove(200100); // Remove Tango, testing 'lone' Node removal
		myTest.remove(100000); // Test to remove a key not found, manipulates nothing
		System.out.println("\nAfter Removal\nRemoving: Peter,Delta,Prop,Tango");
		myTest.finePrint();

		/*Problem18 example = new Problem18();

		example.put(200251, "Kate");
		example.put(200277, "Peter");
		example.put(200239, "Roger");

		example.print();
		
		example.remove(200277); // Remove Peter from hash table
		
		example.print();*/
	}

	static private class ListNode {

		Object key;
		Object value;
		ListNode next; // Pointer to next node in the list;
						// A null marks the end of the list.

		public ListNode(Object newkey, Object newValue) {
			this.key = newkey;
			this.value = newValue;
			this.next = null;
		}
		// A ListNode
		// holds a (key,value) pair.
		// Separate Chaining: Nodes that have the same hash code or that are mapped to
		// the same location in the hash table will be linked together as a linked list
		// in the table
		// This private nested class is used
		// internally to implement linked lists.

	}

	private ListNode[] table; // The hash table, represented as
								// an array of linked lists.

	private int count; // The number of (key,value) pairs in the
						// hash table.

	public Problem18() {
		// Create a hash table with an initial size of 64.
		table = new ListNode[64];
	}

	public Problem18(int initialSize) {
		// Create a hash table with a specified initial size.
		// Precondition: initalSize > 0.
		table = new ListNode[initialSize];
	}

	void finePrint() {
		// This lists the (key,value)
		// pairs in each location of the table.
		System.out.println();
		for (int i = 0; i < table.length; i++) {
			// Prints IF LL is not null
			if (table[i] != null) {
			if (i == 0) {	
			System.out.print(i + ": ");
			} else {
			System.out.print(i + ":");

			}
			ListNode list = table[i]; // For traversing linked list number i.
			while (list != null) {
				System.out.print("  (" + list.key + "," + list.value + ")");
				list = list.next;
			}
			System.out.println();
			}
		}
	} // end dump()
	
	void print() {
		// This lists the (key,value)
		// pairs in each location of the table.
		System.out.println();
		for (int i = 0; i < table.length; i++) {
			// Print out the location number and the list of
			// key/value pairs in this location.
			System.out.print(i + ":");
			ListNode list = table[i]; // For traversing linked list number i.
			while (list != null) {
				System.out.print("  (" + list.key + "," + list.value + ")");
				list = list.next;
			}
			System.out.println();
		}
	} // end dump()

	public void put(Object key, Object value) {

		int bucket = hash(key); // In what location should key be?
		//System.out.print("bucket:" + bucket + " ");

		// if bucket is completely empty, fill first position
		if (table[bucket] == null) {
			table[bucket] = new ListNode(key, value);
		} else {
			// else traverse until empty position is available, fill position
			ListNode list = table[bucket];
			while (list.next != null) {
				list = list.next;
			}
			list.next = new ListNode(key, value);
		}
	}

	public Object get(Object key) {
		// Retrieve the value associated with the specified key
		// in the table, if there is any. If not, the value
		// null will be returned.
		int bucket = hash(key); // At what location of hash table should the key be?
		ListNode list = table[bucket]; // Read the linked list at the corresponding location
		while (list != null) {
			// Check if the specified key is in the current node that
			// list points to. If so, return the associated value. If not, move on to the
			// next node.
			if (list.key.equals(key))
				return list.value;
			list = list.next; // Move on to next node in the list.
		}
		// If we get to this point, then we have looked at every
		// node in the list without finding the key. Return
		// the value null to indicate that the key is not in the table.
		return null;
	}

	public void remove(Object key) {

		boolean found = false;
		int bucket = hash(key); // In what location should key be?
		//System.out.print("bucket:" + bucket + " ");

		// if bucket is completely empty, fill first position
		if (table[bucket] != null) {
			if (table[bucket].key.equals(key)) {
				table[bucket] = table[bucket].next;
			} else {
				// else traverse until empty position is available, fill position
				ListNode list = table[bucket];
				while (list.next != null && !found) {
					if (list.next.key.equals(key)) {
						list.next = list.next.next;
						found = true;
					} else {
						list = list.next;
					}
				}
			}
		}
	}

	public boolean containsKey(Object key) {
		// Test whether the specified key has an associated value
		// in the table.
		int bucket = hash(key); // In what location should key be?
		ListNode list = table[bucket]; // For traversing the list.
		while (list != null) {
			// If we find the key in this node, return true.
			if (list.key.equals(key))
				return true;
			list = list.next;
		}
		// If we get to this point, we know that the key does
		// not exist in the table.
		return false;
	}

	public int size() {
		// Return the number of key/value pairs in the table.
		return count;
	}

	private int hash(Object key) {
		// Compute a hash code for the key; key cannot be null.
		// The hash code depends on the size of the table as
		// well as on the value returned by key.hashCode().
		return (Math.abs(key.hashCode())) % table.length;
	}

} // end class HashTable