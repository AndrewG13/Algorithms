public class Problem15 {
	
	public static boolean subsetSum(int[] A, int x) {
		
		int n = A.length;
		boolean[][] Sum = new boolean[n + 1][x + 1];

		// Can make a sum = 0 with a 0 range of elements
		// (i,j = 0)
		Sum[0][0] = true;
		
		// Can make empty subset through all i-ranges for zero sum 
		// (j = 0)
		for (int index = 1; index < n + 1; index++) {
			Sum[index][0] = true;
		}
		
		// Cannot make a sum > 0 when there is no elements in the range 
		// (i = 0)
		for (int index = 1; index < x + 1; index++) {
			Sum[0][index] = false;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < x + 1; j++) {
				if (A[i - 1] > j) {
					Sum[i][j] = Sum[i - 1][j]; 
				} else {
					Sum[i][j] = Sum[i - 1][j] || Sum[i - 1][j - (A[i - 1])];
				}
			}
		}

		// Unblock this to print the finished matrix
		
		
		  printMatrix(n, x, Sum);
		 
		
		// Output: If there exists within the n range of A[] a subset sum = x
		return Sum[n][x]; 
	}

	/*
	 * Optional Method to Print the finished Subset Sum Matrix
	 */
	public static void printMatrix(int n, int x, boolean[][] Sum) {
		char f = 'F';
		char t = 'T';
		System.out.print("Matrix for "+ n +" elements, "+ x +" Sum Range\n------\n   ");
		for (int j = 0; j < x + 1; j++) {
			System.out.print(j + " ");
		}
		System.out.println();
		for (int i = 0; i < n + 1; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < x + 1; j++) {
				if (Sum[i][j]) {
					System.out.print(t + " ");
				} else {
					System.out.print(f + " ");
				}
			}
			System.out.println();
		}
		System.out.println("------\n");
	}
	
	public static void main(String[] args) {
		
		int[] A = {1,3,5,2,8};
		
		int x = 9;
		
		System.out.println("There exists a subset in A[] with sum = " + x + " : " + subsetSum(A, x) );
		// Expected output: true
		
		System.out.println("\nAdditional Test Case (should be False)\n");
		int[] B = {1,8,2,5};
		
		int y = 4;
		
		System.out.println("There exists a subset in A[] with sum = " + y + " : " + subsetSum(B, y) );
		// Expected output: false
		
		System.out.println("\nAdditional Test Case (should be True)\n");
		int[] C = {12, 1, 3, 8,2,5};
		
		int z = 10;
		
		System.out.println("There exists a subset in A[] with sum = " + z + " : " + subsetSum(C, z) );
		// Expected output: false
	}

}
