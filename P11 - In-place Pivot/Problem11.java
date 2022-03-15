import java.util.Arrays;

public class Problem11 {

	
	public static void threeway(int[] a) {
		//complete the code from here
		//given an array A[], write a function that re-arrange elements in A[] that pivot and 
		//elements=pivot are placed in the middle, elements < pivot are on the left handside
		// elements > pivot are on the right handside.
		//in-place, O(n) expected
		
		int pivot = a[0]; // Pivot selected to be 1st Element
		int i = 1; // Beginning Index
		int j = a.length - 1; // Ending Index
		int dups = j; // Index that keeps track of where dups will initially be kept (back of array)
		int dummy; // dummy variable for swapping ease
		
		while (i <= j) { // while the indexes dont cross
			while (i < a.length - 1 && a[i] < pivot) {
				i++;
			}
			while (j > 0 && a[j] >= pivot) {
				if (a[j] == pivot) {
					// if duplicate, swap with back
					// since back indexes will already be evaluated
					a[j] = a[dups];
					a[dups] = pivot;
					dups--;
				}
				j--;
			}
			if (i >= j) {
				break;
			}
			// Indexed Elements swap
			dummy = a[j];
			a[j] = a[i];
			a[i] = dummy;
		}
		// Pivot & a[j] swap
		a[0] = a[j];
		a[j] = pivot;
		//System.out.println("Pivot Index: "+j);

		// Now swaps dups in the back with elements next to pivot
		dups = a.length - 1;
		j++; // starting element next to pivot
		while (a[dups] == pivot && j < a.length && dups >= 0) {
			dummy = a[j];
			a[j] = a[dups];
			a[dups] = dummy;
			dups--;
			j++;
			// Predicate necesary to avoid incorrect swaping (j next to dups index)
			if (j > dups) {
				break;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] testarray={1, 2, 2, 2, 6, 1, 7, 0, -5, 2, 8, 1, 3, 1, 1};
		
		System.out.println(Arrays.toString(testarray) + " Original Array");
		// Test your method
		threeway(testarray);
		System.out.print(Arrays.toString(testarray) + " Changed Array\n---\n");
		// Your method should output {0, -5, 1, 1, 1, 1, 1, 2, 6, 7, 2, 2, 2, 8, 3}
		// with all elements = pivot next to pivot, elements<pivot on the left, >pivot on the right
		
		// Additional Test Arrays
		int[] pivotMin={-10, 2, 2, 2, 6, 1, 7, 0, -5, 2, 8, 1, 3, -10, 1};
		int[] pivotMax={100, 2, 2, 2, 6, 1, 7, 100, -5, 2, 8, 1, 3, 1, 1};
		int[] allEqual={6, 6, 6, 6, 6, 6};
		int[] noPivotDups={1, 2, -2, -22, 6, 7, 0, -5, 2, 8, 3};
		
		System.out.println(Arrays.toString(pivotMin) + " pivotMin Array");
		threeway(pivotMin);
		System.out.print(Arrays.toString(pivotMin) + " Changed Array\n---\n");
		System.out.println(Arrays.toString(pivotMax) + " pivotMax Array");
		threeway(pivotMax);
		System.out.print(Arrays.toString(pivotMax) + " Changed Array\n---\n");
		System.out.println(Arrays.toString(allEqual) + " allEqual Array (making sure it doesn't crash)");
		threeway(allEqual);
		System.out.print(Arrays.toString(allEqual) + " Changed Array\n---\n");
		System.out.println(Arrays.toString(noPivotDups) + " noPivotDups Array");
		threeway(noPivotDups);
		System.out.print(Arrays.toString(noPivotDups) + " Changed Array");
		
	}	
}