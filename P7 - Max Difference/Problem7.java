class maxDiff {
	int max;
	int min;
	int maxIndex;
	int minIndex;
	int maxDifference;
}

public class Problem7 {

	public static maxDiff findmaxdiff(int[] A, int start, int end) {

		// Complete the method to find the maximum difference between points in A[]
		// so that the larger value appears after the smaller value in A[]
		// feel free to change the return type, parameters
		// Full credit (30 points) will be awarded for a divide-and-conquer algorithm
		// that is O(n).
		// Algorithms that are NOT divide-and-conquer or slower than O(n) will be scored
		// out of 10 points.
		maxDiff test = new maxDiff();

		if (end - start == 1) { // Search Size == 2
			test.max = A[start];
			test.min = A[start];
			test.maxIndex = end;
			test.minIndex = end;
		} else if (end - start == 2) { // Search Size == 3
			if (A[start] < A[end]) {
				test.max = A[end];
				test.min = A[start];
				test.maxIndex = end;
				test.minIndex = start;
			} else {
				test.max = A[start];
				test.min = A[end];
				test.maxIndex = start;
				test.minIndex = end;
			}


		} else {
			maxDiff Left = findmaxdiff(A, start, (start + end) / 2);
			maxDiff Right = findmaxdiff(A, (((start + end) / 2) + 1), end);

			// Candidate Initialization
			// Init to 0 to prevent incorrect q>p logic
			// If Max does not come after Min, MaxDifference autoset to a low number
			int candidate1;
			int candidate2;

			// Checks to see if Max comes after Min for given search size
			if (Left.maxIndex > Left.minIndex) {
				candidate1 = Left.max - Left.min;
			} else {
				candidate1 = 0;
			}
			if (Right.maxIndex > Right.minIndex) {
				candidate2 = Right.max - Right.min;
			} else {
				candidate2 = 0;
			}

			// Create candidate3, no q>p check needed
			int candidate3 = Right.max - Left.min;


			// Checks to find greatest MaxDiff
			if (candidate1 > candidate2) {
				if (candidate1 > candidate3) {
					test.maxDifference = candidate1;
				} else {
					test.maxDifference = candidate3;
				}
			} else if (candidate2 > candidate3) {
				test.maxDifference = candidate2;
			} else {
				test.maxDifference = candidate3;
			}
			
			// Debug Statement
			System.out.print("|" + test.maxDifference + "| ");
		}

		return test;

	}

	public static void main(String[] args) {
		System.out.print("Debug statements -> |maxDiff|\n\n");
		int[] testarray1 = { 2, 3, 10, 6, 4, 8, 1 };
		// maxdiff: 8

		int[] testarray2 = { 7, 9, 1, 6, 3, 2 };
		// maxdiff: 5

		// Add test statements
		System.out
				.println("Max Diff in TestArray1: " + findmaxdiff(testarray1, 0, testarray1.length - 1).maxDifference + "\nCorrect Answer:8 \n");
		System.out
				.println("Max Diff in TestArray2: " + findmaxdiff(testarray2, 0, testarray2.length - 1).maxDifference + "\nCorrect Answer:5");

	}
}
