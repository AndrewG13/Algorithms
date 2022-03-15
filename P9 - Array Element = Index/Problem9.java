
public class Problem9 {

	public static boolean searchi(int[] A, int index, int start, int end) {
		// Complete the method that given a sorted array A[]
		// Find out whether or not there is an index i such that A[i] = i
		// feel free to change the return type, parameters
		// Full credit (30 points) will be awarded for an algorithm that is O(logn).
		// Algorithms that are slower than O(logn) will be scored out of 10 points.

		if (start > end) {
			// No instance of index == A[index]
			return false;
		}

		if (A[index] == index) {
			return true;
		} else if (A[index] > index) {
			// Search front half only, disregard back half
			return searchi(A, (start + (index - 1)) / 2, start, index - 1);
		} else {
			// Search back half only, disregard front half
			return searchi(A, ((index + 1) + end) / 2, index + 1, end);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] testarray1 = { -4, 0, 2, 5, 10 };
		// true

		System.out.println("There is an index i that A[i] = i in testarray1: "
				+ searchi(testarray1, (testarray1.length - 1) / 2, 0, testarray1.length - 1));

		int[] testarray2 = { 1, 2, 3, 4, 5 };
		// false

		System.out.println("There is an index i that A[i] = i in testarray2: "
				+ searchi(testarray2, 0, (testarray2.length - 1) / 2, testarray2.length - 1));

		// Additional Test Cases
		int[] firstEqualsIndex = { 0, 2, 3, 4, 5 };
		// true

		System.out.println("There is an index i that A[i] = i in firstEqualsIndex: "
				+ searchi(firstEqualsIndex, 0, (firstEqualsIndex.length - 1) / 2, firstEqualsIndex.length - 1));

		int[] lastEqualsIndex = { -10, -1, 0, 2, 4 };
		// true

		System.out.println("There is an index i that A[i] = i in lastEqualsIndex: "
				+ searchi(lastEqualsIndex, 0, (lastEqualsIndex.length - 1) / 2, lastEqualsIndex.length - 1));

		int[] evenArraySize = { -5, 1, 3, 4 };
		// true

		System.out.println("There is an index i that A[i] = i in evenArraySize: "
				+ searchi(evenArraySize, 0, (evenArraySize.length - 1) / 2, evenArraySize.length - 1));

		// Feel free to change the test statements

	}
}
