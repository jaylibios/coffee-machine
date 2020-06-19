package machine;
import java.util.Scanner;

public class CoffeeMachine {

    static final int WATER_PER_CUP = 200;
    static final int MILK_PER_CUP = 50;
    static final int COFFEE_BEANS_PER_CUP = 15;

    // Espresso constants
    static final int ESPRESSO_WATER_PER_CUP = 250;
    static final int ESPRESSO_MILK_PER_CUP = 0;
    static final int ESPRESSO_BEANS_PER_CUP = 16;
    static final int ESPRESSO_COST = 4;

    // Latte constants
    static final int LATTE_WATER_PER_CUP = 350;
    static final int LATTE_MILK_PER_CUP = 75;
    static final int LATTE_BEANS_PER_CUP = 20;
    static final int LATTE_COST = 7;

    // Cappuccino constants
    static final int CAPPUCCINO_WATER_PER_CUP = 200;
    static final int CAPPUCCINO_MILK_PER_CUP = 100;
    static final int CAPPUCCINO_BEANS_PER_CUP = 12;
    static final int CAPPUCCINO_COST = 6;

    static int currentWater = 400, currentMilk = 540, currentCoffeeBeans = 120;
    static int currentDisposableCups = 9, currentMoney = 550;
    static int cupsOfCoffeeNeeded, totalCups;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String userAction = scanner.next();

        do {
            switch (userAction) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillSupplies();
                    break;
                case "take":
                    takeSupplies();
                    break;
                case "remaining":
                    readCoffeeMachine();
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }

            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            userAction = scanner.next();

        } while ( userAction != "exit" );

    }

    static void readCoffeeMachine() {
        System.out.printf("The coffee machine has:%n" +
                "%d of water%n" +
                "%d of milk%n" +
                "%d of coffee beans%n" +
                "%d of disposable cups%n" +
                "$%d of money%n", currentWater, currentMilk, currentCoffeeBeans, currentDisposableCups, currentMoney);
    }

    static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String coffeeToBuy = scanner.next();

        switch(coffeeToBuy) {
            case "1":
                makeCoffee(ESPRESSO_WATER_PER_CUP, ESPRESSO_MILK_PER_CUP, ESPRESSO_BEANS_PER_CUP, currentDisposableCups, ESPRESSO_COST);
                break;
            case "2":
                makeCoffee(LATTE_WATER_PER_CUP, LATTE_MILK_PER_CUP, LATTE_BEANS_PER_CUP, currentDisposableCups, LATTE_COST);
                break;
            case "3":
                makeCoffee(CAPPUCCINO_WATER_PER_CUP, CAPPUCCINO_MILK_PER_CUP, CAPPUCCINO_BEANS_PER_CUP, currentDisposableCups, CAPPUCCINO_COST);
                break;
        }
    }

    static void fillSupplies() {
        int water, milk, beans, cups;
        System.out.println("How many ml of water do you want to add?");
        water = scanner.nextInt();

        System.out.println("How many ml of milk do you want to add?");
        milk = scanner.nextInt();

        System.out.println("How many grams of coffee beans do you want to add?");
        beans = scanner.nextInt();

        System.out.println("How many disposable cups do you want to add?");
        cups = scanner.nextInt();

        currentWater += water;
        currentMilk += milk;
        currentCoffeeBeans += beans;
        currentDisposableCups += cups;

    }

    static void takeSupplies() {
        System.out.printf("I give you $%d", currentMoney);
        currentMoney = 0;
    }

    static void makeCoffee(int water, int milk, int beans, int cups, int money) {
        // Check if there is enough supplies
        boolean enoughWater = currentWater >= water,
                enoughMilk = currentMilk >= milk,
                enoughBeans = currentCoffeeBeans >= beans,
                enoughCups = currentDisposableCups >= cups;

        boolean enoughSupplies = enoughWater && enoughMilk && enoughBeans && enoughCups;

        if(enoughSupplies) {
            System.out.println("I have enough resources, making you a coffee!");

            currentWater -= water;
            currentMilk -= milk;
            currentCoffeeBeans -= beans;
            currentDisposableCups--;
            currentMoney += money;

        } else {
            System.out.println("Sorry, not enough!");
        }
    }

}
