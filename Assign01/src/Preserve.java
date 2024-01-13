// Mostapha A
// Assignment 1
// Class for Preserve object

import java.util.Scanner;

/**
 * * 
 * This class contains the Preserve object definition 
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 * @author/Mostapha A
 * 
 */
public class Preserve extends FoodItem {
	/**
	 * The size of the jar for the preserve
	 */
	private int jarSize;
	
	/**
	 * Constructor for a food item of type preserve
	 */
	public Preserve(){
		
	}
	
	/**
	 * Returns a string of the item and its attribute.
	 * @return Returns the string of the item.
	 */
	public String toString() {
		String item;
		// call super and add to the string
		item = super.toString() + " size: " + jarSize + "mL\n";
		
		// return the string
		return item;
	}
	
	/**
	 * Add a food item, call super method then add jar size
	 * @param scanner The scanner to read input
	 * @return Returns whether it was successful or not
	 */
	public boolean addItem(Scanner scanner) {
		Boolean returnVal;

		// call super method
		returnVal = super.addItem(scanner);

		// ask for the jar size
		do {
			System.out.print("Enter the size of the jar in millilitres: ");

			// if input is an int, store
			if (scanner.hasNextInt()) {
				jarSize = scanner.nextInt();
				returnVal = true;
			} else {
				// clear input
				scanner.next();
				jarSize = -1;
			}

			// check range
			if (jarSize < 1) {
				System.out.println("Invalid entry");
				jarSize = -1;
				returnVal = false;
			}

		} while (jarSize == -1);
		
		return returnVal;
	}

}
