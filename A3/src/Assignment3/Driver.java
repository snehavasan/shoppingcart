package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.text.DecimalFormat;


public class Driver 
	{

	ArrayList<Item> shopcart = new ArrayList<Item>();
	  public static void main(String[] args) 
	  {

			if (args.length != 1) 
			{
				System.err.println ("Error: Incorrect number of command line arguments");
				System.exit(-1);
			}
			processLinesInFile (args[0]);
		// TODO Auto-generated method stub
		
		//Open file; file name specified in args (command line)
		
		//Parse input, take appropriate actions.
		
		//Stub for arraylist.
		ArrayList<Item> shoppingCart = new ArrayList<Item>(); 
		
		// General code example for how to iterate an array list. You will have to modify this heavily, to suit your needs.
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) 
		{
			Item temp = i.next();
			temp.calculatePrice(); 
			temp.printItemAttributes();
			//This (above) works because of polymorphism: a determination is made at runtime, 
			//based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
			// of Grocery, it will invoke the calculatePrice () method defined in Grocery.
		}		
	  }
	  
		public static void processLinesInFile (String filename) 
		{ 

			Driver processor = new Driver(); 
			try 
			{
				FileReader freader = new FileReader(filename);
				BufferedReader reader = new BufferedReader(freader);
				
				for (String s = reader.readLine(); s != null; s = reader.readLine()) 
				{
					String output = processor.process(s);
					System.out.println(output);
				}
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println ("Error: File not found. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			} catch (IOException e) 
			{
				System.err.println ("Error: IO exception. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			}
		}
		// Process the strings in this 
		public String process (String inputString){
			String output = new String(inputString);
			String[] array = inputString.split(" ");
			Double quantity = (double) 0;
			Double weight = (double) 0;
			String state = null;
			String FNF = null;
			String name = null;
			int size = array.length;
			int cart_length = 0;
			//Check for correct number of arguments
			if (size <= 8){
				
			// Operation - category - name - price - quantity - weight - option1 - option2
			for (int i = 0; i<size; i++){
				String operation = array[0].toLowerCase();
				
				// Insert operation
				if (operation.matches("insert")){
					name = array[2];
					String category = array[1].toLowerCase();
					
					//Price conversion to dollar amount
					DecimalFormat twospaces = new DecimalFormat("0.00");
					Double price1 = Double.parseDouble(array[3]);
					Double price = new Double(twospaces.format(price1));
					
					//Quantity Check for whole number
					String pattern = "[0-9]*";
					String quantity1 = array[4];
					boolean quantmatch = Pattern.matches(pattern , quantity1);
					if (quantmatch){
					quantity = Double.parseDouble(array[4]);
					}
					else {
						output = "Input value for quantity is negative or not a whole number";
						break;
					}
					
					//Weight Check for whole number
					String weight1 = array[5];
					boolean weightmatch = Pattern.matches(pattern, weight1);
					if (weightmatch){
						weight = Double.parseDouble(array[5]);
					}
					else {
						output = "Input value for weight is negative or not a whole number";
						break;
					}
					
					// Insert Clothing
					if (category.matches("clothing")){
						if (size > 6){
							output = "Input value for clothing contains optional fields";
							break;
						}
						else {
							Item product = new Clothing(name,price,quantity,weight);
							shopcart.add(product);
							output = "Added "+quantity+" "+name+" into the shopping cart";
							break;
						}
					}
					
					// Insert Electronics
					else if (category.matches("electronics")){
						FNF = array[6].toUpperCase(); // Fragile/non-fragile or Perishable/non-perishable
						state = array[7].toUpperCase(); // US state
						state = state.toUpperCase();
						String all_states = "AL AS AR CA NM TX VA AZ AK CO CT DE DC FL GA GU HI ID IL IN IA KS KY LA ME MD MH MH MA MI FM MN MS MO MT NE NV NH NJ NY NC ND MP OH OK OR PW PA PR RI SC SD TN UT VT VI WA WV WI WY";
						if (all_states.contains(state)){
							if (FNF.contains("F") || FNF.contains("NF")){
								Item product = new Electronics(name,price,quantity,weight, FNF, state);
								shopcart.add(product);
								output = "Added "+quantity+" "+name+" into the shopping cart";
								break;
							}
							else {
								output = "Input value for optional field 1 is invalid";
								break;
							}
						}
						else {
							output = "Invalid US state entered in the input";
						}
						
					}
					
					// Insert Grocery
					else if (category.matches("groceries")){
						FNF = array[6].toUpperCase(); // Fragile/non-fragile or Perishable/non-perishable
						if (FNF.contains("P") || FNF.contains("NP")){
							Item product = new Grocery(name,price,quantity,weight, FNF);
							shopcart.add(product);
							output = "Added "+quantity+" "+name+" into the shopping cart";
							break;
							
						}
						else {
							output = "Input value for optional field 1 is invalid";
							break;
						}
						
					}
					else { 
						output = "Input value for category is invalid";
						break;
					}
					// Sorting the items in Array in ascending order
				}
				
				// Search operation
				else if (operation.matches("search")){
					if (size == 2){
						cart_length = shopcart.size();
						name = array[1];
						for (int j =0; j<cart_length; j++){
							String namecheck = shopcart.get(j).getName1();
							if (namecheck.matches(name)){
								quantity = quantity + shopcart.get(j).getQuantity1();
							}
							
						}
						output = "The quantity of "+name+" found in cart is "+quantity+"";
						break;
					}
					else {
						output = "Input is invalid";
						break;
					}
					
				}
				
				
				// Delete operation	
				else if (operation.matches("delete")){
					if (size == 2){
						cart_length = shopcart.size();
						name = array[1];
						int zero = 0;
						int k = cart_length - 1;
						while (k>-1){
							String namecheck = shopcart.get(k).getName1();
							if (namecheck.matches(name)){
								quantity = quantity + shopcart.get(k).getQuantity1();
								shopcart.remove(k);
							}
							k--;
						}
						output = "The quantity of "+name+" deleted from cart is "+quantity+"";
					}
					else {
						output = "Input is invalid";
					}
					
				}
				
				// Update operation
				else if (operation.matches("update")){
					if (size == 3){
						boolean present = false;
						cart_length = shopcart.size();
						name = array[1];
						// Whole number check
						String pattern = "[0-9]*";
						String quantity1 = array[2];
						boolean quantmatch = Pattern.matches(pattern , quantity1);
						if (quantmatch){
						quantity = Double.parseDouble(array[2]);
						}
						else {
							output = "Input value for quantity is negative or not a whole number";
							break;
						}
						for (int l =0; l<cart_length;l++){
							String namecheck = shopcart.get(l).getName1();
							if (namecheck.contains(name)){
								shopcart.get(l).setQuantity1(quantity);
								quantity = shopcart.get(l).getQuantity1();
								output = "Update complete. Now the cart has "+quantity+" "+name+"";
								present = true;
								break;
							}
						}
						if (!present){
							output = "Update cannot be completed because "+name+" does not exist in the cart";
						}
						break;
						
					}
					else {
						
					}


					
				}
				else if (operation.matches("print")){
					Collections.sort(shopcart, new Comparator<Item>(){
						@Override
						public int compare(Item first1, Item first2){
							String name3 = first1.name1.toLowerCase();
							String name4 = first2.name1.toLowerCase();
							return name3.compareTo(name4);
						}
					});
					
					
				}
				else {
					output = "Invalid operation";
					break;
				}
			}	
			}
			else {
				output = "Invalid Input";
			}	
			
			
			
			return output;
			
			
		}
		

}
