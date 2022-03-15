
public class Problem1 {

	/*
	 * Andrew Giardina, CMPT 435L 111 20F, Due 9/3/2020
	 */


	/**
	 * rearrange Method
	 * 
	 * Rearranges the array received such that:
	 * A[0] is the "Pivot" number
	 * All elements' value =< Pivot will be on the left side of Pivot
	 * All elements' value > Pivot will be on the right side of Pivot
	 * 
	 * @param A
	 */
	public static void rearrange(int[] A) {
		int[] B = new int[A.length];

		// To keep track of the left-most available B[] index
		int B_front = 0;
		// To keep track of the right-most available B[] index
		int B_end = B.length - 1;

		// i = 1 to avoid needlessly checking A[0] to itself
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[0]) {
				B[B_end] = A[i];
				B_end--;
			} else {
				B[B_front] = A[i];
				B_front++;
			}
		}

		// Fill in missing "x" value
		B[B_end] = A[0];

		// Cloning B[] to A[]
		for (int index = 0; index < A.length; index++) {
			A[index] = B[index];
		}

	}

	public static void main(String[] args) {

		// Additional Test Cases
		
		// Tests "x" being the lowest value
		//int[] A = { 1, 5, 6, 3, 8, 5};
		
		// Tests "x" being the highest value
		//int[] A = { 8, 5, 1, 3, 7 };
		
		// Tests having duplicate elements == "x"
		//int[] A = { 4, 4, 3, 1, 2, 7, 4, 6, 5, 4};
		
		int[] A = { 4, 3, 9, 2, 7, 6, 5 };

		System.out.println("Before rearrangement:");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");

		}

		rearrange(A);

		System.out.println("\nAfter rearrangement:");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");

		}

	}

}
