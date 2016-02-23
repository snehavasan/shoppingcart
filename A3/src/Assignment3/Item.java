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
	protected float finalprice1;
	
	Item(String name, Double price, Double quantity, Double weight){
		name1 = name;
		price1 = price;
		quantity1 = quantity;
		weight1 = weight;
	}
	
	
	
	
	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}




	/**
	 * @return the price1
	 */
	public Double getPrice1() {
		return price1;
	}




	/**
	 * @return the quantity1
	 */
	public Double getQuantity1() {
		return quantity1;
	}




	/**
	 * @return the weight1
	 */
	public Double getWeight1() {
		return weight1;
	}




	/**
	 * @return the salestax1
	 */
	public Double getSalestax1() {
		return salestax1;
	}




	/**
	 * @return the shipping1
	 */
	public Double getShipping1() {
		return shipping1;
	}




	/**
	 * @return the finalprice
	 */
	public float getFinalprice1() {
		return finalprice1;
	}




	/**
	 * @param name1 the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}




	/**
	 * @param price1 the price1 to set
	 */
	public void setPrice1(Double price1) {
		this.price1 = price1;
	}




	/**
	 * @param quantity1 the quantity1 to set
	 */
	public void setQuantity1(Double quantity1) {
		this.quantity1 = quantity1;
	}




	/**
	 * @param weight1 the weight1 to set
	 */
	public void setWeight1(Double weight1) {
		this.weight1 = weight1;
	}




	/**
	 * @param salestax1 the salestax1 to set
	 */
	public void setSalestax1(Double salestax1) {
		this.salestax1 = salestax1;
	}




	/**
	 * @param shipping1 the shipping1 to set
	 */
	public void setShipping1(Double shipping1) {
		this.shipping1 = shipping1;
	}




	/**
	 * @param finalprice the finalprice to set
	 */
	public void setFinalprice1(float finalprice) {
		this.finalprice1 = finalprice;
	}




	// Need to calculate the final cost here per item
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
