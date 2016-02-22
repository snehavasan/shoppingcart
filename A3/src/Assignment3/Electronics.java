package Assignment3;

public class Electronics extends Item 
{

	Electronics(String name, Double price, Double quantity, Double weight, String FNF , String state){
		super (name,price,quantity,weight);
		if (FNF.contains("F")){
			//calculate price with premium shipping and update to shipping cost and final price
			if (state.contains("NM") || state.contains("TX") || state.contains("VA")
			|| state.contains("AZ") || state.contains("AK")){
				
				//No sales tax
				
			}
			else {
				//implement 10% sales tax and add to final price in item
			}
		}
		else {
			//calculate price with regular shipping and update to shipping cost and final price
		}
	}

	// Variables, constructors etc. here.
	
	//Implement calculate price/print methods as necessary

}
