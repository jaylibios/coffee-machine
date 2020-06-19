package machine;
import javax.print.MultiDocPrintService;
import java.util.Scanner;

public class CoffeeMachine {
    public static String userInput;
    public static MachineState state;
    public CoffeeDrinks espresso = CoffeeDrinks.ESPRESSO;
    public CoffeeDrinks latte = CoffeeDrinks.LATTE;
    public CoffeeDrinks cappuccino = CoffeeDrinks.CAPPUCCINO;

    public int water = 400,
        milk = 540,
        coffeeBeans = 120,
        cups = 9,
        money = 550;

    public CoffeeMachine() {
        // Set state to main
        setMainState();
    }

    public void setMainState() {
        state = MachineState.MAIN;
        System.out.println("Write action ( buy, fill, take, remaining, exit ):");
    }

    public void processInput(String userInput) {
        checkState(userInput);
    }

    public void checkState(String userInput) {
        switch(state) {
            case MAIN:
                mainMenu(userInput);
                break;
            case BUY:
                buyCoffee(userInput);
                break;
            case FILL_WATER:
                fillWater(userInput);
                break;
            case FILL_MILK:
                fillMilk(userInput);
                break;
            case FILL_COFFEE_BEANS:
                fillCoffeeBeans(userInput);
                break;
            case FILL_CUPS:
                fillCups(userInput);
                break;
            case TAKE:
                takeMoney();
                break;
            case REMAINING:
                readCoffeeMachine();
                break;
        }
    }

    public void mainMenu(String userInput) {
        state = MachineState.findByCode(userInput);
        switch(userInput) {
            case "buy":
                state = MachineState.BUY;
                System.out.println("What do you want to buy?");
                break;
            case "fill":
                state = MachineState.FILL_WATER;
                System.out.println("How many ml of water do you want to add?");
                break;
            case "take":
                state = MachineState.TAKE;
                takeMoney();
                break;
            case "remaining":
                state = MachineState.REMAINING;
                readCoffeeMachine();
                break;
        }
    }

    private void buyCoffee(String userInput) {

        switch(userInput) {
            // Espresso
            case "1":
                makeCoffee(espresso.getWater(), espresso.getMilk(), espresso.getCoffeeBeans(), cups, espresso.getCost());
                break;
            // Latte
            case "2":
                makeCoffee(latte.getWater(), latte.getMilk(), latte.getCoffeeBeans(), cups, latte.getCost());
                break;
            // Cappuccino
            case "3":
                makeCoffee(cappuccino.getWater(), cappuccino.getMilk(), cappuccino.getCoffeeBeans(), cups, cappuccino.getCost());
                break;
        }

    }

    private void makeCoffee(int water, int milk, int beans, int cups, int money) {
        // Check if there is enough supplies
        boolean enoughWater = this.water >= water,
                enoughMilk = this.milk >= milk,
                enoughBeans = this.coffeeBeans >= beans,
                enoughCups = this.cups >= cups;

        boolean enoughSupplies = enoughWater && enoughMilk && enoughBeans && enoughCups;

        if(enoughSupplies) {
            System.out.println("I have enough resources, making you a coffee!");

            this.water -= water;
            this.milk -= milk;
            this.coffeeBeans -= beans;
            this.cups--;
            this.money += money;

        } else {
            System.out.println("Sorry, not enough!");
        }

        setMainState();
    }

    private void fillWater(String water) {
        this.water += Integer.parseInt(water);
        state = MachineState.FILL_MILK;
        System.out.println("How many ml of milk do you want to add?");
    }

    private void fillMilk(String milk) {
        this.milk += Integer.parseInt(milk);
        state = MachineState.FILL_COFFEE_BEANS;
        System.out.println("How many grams of coffee beans do you want to add?");
    }

    private void fillCoffeeBeans(String coffeeBeans) {
        this.coffeeBeans += Integer.parseInt(coffeeBeans);
        state = MachineState.FILL_CUPS;
        System.out.println("How many cups do you want to add?");
    }

    private void fillCups(String cups) {
        this.cups += Integer.parseInt(cups);
        state = MachineState.MAIN;
    }

    private void takeMoney() {
        System.out.printf("%nI give you $%d%n", this.money);
        this.money = 0;
        setMainState();
    }

    private void readCoffeeMachine() {
        System.out.printf("*****%nThe coffee machine has:%n" +
                "%d of water%n" +
                "%d of milk%n" +
                "%d of coffee beans%n" +
                "%d of disposable cups%n" +
                "$%d of money%n*****%n%n", this.water, this.milk, this.coffeeBeans, this.cups, this.money);
        setMainState();
    }

}