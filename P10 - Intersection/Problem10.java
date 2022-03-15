
public class Problem10 {

	public static void intersection(int[] s1, int[] s2) {
		// complete the intersection() method to output
		// elements that occur in both s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place

		System.out.print("{  ");
		int s1i = 0;
		int s2i = 0;
		// Initially sets previous to be > both largest numbers in both arrays
		// This is to ensure the initial check works!
		int previous = s1[s1.length - 1] + s2[s2.length - 1];

		while (s1i < s1.length && s2i < s2.length) {
			if (s1[s1i] == s2[s2i] && s1[s1i] != previous) {
				System.out.print(s1[s1i] + "  ");
				previous = s1[s1i];
				s1i++;
				s2i++;

			} else if (s1[s1i] > s2[s2i]) {
				s2i++;
			} else {
				s1i++;
			}

		}

		System.out.println("}");
	}

	// outputs all elements of both arrays, not duplicates
	public static void union(int[] s1, int[] s2) {
		// complete the union() method to output
		// the union s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place

		System.out.print("{  ");
		
		// s1[] index variable
		int s1i = 0;
		// s2[] index variable
		int s2i = 0;
		
		// Initially sets previous to be > both largest numbers in both arrays
		// This is to ensure the initial check works!
		int previous = s1[s1.length - 1] + s2[s2.length - 1];

		while (s1i < s1.length && s2i < s2.length) {

			// if either current array elements == previous,
			// increase that index(s), skip the rest of While
			if (s1[s1i] == previous || s2[s2i] == previous) {
				if (s1[s1i] == previous) {
					s1i++;
				}
				if (s2[s2i] == previous) {
					s2i++;
				}
			} else // s1[] Less-than Check
				if (s1[s1i] < s2[s2i]) {
				System.out.print(s1[s1i] + "  ");
				previous = s1[s1i];
				s1i++;
			} else // s2[] Less-than Check
				if (s2[s2i] < s1[s1i]) {
				System.out.print(s2[s2i] + "  ");
				previous = s2[s2i];
				s2i++;
			} else { // Both must be equal
				System.out.print(s1[s1i] + "  ");
				previous = s1[s1i];
				s1i++;
				s2i++;
			}
		}
		// while s1[] still has elements...
		while (s1i < s1.length) {
			if (s1[s1i] == previous) {
				s1i++;
			} else {
				System.out.print(s1[s1i] + "  ");
				previous = s1[s1i];
				s1i++;
			}
		}
		// while s2[] still has elements...
		while (s2i < s2.length) {
			if (s2[s2i] == previous) {
				s2i++;
			} else {
				System.out.print(s2[s2i] + "  ");
				previous = s2[s2i];
				s2i++;
			}
		}

		System.out.println("}");
	}

	public static void main(String[] args) {

		int[] testarray1 = { 0, 0, 0, 1, 2, 3, 97, 98 };
		int[] testarray2 = { 0, 1, 2, 3, 4, 4, 10, 98, 100, 100 };

		System.out.println("intersection of testarray1 and testarray2: ");
		intersection(testarray1, testarray2);
		// should output 0, 1, 2, 3, 98

		System.out.println("union of testarray1 and testarray2: ");
		union(testarray1, testarray2);
		// should output 0, 1, 2, 3, 4, 10, 97, 98, 100
		
		// * Additional Test cases
		int[] testarray3 = { 0, 5, 400, 523, 599, 599, 599 };
		int[] testarray4 = { -10, -1, 300, 500, 600 };

		System.out.println("\n\n** There is no intersection, should expect {  } **\nintersection of testarray3 and testarray4: ");
		intersection(testarray3, testarray4);
		// should output 5, 500, 599

		System.out.println("union of testarray3 and testarray4: ");
		union(testarray3, testarray4);
		// should output -10, -1, 0, 5, 300, 400, 500, 523, 599, 600
	}

}
