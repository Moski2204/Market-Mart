package FreeTIme;
import java.util.Scanner;
import java.util.LinkedList;
public class GroceryStore {


    String egg = "Eggs";
    String meat = "Meat";
    String fish = "Fish";
    String milk = "Milk";
    int priceOfEgg = 5;
    int priceOfMeat = 30;
    int priceOfFish = 20;
    int priceOfMilk = 10;

    Scanner paisa = new Scanner(System.in);
    Scanner itemQuantity = new Scanner(System.in);
    LinkedList itemsBought = new LinkedList();
    int personalMoney = paisa.nextInt();



    void boughtMilk(int milkQuantity) {
        int cost = priceOfMilk * milkQuantity;
        if (personalMoney >= cost) {
            personalMoney = personalMoney - cost;
            System.out.println();
            // Multiply the price of milk by the quantity and print the result
            System.out.println("You bought " + milkQuantity + " bag(s) of Milk which is $" + cost + ".");
            itemsBought.add("Milk " + milkQuantity);
        } else {
            System.out.println("You don't have enough money to buy Milk.");
        }
    }

    void boughtEgg(int eggQuantity) {
        int cost2 = priceOfEgg * eggQuantity;
        if (personalMoney >= cost2) {
            personalMoney = personalMoney - cost2;
            System.out.println();
            System.out.println("You bought " + eggQuantity + " carton(s) of Eggs which is $" + cost2 + ".");
            itemsBought.add("Eggs " + eggQuantity);
        } else {
            System.out.println("You don't have enough money to buy Eggs.");
        }
    }

    void boughtMeat(int meatQuantity) {
        int cost3 = priceOfMeat * meatQuantity;
        if (personalMoney >= cost3) {
            personalMoney = personalMoney - cost3;
            System.out.println();
            System.out.println("You bought " + meatQuantity + " Meat packet(s) which is $" + cost3 + ".");
            itemsBought.add("Meat " + meatQuantity);
        } else {
            System.out.println("You don't have enough money to buy Meat.");
        }
    }

    void boughtFish(int fishQuantity) {
        int cost4 = priceOfFish * fishQuantity;
        if (personalMoney >= cost4) {
            personalMoney = personalMoney - cost4;
            System.out.println();
            System.out.println("You bought " + fishQuantity + " packets of Fish which is $" + cost4 + ".");
            itemsBought.add("Fish " + fishQuantity);
        } else {
            System.out.println("You don't have enough money to buy Fish.");
        }
    }

    int totalCost() {
        int cost = 0;
        for (int i = 0; i < itemsBought.size(); i++) {
            String item = (String) itemsBought.get(i);
            String[] parts = item.split(" ");
            int quantity = Integer.parseInt(parts[1]);
            String itemName = parts[0];

            // Make item name comparison case-insensitive
            itemName = itemName.toLowerCase();

            switch (itemName) {
                case "milk":
                    cost += priceOfMilk * quantity;
                    break;
                case "eggs":
                    cost += priceOfEgg * quantity;
                    break;
                case "meat":
                    cost += priceOfMeat * quantity;
                    break;
                case "fish":
                    cost += priceOfFish * quantity;
                    break;
                // Add more cases if you have other items
            }
        }
        return cost;
    }

    int returnedTotalCost() {
        int updatedCost = 0;

        for (int i = 0; i < itemsBought.size(); i++) {
            String item = (String) itemsBought.get(i);
            String[] parts = item.split(" ");
            int quantity = Integer.parseInt(parts[1]);
            String itemName = parts[0];

            double itemCost = 0;

            switch (itemName) {
                case "Milk":
                    itemCost = priceOfMilk * quantity;
                    break;
                case "Eggs":
                    itemCost = priceOfEgg * quantity;
                    break;
                case "Meat":
                    itemCost = priceOfMeat * quantity;
                    break;
                case "Fish":
                    itemCost = priceOfFish * quantity;
                    break;
                // Add more cases if you have other items
            }

            updatedCost += itemCost;
        }

        return updatedCost;
    }

    int getItemCost(String itemName) {
        // Placeholder logic, replace it with the actual cost retrieval
        switch (itemName) {
            case "Milk":
                return priceOfMilk;
            case "Eggs":
                return priceOfEgg;
            case "Meat":
                return priceOfMeat;
            case "Fish":
                return priceOfFish;
            // Add more cases if you have other items
            default:
                return 0; // Default cost if the item is not found (you may want to handle this case differently)
        }
    }


}

