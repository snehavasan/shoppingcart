package Assignment3;

public class Grocery extends Item {
	Grocery(String name, Double price, Double quantity, Double weight, String FNF){
		super (name,price,quantity,weight);
		if (FNF.contains("P")){
			//implement sales tax
			//calculate price with premium shipping and update to shipping cost and final price
		}
		else {
			//implement sales tax
			//calculate price with regular shipping and update to shipping cost and final price
		}
	}
	//variables, constructor here
	
	//override calculatePrice() if necessary; Implement print methods as necessary	
	// Only re-implement stuff you cannot get from the superclass (Item)
	
}
