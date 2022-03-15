
public class Problem5 {

	public static int count(double[] A, double x) {
		// given sorted array A, and a value x, return the number of times x occurs in A
		// complete the method count() here
		// O(log n) expected
		// O(n) or slower will be graded out of 5 points
		// feel free to change the return type or parameters

		int firstIndex = countRecFirst(A, x, 0, A.length - 1);
		int lastIndex = countRecLast(A, x, 0, A.length - 1);

		// if x is not in the array, return 0
		if (firstIndex == -1 && lastIndex == -1) {
			return 0;
		} else {
		// return number of occurences
			return (lastIndex - firstIndex) + 1;
		}

	}

	public static int countRecFirst(double[] A, double x, int start, int end) {

		if (start > end) {
			return -1; // not found
		}
		int mid = (start + end) / 2;

		if (x == A[mid] && (mid == 0 || A[mid - 1] != x)) {
			return mid; // found first occurence
		} else if (x > A[mid]) {
			return countRecFirst(A, x, mid + 1, end);
		} else {
			return countRecFirst(A, x, start, mid - 1);
		}
	}

	public static int countRecLast(double[] A, double x, int start, int end) {

		if (start > end) {
			return -1; // not found
		}
		int mid = (start + end) / 2;

		if (x == A[mid] && (mid == A.length - 1 || A[mid + 1] != x)) {
			return mid; // found last occurence
		} else if (x > A[mid]) {
			return countRecLast(A, x, mid + 1, end);
		} else {
			return countRecLast(A, x, start, mid - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your count() method here

		double[] testarray = { 1.3, 2.1, 2.1, 2.1, 2.1, 6.7, 7.5, 7.5, 8.6, 9.0 };
		double t1 = 2.1;
		double t2 = 7.5;
		double t3 = 1.3;
		System.out.println(t1 + " appears " + count(testarray, t1) + " times");
		System.out.println(t2 + " appears " + count(testarray, t2) + " times");
		System.out.println(t3 + " appears " + count(testarray, t3) + " times");

		// Additional Test Case: x Not in Array
		double notInArray = 99.9;
		System.out.println(notInArray + " appears " + count(testarray, notInArray) + " times");

	}

}
