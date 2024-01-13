//Mostapha A
//Assignment 1
//Class for main method and menu

import java.util.Scanner;

/**
 * *
 * This class contains the main method and menu 
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 * @author/Mostapha A
 * 
 */
public class Assign1 {

	/**
	 * Main method for printing menu and processing.
	 * 
	 * @param args Default needed for main method
	 */
	public static void main(String[] args) {
		// var for menu input
		int menu = -1;
		Scanner scanner = new Scanner(System.in);
		// object
		Inventory inventory = new Inventory();
		boolean returnVal;

		// loop through menu
		do {
			// set menu to -1
			menu = -1;

			// print menu
			printMenu();
			
			// if input is an int, store
			if (scanner.hasNextInt()) {
				menu = scanner.nextInt();
			} else {
				// clear input
				scanner.next();
			}

			// if it is out of range print error and loop again
			if (menu < 1 || menu > 5) {
				// print error and loop through again
				System.out.println("Incorrect value entered");
			} else {
				// case structure for menu options
				switch (menu) {
				case 1:
					// add an item
					inventory.addItem(scanner);
					break;
				case 2:
					// print items
					System.out.println("Inventory:\n" + inventory.toString());
					break;
				case 3:
					// buy an item
					returnVal = inventory.updateQuantity(scanner, true);
					if (returnVal == false) {
						System.out.println("Error...could not buy item");
					}
					break;
				case 4:
					// sell an item
					returnVal = inventory.updateQuantity(scanner, false);
					if (returnVal == false) {
						System.out.println("Error...could not sell item");
					}
					break;
				case 5:
					System.out.println("Exiting...");
					break;
				}
			}

		} while (menu != 5);
		
		scanner.close();
	}

	/**
	 * Prints the menu.
	 */
	public static void printMenu() {
		System.out.print("Please select one of the following:\r\n" + 
				"1: Add Item to Inventory\r\n" + 
				"2: Display Current Inventory\r\n" + 
				"3: Buy Item(s)\r\n" + 
				"4: Sell Item(s)\r\n" + 
				"5: To Exit\r\n" + 
				"> ");
	}
}
