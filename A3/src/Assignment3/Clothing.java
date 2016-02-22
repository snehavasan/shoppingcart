package Assignment3;

public class Clothing extends Item 
{
	Clothing(String name, Double price, Double quantity, Double weight){
		super (name,price,quantity,weight);
		//implement tax and regular shipping cost and add to final cost;
	}

	// variables, constructors as necessary
	
	float calculatePrice () 
	{
		float final_price = 0;
		// Insert price calculation here
		return final_price;
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this sub-class
	}
	

}
