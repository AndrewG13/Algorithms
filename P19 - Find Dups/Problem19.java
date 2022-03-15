
public class Problem19 {

	public static boolean findDups(int[] array) {
		boolean found = false;
		
		for (int index = 0; index < array.length; index++) {
			if (found) 
				break;
				for (int others = index + 1; others < array.length; others++) {
					if (array[index] == array[others]) {
						found = true;
						break;
					} // end if
				} // end inner for
		} // end outer for
		return found;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3,1}; // true
		int[] arr2 = {1,2,3,4}; // false
		int[] arr3 = {1,1,1,3,3 // true
				,4,3,2,4,2};
		int[] arr4 = {0,1};     // false
		int[] arr5 = {0};       // false
		int[] arr6 = {};        // false
		
		System.out.println(findDups(arr1));
		System.out.println(findDups(arr2));
		System.out.println(findDups(arr3));
		System.out.println(findDups(arr4));
		System.out.println(findDups(arr5));
		System.out.println(findDups(arr6));

	}

}
