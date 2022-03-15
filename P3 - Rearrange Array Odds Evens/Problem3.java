
public class Problem3 {

	/*
	 * Andrew Giardina, CMPT 435L 111 20F, Due 9/3/2020
	 */


	/**
	 * rearrange Method
	 * 
	 * Receives an int[] array, and rearranges it such that:
	 * All Even elements are less than its "neighbors"
	 * All Odd elements are greater than its "neighbors"
	 * A[0] <= A[1] >= A[2] <= A[3] >= A[4] <= A[5]...
	 * 
	 * If A.length <= 2, there is no need to rearrange
	 * 
	 * @param A
	 */
	public static void rearrange(int[] A) {

		// Test case for A.length > 2
		if (A.length > 2) {
			for (int index = 1; index < A.length - 1; index++) {
				A[index + 1] += A[index];
				A[index] = A[index + 1] - A[index];
				A[index + 1] = A[index + 1] - A[index];
				// Extra index++ needed for incrementing by 2
				index++;
			}
		}

	}

	public static void main(String[] args) {

		// Additional Test Cases

		// Tests for Odd amount of elements
		// int[] A = {13, 20, 45, 69, 78, 100, 127};

		// Tests for negative valued elements
		// int[] A = {-100, -75, -50, 0, 20, 50, 100};

		int[] A = { 13, 20, 45, 69, 78, 100, 127, 155 };

		System.out.println("Before:");

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

		rearrange(A);

		System.out.println("\nAfter:");

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

	}

}
