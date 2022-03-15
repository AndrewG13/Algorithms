
public class Problem2 {

	/*
	 * Andrew Giardina, CMPT 435L 111 20F, Due 9/3/2020
	 */

	/**
	 * missingnumber Method
	 * 
	 * Receives an int array with elements 1-n except missing one number
	 * Iterates through the array until the missing number is found
	 * Returns the missing number
	 * 
	 * @param A
	 * @return testNumber
	 */
	public static int missingnumber(int[] A) {

		int testNumber = 1;
		
		while (testNumber - 1 < A.length) {

			boolean found = false;
			for (int index = 0; index < A.length && !found; index++) {
				if (A[index] == testNumber) {
					found = true;
				}
			}

			if (!found) {
				// System.out.print("Not found throughout list");
				return testNumber;
			}
			testNumber++;

		}
		// System.out.print("End of test, should be last int");
		return testNumber;
	}

	public static void main(String[] args) {

		// Additional Test Cases
		
		// Tests for missing number being the first element
		//int[] testarray1 = { 2, 5, 3, 4 };
		
		// Tests for missing number being the last element
		//int[] testarray1 = { 4, 3, 1, 2 };

		int[] testarray1 = { 2, 4, 1, 6, 3, 7, 8 };

		int[] testarray2 = { 6, 3, 4, 5, 1 };

		//System.out.println("The missing number in testarray1 " + missingnumber(testarray1));
		//System.out.println("The missing number in testarray2 " + missingnumber(testarray2));

	}

}
