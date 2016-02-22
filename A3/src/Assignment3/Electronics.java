package Assignment3;

public class Electronics extends Item 
{

	Electronics(String name, Double price, Double quantity, Double weight, String FNF , String state){
		super (name,price,quantity,weight);
		String FNF1 = FNF;
		String state1 = state;
		if (FNF1.contains("F")){
			//calculate price with premium shipping and update to shipping cost
			if (state1.contains("NM") || state1.contains("TX") || state1.contains("VA")
			|| state1.contains("AZ") || state1.contains("AK")){
				
				//No sales tax
				
			}
			else {
				//asldkjasd
				//implement 10% sales tax
			}
		}
		else {
			//calculate price with regular shipping and update to shipping cost
		}
	}

	// Variables, constructors etc. here.
	
	//Implement calculate price/print methods as necessary

}
