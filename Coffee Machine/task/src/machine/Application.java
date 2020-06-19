package machine;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while(scanner.hasNext()) {
            coffeeMachine.processInput(scanner.next());
        }
    }

}