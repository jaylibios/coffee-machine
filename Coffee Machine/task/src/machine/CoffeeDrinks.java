package machine;

public enum CoffeeDrinks {

    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private int water, milk, coffeeBeans, cost;

    CoffeeDrinks(int water, int milk, int beans, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = beans;
        this.cost = cost;
    }

    public int getWater() {
        return this.water;
    }

    public int getMilk() {
        return this.milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCost() {
        return this.cost;
    }
};