
public class Problem4 {

	public static int squareroot(int x) {
		// given a positive integer x, return square root of x
		// if x is not a perfect square, return the floor of its square root
		// complete the method squareroot() here
		// O(log n) expected
		// O(n) or slower will be graded out of 5 points
		// feel free to change the return type or parameters

		// Call the recursive method with the following parameters:
		// x: Input Value, 0: Start Range, x-1: End Range
		return squarerootRec(x, 0, x - 1);

	}

	public static int squarerootRec(int x, int start, int end) {

		// Without this check, it will compute 1's sqrt as 0
		if (x == 1) {
			return x;
		}
		int mid = (start + end) / 2;

		// Checks if "search size" is invalid OR if the current square is accurate & the following is > x
		// The logic after the OR is specifically designed for odd number perfect squares
		// It avoids invalidly rounding down for odd perfect squares
		if (start > end || (mid * mid <= x && (mid * mid) + mid > x)) { 											
			return mid;
		}
		if (mid * mid < x) {
			return squarerootRec(x, (mid + 1), end);
		} else {
			return squarerootRec(x, start, mid - 1);
		}

	}

	public static void main(String[] args) {
		// test your count() method here
		
		int x1 = 8;
		int x2 = 5;
		int x3 = 17;
		System.out.println("The square root of " + x1 + " is " + squareroot(x1));
		System.out.println("The square root of " + x2 + " is " + squareroot(x2));
		System.out.println("The square root of " + x3 + " is " + squareroot(x3));

		// Additional Test Cases
		
		int oddPerfSquare = 49;
		int evenPerfSquare = 1024;
		int ifOne = 1;
		int ifZero = 0;
		System.out.println("The square root of " + oddPerfSquare + " is " + squareroot(oddPerfSquare));
		System.out.println("The square root of " + evenPerfSquare + " is " + squareroot(evenPerfSquare));
		System.out.println("The square root of " + ifOne + " is " + squareroot(ifOne));
		System.out.println("The square root of " + ifZero + " is " + squareroot(ifZero));
	}

}
