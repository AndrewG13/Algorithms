public class Superbowl {
    
	public static void main(String[] args) {
		generateNumbers();
	}
	
	public static void generateNumbers() {
            System.out.print("   ");

	    // Initialize variables
            int range = 10; // range of scores 0-9
	    boolean[] rows = new boolean[range];
	    boolean[] cols = new boolean[range];
	    int random;
	    
	    //  Run the Rows
	    for (int i = 0; i < range; i++) {
	        // Generate a random number between 0-9
	        random = (int)( Math.random() * (range) );
	        
	        // Check if number has already been used.
	        // If so, continue generating & checking new numbers
	        while (rows[random] == true) {
	            random = (int)( Math.random() * (range) );
	        }
	        
	        // Display number
	        System.out.print("[" + random + "]  ");
	        
	        // Set number as used
	        rows[random] = true;
	    }
	    
	    //  Run the Columns
	    for (int i = 0; i < range; i++) {
	        // Generate a random number between 0 - 9
	        random = (int)( Math.random() * (range) );
	        
	        // Check if number has already been used.
	        // If so, continue generating & checking new numbers
	        while (cols[random] == true) {
	            random = (int)( Math.random() * (range) );
	        }
	        
	        // Display number
	        System.out.print("\n[" + random + "] \n");
	        
	        // Set number as used
	        cols[random] = true;
	    }
	}
}
