//Mostapha A
//Assignment 1
//Class for Fruit object

import java.util.Scanner;

/**
 * * 
 * This class contains the definition of the Fruit object 
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 * @author/Mostapha A
 * 
 */
public class Fruit extends FoodItem{
	/**
	 * The name of the orchard that provides the fruit
	 */
	private String orchardName;
	
	/**
	 * Constructor for a food item of type fruit
	 */
	public Fruit() {
		
	}
	
	/**
	 * Returns a string of the item and its attribute.
	 * @return Returns the string of the item.
	 */
	public String toString() {
		String item;
		// call super and add to the string
		item = super.toString() + " orchard supplier: " + orchardName + "\n";
		
		// return the string
		return item;
	}
	
	/**
	 * Add a food item, call super method then add farm name
	 * @param scanner The scanner to read input
	 * @return Returns whether it was successful or not
	 */
	public boolean addItem(Scanner scanner) {
		Boolean returnVal;
		
		// call super method
		returnVal = super.addItem(scanner);
		
		//ask for farm name
		scanner.nextLine();
		System.out.print("Enter the name of the orchard supplier: ");
		orchardName = scanner.nextLine();
		
		return returnVal;
	}

}
