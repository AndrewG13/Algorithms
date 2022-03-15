
public class item {
	public int id;
	public double value;
	public int size;
	public double density;
	
	// Constructor
	public item (int givenid, double givenvalue, int givensize) {
		id = givenid;
		size = givensize;
		value = givenvalue;
		density = value/size;
	}
	
}
