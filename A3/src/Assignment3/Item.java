package Assignment3;

import java.util.ArrayList;

public class Item extends Driver
{
	// Operation - category - name - price - quantity - weight - option1 - option2
//Declare variables for this class. Think about its type: public, protected or private?
	protected String name1;
	protected Double price1;
	protected Double quantity1;
	protected Double weight1;
	protected Double salestax1;
	protected Double shipping1;
	
	Item(String name, Double price, Double quantity, Double weight){
		name1 = name;
		price1 = price;
		quantity1 = quantity;
		weight1 = weight;
	}
	
	
	
// You will need a constructor (Why?). Create it here.
	
	//public Item()
	float calculatePrice () 
	{
		float final_price = 0;
		// Insert price calculation here
		return final_price;
	}
	

	void printItemAttributes () 
	{
		//Print all applicable attributes of this class
	}

}
