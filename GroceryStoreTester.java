package FreeTIme;

import java.util.LinkedList;
import java.util.Scanner;

public class GroceryStoreTester {

    public static void main(String args[]) {

        System.out.println();
        System.out.println("Welcome to the Moski Grocery Store.");
        System.out.println("Enter the amount of money you have: ");

        GroceryStore store = new GroceryStore();
        System.out.println();

        System.out.println("You have $" + store.personalMoney + " in your account!");

        String next = "";

        while (!next.equalsIgnoreCase("next")) {
            System.out.print("Please type 'Next' to continue : ");
            Scanner typeNext = new Scanner(System.in);
            next = typeNext.nextLine();

            if (!next.equalsIgnoreCase("next")) {
                System.out.println("Invalid input. Please try again!");
            } else {
                break;
            }
        }

        System.out.println();
        System.out.println("The prices of the following items at the Moski Grocery Store are: ");
        System.out.println("Milk - $" + store.priceOfMilk);
        System.out.println("Eggs - $" + store.priceOfEgg);
        System.out.println("Meat - $" + store.priceOfMeat);
        System.out.println("Fish - $" + store.priceOfFish);
        System.out.println();

        //boolean to stop shopping
        boolean stopShopping = false;

        while (store.personalMoney > 0 && !stopShopping) {
            int totalBill = 0;
            Scanner choice = new Scanner(System.in);
            System.out.println("What would you like to buy?");
            String itemChoice = choice.nextLine();
            if (itemChoice.equalsIgnoreCase("Milk")) {
                System.out.println("How many would you like?");
                Scanner itemQuantity = new Scanner(System.in);
                int milkQuantity = itemQuantity.nextInt();
                store.boughtMilk(milkQuantity);
            }
            else if (itemChoice.equalsIgnoreCase("Eggs") || itemChoice.equalsIgnoreCase("egg")) {
                System.out.println("How many would you like?");
                Scanner itemQuantity = new Scanner(System.in);
                int eggQuantity = itemQuantity.nextInt();
                store.boughtEgg(eggQuantity);
            }
            else if (itemChoice.equalsIgnoreCase("Meat")) {
                System.out.println("How many would you like?");
                Scanner itemQuantity = new Scanner(System.in);
                int meatQuantity = itemQuantity.nextInt();
                store.boughtMeat(meatQuantity);
            }
            else if (itemChoice.equalsIgnoreCase("Fish")) {
                System.out.println("How many would you like?");
                Scanner itemQuantity = new Scanner(System.in);
                int fishQuantity = itemQuantity.nextInt();
                store.boughtFish(fishQuantity);
            }
            else {
                System.out.println();
                System.out.println("Invalid input. Please try again!");
                System.out.println();
                continue;
            }

            //do while loop to continue shopping
            String continueChoice;
            do {
                totalBill = store.totalCost();
                System.out.println();
                System.out.print("You spent $" + totalBill + ". Do you want to continue shopping?(Y/N): ");
                continueChoice = choice.nextLine();
                if (continueChoice.equalsIgnoreCase("Yes")) {
                    // continue shopping
                    //update total bill
                } else if (continueChoice.equalsIgnoreCase("No")) {
                    System.out.println();
                    System.out.println("Thank you for shopping at Moski Grocery Store!");
                    System.out.println("Your total bill is $" + totalBill + ".");
                    stopShopping = true;
                } else {
                    System.out.println("Invalid input. Please type 'Yes' or 'No'!");
                }
            } while (!continueChoice.equalsIgnoreCase("Yes") && !continueChoice.equalsIgnoreCase("No") && !stopShopping);


            String returnChoice = "";
            if (stopShopping) {
                while (!returnChoice.equalsIgnoreCase("Yes") && !returnChoice.equalsIgnoreCase("No")) {
                    System.out.println();
                    System.out.println("Do you want to return any items you bought?(Y/N): ");
                    returnChoice = choice.nextLine();
                }
                if (returnChoice.equalsIgnoreCase("Yes")) {
                    System.out.println();
                    String boughtItems = "";
                    for (int i = 0; i < store.itemsBought.size(); i++) {
                        boughtItems += store.itemsBought.get(i) + ", ";
                    }
                    if (!boughtItems.isEmpty()) {
                        boughtItems = boughtItems.substring(0, boughtItems.length() - 2);
                        System.out.println("You bought: " + boughtItems);
                    } else {
                        System.out.println("You did not buy anything.");
                        break;
                    }
                    System.out.println("Which items would you like to return?: ");
                    String returnItem = choice.nextLine();
                    System.out.println("How many quantity would you like to return?: ");
                    int returnQuantity = choice.nextInt();

                    // Flag to track whether the item was found for return
                    boolean itemFoundForReturn = false;

                    for (int i = 0; i < returnQuantity; i++) {
                        for (int j = 0; j < store.itemsBought.size(); j++) {
                            String item = (String) store.itemsBought.get(j);
                            String[] parts = item.split(" ");
                            int quantity = Integer.parseInt(parts[1]);
                            String itemName = parts[0];

                            if (returnItem.equalsIgnoreCase(itemName) && quantity > 0) {
                                // Deduct the cost and update the remaining quantity
                                store.personalMoney += store.getItemCost(itemName);
                                store.itemsBought.set(j, itemName + " " + (quantity - 1));
                                itemFoundForReturn = true;
                                break;
                            }
                        }
                    }

                    if (itemFoundForReturn) {
                        System.out.println();
                        totalBill = store.returnedTotalCost();
                        System.out.println("You have successfully returned " + returnItem + ".");
                        System.out.println("Your new total bill is $" + totalBill + ".");
                        System.out.println();
                        System.out.println("Thanks for playing!");
                    } else {
                        System.out.println("You did not buy that item or quantity is insufficient, try again!");
                    }
                }

                else if (returnChoice.equalsIgnoreCase("No")) {
                    System.out.println();
                    System.out.println("Thanks for playing!");
                }
            }
        }
    }
}




