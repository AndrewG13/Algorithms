
public class Problem8 {

	public static Max2ndMax dcfindmax2ndmax(int[] A, int start, int end) {
		Max2ndMax test = new Max2ndMax();
		// Complete this method to find max and 2nd max in an array A
		// At most 3n/2-2 comparisons
		// Algorithms that make more than 3n/2-2 comparisons will be scored out of 10
		// points
		// Complete the code from here
		// Feel free to change method type, parameters

		if (end == start) { // if size is 1
			test.max = A[end];
			test.max2nd = A[end]; // 0: This is needed to avoid invalid comparison 
			return test;
		} else if (end - start == 1) { // if size is 2
			if (A[start] < A[end]) {
				test.max2nd = A[start];
				test.max = A[end];
			} else {
				test.max2nd = A[end];
				test.max = A[start];
			}
			return test;
		} else {
			Max2ndMax Left = dcfindmax2ndmax(A, start, (start + end) / 2);
			Max2ndMax Right = dcfindmax2ndmax(A, (((start + end) / 2) + 1), end);

			int maxL = Left.max;
			int maxR = Right.max;
			int m2ndL = Left.max2nd;
			int m2ndR = Right.max2nd;

			int otherMax; // Variable to store other Max (not TrueMax)
			int trueMax;
			int true2nd; // Test Variable, will become the True 2ndMax.

			if (maxL > maxR) {
				trueMax = maxL;
				true2nd = m2ndL;
				otherMax = maxR;
			} else {
				trueMax = maxR;
				true2nd = m2ndR;
				otherMax = maxL;
			}
			if (otherMax > true2nd) { // Checks if other Max > TrueMax's 2ndMax
				true2nd = otherMax;
			}
			test.max = trueMax;
			test.max2nd = true2nd;

		}

		return test;
	}

	public static void main(String[] args) {

		int[] givenarray = { 100, 2, 3, 4, 5, 6, 7, 67, 2, 32 };
		int[] givenarray2 = { 1, 600, 2, 3, 4, 5, 6, 1, 400, 7, 67, 2, 32 };
		int[] givenarray3 = { 100, 2, 3, 4, 5, 6, 200, 500, 7, 67, 2, 32, 450 };

		// Test your method
		Max2ndMax pair = new Max2ndMax();
		pair = dcfindmax2ndmax(givenarray, 0, givenarray.length - 1);
		int max2nd = pair.max2nd;
		int max = pair.max;
		System.out.println("The max and 2ndmax of the given array are " + max + " and " + max2nd + ".");
		// Your method should return 100 and 67

		Max2ndMax pair2 = new Max2ndMax();
		pair2 = dcfindmax2ndmax(givenarray2, 0, givenarray2.length - 1);
		max2nd = pair2.max2nd;
		max = pair2.max;
		System.out.println("The max and 2ndmax of the given array2 are " + max + " and " + max2nd + ".");
		// Your method should return 600 and 400

		Max2ndMax pair3 = new Max2ndMax();
		pair3 = dcfindmax2ndmax(givenarray3, 0, givenarray3.length - 1);
		max2nd = pair3.max2nd;
		max = pair3.max;
		System.out.println("The max and 2ndmax of the given array3 are " + max + " and " + max2nd + ".");
		// Your method should return 500 and 450

	}

}