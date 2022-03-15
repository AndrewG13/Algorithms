import java.util.Scanner;

public class Problem16 {

	public static int greedycoinchange(int givenvalue, int[] givencoins) {
	
		int totalQuantity = 0; // total coins answer, return value
		int coinQuantity; // to keep track of current quantity of currrent denomination
		int pointer = 0; // index pointer for givencoins[]
		
		// while givenvalue has not been made
		// (current coins sum != givenvalue)
		while (givenvalue != 0) {
			// Find out how many current denemination coins can go into givenvalue
			coinQuantity = givenvalue / givencoins[pointer];
			
			// Add computated coin quantity to the total
			totalQuantity += coinQuantity;
			
			// Minus out current denomination from givenvalue
			givenvalue -= coinQuantity * givencoins[pointer];
			
			// Move on to next denomination
			pointer++;
		}
		
		return totalQuantity;
	}
	
	
	public static void main(String[] args) {

		int n = 0; // To make a change of n cents
		
		Scanner reader = new Scanner(System.in);  
		
		System.out.println("Please enter the value you want to make change: ");
		
		n = reader.nextInt();
		
		// Infinite supply of quarters, dimes, nickles, and pennies
		int[] coins = {25, 10, 5, 1}; //Sorted already
		
		
		System.out.println("The greedycoinchange algorithm uses "+ greedycoinchange(n, coins)+" coins for "+ n + " cents");
		
		reader.close();
		
	}

}
