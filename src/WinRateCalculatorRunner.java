import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class WinRateCalculatorRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Win Rate Calculator!");
        System.out.println("How many wins do you have? (type a number)");
        int wins = parseInt(s.nextLine());
        System.out.println("How many loses do you have? (type a number)");
        int losses = parseInt(s.nextLine());
        WinRateCalculator calc1 = new WinRateCalculator(wins, losses);
        String input = "";
        while(!input.equals("q"))
        {
            System.out.println("\nWhat would you like me to do?\n" +
                    "To calculate win rate, enter c\n" +
                    "To change wins or losses, enter either w or l\n\n" +
                    "To see your stats, enter t (calculate your win rate first!)\n" +
                    "To simulate 100 games with your win rate, enter s (requires win rate to be calculated first!)\n" +
                    "To estimate on average how many games you will win over x amount of games, enter a (requires win rate to be calculated first!)\n" +
                    "To stop the program, enter q");
            input = s.nextLine();
            if(input.equals("t"))
            {
                System.out.println(calc1);
            }
            else if(input.equals("w"))
            {
                System.out.println("What is the new number of wins? (Remember to calculate your win rate again!)");
                calc1.updateWins(parseInt(s.nextLine()));
            }
            else if(input.equals("l"))
            {
                System.out.println("what is the new number of losses? (Remember to calculate your win rate again!)");
                calc1.updateLosses(parseInt(s.nextLine()));
            }
            else if(input.equals("c"))
            {
                calc1.updateWinRate(calc1.calculateWinRate());
                System.out.println("Calculated! Win rate: " + calc1.percentWinRate() + "%");
            }
            else if(input.equals("s"))
            {
                System.out.println(calc1.simulateGames());
            }
            else if(input.equals("a"))
            {
                System.out.println("Over how many games do you want to find the average wins?");
                System.out.println(calc1.avgWinsOver(parseInt(s.nextLine())));
            }
            else if(input.equals("q"))
            {
                System.out.println("See you next time!");
            }
            else
            {
                System.out.println("Please enter one of the options or q to quit.");
            }
        }
    }
}