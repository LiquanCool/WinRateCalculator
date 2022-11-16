import java.awt.event.WindowStateListener;

/**
 * The WinRateCalculator represents a Person's stats. The stats include wins, losses, and WinRate.
 */
public class WinRateCalculator {

    private int wins;
    private int losses;
    private double WinRate;
    private int games;

    /**
     * Constructor for the WinRateCalculator class. This creates a new instance of a WinRateCalculator given
     * the below parameters
     *
     * @param wins represents the number of wins of the user
     * @param losses represents the number of losses of the user.
     */
    public WinRateCalculator(int wins, int losses)
    {
        this.wins = wins;
        this.losses = losses;
        this.games = wins+losses;
    }

    /**
     * toString method for the WinRateCalculator class. This method will return a String
     * showing the stats about the user in a formatted sentence.
     * @return returns a string containing the information about the user.
     */
    public String toString()
    {
        return "wins = " + wins + "\nlosses = " + losses + "\nwin rate: " + WinRate;
    }

    /**
     * The updateWins method will change the number of wins given the number of wins to change to
     *
     * @param wins represents the new amount of wins to change the stat to
     */
    public void updateWins(int wins)
    {
        this.wins = wins;
        this.games = wins+losses;
    }

    /**
     * The updateLosses method will change the number of losses given the number of losses to change to
     *
     * @param losses represents the new amount of losses to change the stat to
     */
    public void updateLosses(int losses)
    {
        this.losses = losses;
        this.games = wins+losses;
    }

    /**
     *The updateWinRate method will change the win rate given the win rate to change to
     *
     * @param WinRate represents the new win rate to change the stat to
     */
    public void updateWinRate(double WinRate)
    {
        this.WinRate = WinRate;
    }
    public double calculateWinRate()
    {
        double WinRate = ((double)((int)((((double)wins/(wins + losses))+.005)*100)))/100;
        return WinRate;
    }
    public int percentWinRate()
    {
        return (int)(WinRate*100);
    }
    public String simulateGames()
    {
        int simWins = 0;
        for (int counter = 1;counter <= games;counter++)
        {
            if ((int)(Math.random()*100+1) <= WinRate*100)
            {
                simWins++;
            }
        }
        int simLosses = games - simWins;
        if (simWins > wins)
        {
            return "Unlucky, compared to a simulation of your stats, you won " + (simWins-wins) + " less times.";
        }
        if (wins > simWins)
        {
            return "Wow you are lucky, compared to a simulation of your stats, you won " + (wins-simWins) + " more times!";
        }
        else
        {
            return "You are average compared to a simulation of your stats, you won the same amount of times.";
        }
    }
    public String avgWinsOver(int games)
    {
        int avgWins = (int)((games*WinRate)+0.5);
        int avgLosses = games - avgWins;

        if (avgWins > avgLosses)
        {
            return "On average, you will win " + (avgWins-avgLosses) + " times more than lose over the next " + games + " games.";
        }
        if (avgLosses > avgWins)
        {
            return "On average, you will lose " + (avgLosses-avgWins) + " times more than win over the next " + games + " games.";
        }
        else
        {
            return "On average, you will win as many times as you will lose over the next " + games + " games.";
        }
    }
}
