import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Problem17 {
	
	
	
	public static void sortitems(ArrayList<item> svd)
	{
		
		// Sort items by density in descending order
		Collections.sort(svd, new Comparator<item>(){
		     public int compare(item o1, item o2){
		         if(o1.density == o2.density)
		             return 0;
		         return o1.density > o2.density ? -1 : 1;
		     }
		});
		
		
	}
	
	public static double greedyfractionalknapsack(ArrayList<item> svd, int S){
		
		double totalValue = 0;
		int index = 0;
		
		// while knapsack is still available
		while (S > 0) {
			// next highest density item to add
			int NHsize = svd.get(index).size;
			double NHvalue = svd.get(index).value;
			
			// if NH's size exceeds S, add fraction of it
			if (NHsize > S) {
				double Sdouble = S; // necessary to avoid integer division
				totalValue += NHvalue * (Sdouble / NHsize);
				S = 0; 
			} else { // else add it entirely
				totalValue += NHvalue;
				S -= NHsize;
			}
			// move on to next item, loop
			index++;
		}
		
		return totalValue;
	}
	
	
	
	
	public static void main(String[] args) {
		
		int max_size;
      
        ArrayList<item> items = new ArrayList<item>();
		// item 1, value 6, size 1
        items.add(new item(1, 6, 1));
		// item 2, value 10, size 2
		items.add(new item(2, 10, 2));
		// item 3, value 12, size 3
		items.add(new item(3, 12, 3));
		
		// the size of your knapsack
        max_size = 5;  
        
		// sort items by density
		sortitems(items);
 
        System.out.println("The maximum value we can place into the knapsack is "+ greedyfractionalknapsack(items, max_size));



}
	
	
}
