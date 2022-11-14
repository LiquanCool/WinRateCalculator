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
        WinRateCalculator calc1 = new WinRateCalculator(wins, losses);
        calc1.toString();
        String input = "";
        while(!input.equals("q"))
        {
            System.out.println("What would you like me to do?\n" +
                    "To see your wins and losses, enter t\n" +
                    "To change wins, enter w\n" +
                    "To change losses, enter l\n" +
                    "To calculate win rate, enter c\n" +
                    "To simulate 100 games with your stats, enter s (requires win rate to be calculated first!)\n" +
                    "To estimate on average how many games you will win over x amount of games, enter a (requires win rate to be calculated first!)\n" +
                    "To stop the program, enter q");
            input = s.nextLine();
            if(input.equals("t"))
            {
                System.out.println(calc1.toString());
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
                System.out.println("Win rate calculated!");
            }
            else if(input.equals("s"))
            {
                calc1.simulateGames();
            }
            else if(input.equals("a"))
            {
                System.out.println("Over how many games do you want to find the average wins?");
                calc1.avgWinsOver(parseInt(s.nextLine()));
            }
            else
            {
                System.out.println("Please enter one of the options or q to quit.");
            }
        }
        System.out.println("See you next time!");
    }
}