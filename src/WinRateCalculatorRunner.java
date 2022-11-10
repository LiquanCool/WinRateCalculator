import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class WinRateCalculatorRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Win Rate Calculator!");
        System.out.print("How many wins do you have?");
        int wins = parseInt(s.nextLine());
        System.out.print("How many loses do you have?");
        int losses = parseInt(s.nextLine());

    }
}