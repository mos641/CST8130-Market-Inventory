//Mostapha A
//Assignment 1
//Class for Inventory array

import java.util.Scanner;

/**
 * * 
 * This contains the definition of the inventory
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 * @author/Mostapha A
 * 
 */
public class Inventory {
	/**
	 * The array that holds all the different food items
	 */
	private static FoodItem[] inventory;
	/**
	 * The amount of items we have added
	 */
	private static int numItems;
	
	/**
	 * Constructor for the inventory
	 */
	public Inventory() {
		inventory = new FoodItem[20];
	}
	
	/**
	 * Compiles a string of all the items in the array
	 * @return The formatted string of all items
	 */
	public String toString() {
		String allItems = "";
		for (int i = 0; i < numItems; i++) {
			allItems = allItems + inventory[i].toString();
		}
		return allItems;
	}
	
	/**
	 * Checks if an item code is in use or not
	 * @param item The item to check the code of
	 * @return The index that the item is at or -1 if not found
	 */
	public int alreadyExists(FoodItem item) {
		// if the code exists return the index
		for(int i = 0; i < numItems ; i++) {
			if(inventory[i].isEqual(item) == true) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Adds an item to the array, calling the appropriate method depending on item
	 * type.
	 * 
	 * @param scanner The scanner to read input
	 * @return Whether method was successful or not
	 */
	public boolean addItem(Scanner scanner) {
		String type = null;
		int exists = -1;
		boolean success = false;
		FoodItem item = new FoodItem();

		if (numItems < 20) {
			do {
				// ask for item type
				System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
				type = scanner.next();
				type = type.toLowerCase();
				
				if (!type.equalsIgnoreCase("f") && !type.equalsIgnoreCase("v") && !type.equalsIgnoreCase("p")) {
					// print error
					System.out.println("Invalid entry");
					type = null;
				}

			} while (type == null);

			// add item depending on type
			if (type.equals("f")) {
				item = new Fruit();
			} else if (type.equals("v")) {
				item = new Vegetable();
			} else {
				item = new Preserve();
			}

			// ask for item code
			do {
				// input code if its valid
				success = item.inputCode(scanner);
				
				// if it returned true, check if the code exists
				if (success == true) {
					exists = alreadyExists(item);
					
					if (exists != -1) {
						System.out.println("Item code already exists");
						success = false;
					}
				}

			} while (success == false);
						
			item.addItem(scanner);
			
			inventory[numItems] = item;
			
			numItems++;

		} else {
			System.out.println("Inventory full");
			return false;
		}

		return true;
	}

	/**
	 * Updates the quantity of item if buying or selling
	 * @param scanner The scanner to read user input
	 * @param buyOrSell Whether we are buying items or selling
	 * @return Whether quantity was updated successfully or not
	 */
	public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
		Boolean returnVal = true;
		int quantity = -1;
		int code;
		int exists;
		String message;
		FoodItem item = new FoodItem();

		// if there are no items return false
		if (numItems <= 0) {
			return false;
		}
		
		// ask for item code
		System.out.print("Enter the code for the item: ");

		// if input is an int, store
		if (scanner.hasNextInt()) {
			code = scanner.nextInt();
			item.itemCode = code;

			// check if it exists
			exists = alreadyExists(item);
		} else {
			// clear input print error
			scanner.next();
			System.out.println("Code not found in inventory...");
			return false;
		}

		if (exists == -1) {
			System.out.println("Code not found in inventory...");
			return false;
		}

		// set message if buying or selling
		if (buyOrSell == true) {
			message = "Enter valid quantity to buy: ";
		} else {
			message = "Enter valid quantity to sell: ";
		}

		// ask for the quantity

		System.out.print(message);

		// if input is an int, store
		if (scanner.hasNextInt()) {
			quantity = scanner.nextInt();
			returnVal = true;
		} else {
			// clear input print error
			scanner.next();
			System.out.println("Invalid quantity...");
			return false;
		}

		// check range
		if (quantity < 0) {
			System.out.println("Invalid quantity...");
			return false;
		}
		
		// update the quantity for buy or sell
		if (buyOrSell == true) {
			returnVal = inventory[exists].updateItem(quantity);
		} else {
			returnVal = inventory[exists].updateItem(quantity * -1);
		}

		return returnVal;
	}

}
