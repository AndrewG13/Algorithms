
public class Problem6 {

	
	public static boolean majority(int[] A)
	{
		/*
		Input: an array A of n integers (positive, negative, or 0), elements sorted in ascending order.
		Output: if there exists a majority element.
		An element is a majority if it appears more than n/2 times. For example, if the input list is: 
		{0, 0, 0, 0, 0, 0, 1, 1, 2, 4, 7}
		The output should be true, as 0 appears 6 times (>n/2 = 11/2 times).
		However, if the input list is:
		{0, 0, 0, 1, 1, 2, 3, 10, 10}
		The majority element does not exist.
		Design an algorithm that solves this problem.
		*/
		// O(log n) expected
		// O(n) or slower will be graded out of 5 points
		// feel free to change the return type or parameters
		
		// Complete this method
		
		
		// Find the first & last occurrences of the mid element to compute total occurences 
		int firstIndex = countRecFirst(A, A[A.length/2], 0, A.length - 1);
		int lastIndex = countRecLast(A, A[A.length/2], 0, A.length - 1);
		//System.out.print(lastIndex + "-" + firstIndex + " + 1 > " + (A.length/2));
		
		// If mid-freq > n/2, true.  Else, false.
		if ((lastIndex - firstIndex) + 1 > A.length/2) {
			return true;
		} else {
		return false;
		}
	}
	public static int countRecFirst(int[] A, int x, int start, int end) {
		int mid = (start+end)/2;
		
		if (start > end) {
			return -1; // not found
		}
		if (x == A[mid] && (mid == 0 || A[mid-1] != x )) {
			return mid; // found first occurence
		} else if (x > A[mid]) {
			return countRecFirst(A, x, mid+1, end);
		} else {
			return countRecFirst(A, x, start, mid-1);
		}
	}
	
	public static int countRecLast(int[] A, int x, int start, int end) {
		int mid = (start+end)/2;
		
		if (start > end) {
			return -1; // not found
		}
		if (x == A[mid] && (mid == A.length - 1 || A[mid+1] != x )) {
			return mid; // found last occurence
		} else if (x > A[mid]) {
			return countRecLast(A, x, mid+1, end);
		} else {
			return countRecLast(A, x, start, mid-1);
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Test your majority method
		
		int[] testarray1 = {0, 0, 0, 0, 0, 0, 1, 1, 2, 4, 7};
		
		int[] testarray2 = {0, 0, 0, 1, 1, 2, 3, 10, 10};
		
		
		System.out.println("Does there exist a majoirty element in testarray1? "+ majority(testarray1));
		// True, 0 occurs 6 times, more than half of the array 
		System.out.println("Does there exist a majoirty element in testarray2? "+ majority(testarray2));
		// False 
	}

}
