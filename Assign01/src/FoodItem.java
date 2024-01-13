//Mostapha A
//Assignment 1
//Class for FoodItem object

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * *
 * This class contains the definition of the FoodItem object 
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 * @author/Mostapha A
 * 
 */
public class FoodItem {
	/**
	 * The code for the item
	 */
	protected int itemCode;
	/**
	 * The name of the item
	 */
	private String itemName;
	/**
	 * The price of the item
	 */
	private float itemPrice;
	/**
	 * The quantity available in stock
	 */
	private int itemQuantityInStock;
	/**
	 * The cost of the item
	 */
	private float itemCost;
	
	/**
	 * Constructor for FoodItem
	 */
	public FoodItem() {
		
	}
	
	/**
	 * Returns the item as a string
	 * @return The string of information
	 */
	public String toString() {
		// for formatting
		DecimalFormat format = new DecimalFormat("0.00");
		String item;
		
		// create a string with the values
		item = "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $" + format.format(itemPrice) + " cost: $" + format.format(itemCost);
		
		return item;
	}

	/**
	 * Add a food item
	 * @param scanner The scanner to read input
	 * @return Returns whether it was successful or not
	 */
	public boolean addItem(Scanner scanner) {
		float price = -1;
		int stock = -1;
		float cost = -1;
		boolean success = false;
		
		// ask for values
			
		// item name
		scanner.nextLine();
		System.out.print("Enter the name for the item: ");
		itemName = scanner.nextLine();
		
		// item quantity
		do {
			System.out.print("Enter the quantity for the item: ");

			// if input is an int, store
			if (scanner.hasNextInt()) {
				stock = scanner.nextInt();
				success = true;
			} else {
				// clear input 
				scanner.next();
				success = false;
			}
			
			// check range
			if (stock < 0) {
				System.out.println("Invalid entry");
				success = false;
			}

		} while (success == false);
		itemQuantityInStock = stock;
		
		// cost of the item
		do {
			System.out.print("Enter the cost of the item: ");

			// if input is an float, store
			if (scanner.hasNextFloat()) {
				cost = scanner.nextFloat();
				success = true;
			} else {
				// clear input 
				scanner.next();
				success = false;
			}

			// check range
			if (cost < 0) {
				System.out.println("Invalid entry");
				success = false;
			}

		} while (success == false);
		itemCost = cost;

		// price of the item
		do {
			System.out.print("Enter the sales price of the item: ");

			// if input is an float, store
			if (scanner.hasNextFloat()) {
				price = scanner.nextFloat();
				success = true;
			} else {
				// clear input
				scanner.next();
				success = false;
			}

			// check range
			if (price < 0) {
				System.out.println("Invalid entry");
				success = false;
			}

		} while (success == false);
		itemPrice = price;

		// if any fail return false
		if (itemName == null || itemQuantityInStock == -1 || itemPrice == -1 || itemCost == -1) {
			return false;
		}
		
		//return true
		return true;
	}

	/**
	 * Update an items values/attributes
	 * @param amount The amount to change the item
	 * @return Boolean value of success
	 */
	public boolean updateItem(int amount) {
		// if buying or selling
		if (amount >= 0) {
			itemQuantityInStock += amount;
		} else {
			// if we are selling, check stock
			if (itemQuantityInStock < (amount * -1)) {
				System.out.println("Insufficient stock in inventory...");
				return false;
			}
			itemQuantityInStock += amount;
		}
		return true;
	}
	
	/**
	 * Checks whether an item is equal
	 * @param item The item to compare
	 * @return Whether the item code is the same
	 */
	public boolean isEqual(FoodItem item) {
		// check the code
		if (item.itemCode == itemCode) {
			return true;
		}
		return false;
	}
	
	/**
	 * Asks for the item code and validates
	 * @param scanner The scanner to read user input
	 * @return Whether the code was valid
	 */
	public boolean inputCode(Scanner scanner) {
		int code;
		
		// ask for code
		System.out.print("Enter the code for the item: ");

		// if input is an int, store
		if (scanner.hasNextInt()) {
			code = scanner.nextInt();
			itemCode = code;

			return true;
		} else {
			// clear input print error
			scanner.next();
			System.out.println("Invalid entry");
			return false;
		}
	}
}
