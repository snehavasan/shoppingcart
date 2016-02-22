package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

public class Driver 
	{
	ArrayList<String> shopcart = new ArrayList<>();

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
			int size = array.length;
			//Check for correct number of arguments
			if (size <= 8){
				
			// Operation - category - name - price - quantity - weight - option1 - option2
			for (int i = 0; i<size; i++){
				String name = array[2];
				String FNF = array[6].toUpperCase(); // Fragile/non-fragile or Perishable/non-perishable
				String state = array[7].toUpperCase(); // US state
				
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
				
				String operation = array[0].toLowerCase();
				
				// Insert operation
				if (operation.matches("insert")){
					String category = array[1].toLowerCase();
					if (category.matches("clothing")){
						if (size != 0){
							output = "Input value for clothing contains optional fields";
							break;
						}
						else {
							
						}
					}
					else if (category.matches("electronics")){
						if (FNF.contains("F") || FNF.contains("NF")){
							
						}
						else {
							output = "Input value for optional field 1 is invalid";
							break;
						}
						
					}
					else if (category.matches("groceries")){
						if (FNF.contains("P") || FNF.contains("NP")){
							
						}
						else {
							output = "Input value for optional field 1 is invalid";
							break;
						}
						
					}
					else { 
						output = "Inlvaid Input";
						break;
					}
				}
				else if (operation.matches("search")){
					
				}
				else if (operation.matches("delete")){
					
				}
				else if (operation.matches("update")){
					
				}
				else if (operation.matches("print")){
					
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
