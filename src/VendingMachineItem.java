/*
Khushbu Khushbu 
 */
package vendingmachinesimulation.usecase;

import java.util.Scanner;

public class VendingMachineItem {
    
//    *******OOP concept**********
//    Encapsulation : making attributes private so that it can't be accessed directly outside the class.
    
    private double price;
    
    private static String[] candies = {"chocolate bar", "sour candy", "soft drink", "potato chips"};
    private static double[] prices = {1.50, 1.20, 1.80, 2.00};
    private static boolean[] itemAvailability = {true, true, true, true}; // Initially all items are available
    
    
    
    public VendingMachineItem() {
       
//       Constructor to initialize the attributes
    }

//    *******OOP concept**********
//    Encapsulation : created getters and setters to access the properties outside of the class.
    public static String[] getCandies() {
        return candies;
    }

    public static void setCandies(String[] candies) {
        VendingMachineItem.candies = candies;
    }

    public static double[] getPrices() {
        return prices;
    }

    public static void setPrices(double[] prices) {
        VendingMachineItem.prices = prices;
    }

    public static boolean[] getItemAvailability() {
        return itemAvailability;
    }

    public static void setItemAvailability(boolean[] itemAvailability) {
        VendingMachineItem.itemAvailability = itemAvailability;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double givenPrice) {
        price = givenPrice;
    }
    
    public static void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of the possible candies:");
        for (int i = 0; i < 4; i++) {
            System.out.println((i+1) + ". " + candies[i] + " - $" + prices[i]);
        }
    }
    
//    *******OOP concept**********
//    Created a static method to select the items 
     public static void selectItem(Scanner sc) {
        System.out.print("\nEnter the number of the item you want to purchase: ");
        int choice = sc.nextInt() - 1; // Adjusting for 0-based indexing

        if (choice < 0 || choice >= candies.length) {
            System.out.println("Invalid selection. Please try again.");
            return;
        }

        if (itemAvailability[choice]) {
            System.out.println("You selected: " + candies[choice] + ". Enjoy your snack!");
            itemAvailability[choice] = false; // Mark the item as sold out
        } else {
            System.out.println("Sorry, " + candies[choice] + " is sold out. Please select another item.");
        }
    }
   
    
    public static void main(String[] args) {
//         *******OOP concept**********
//  Cohesion/ Single Responsibility Principle : The VendingMachine class is only responsible for vending machine operations
//(like displaying the menu and selecting items).
        Scanner sc = new Scanner(System.in);
        boolean continueShopping = true;

        while (continueShopping) {
            displayMenu();
            selectItem(sc);

            System.out.print("\nWould you like to buy another item? (yes/no): ");
            String response = sc.next().trim().toLowerCase();
            continueShopping = response.equals("yes");
        }

        System.out.println("Thank you for using the vending machine!");
        sc.close();
    }
}
