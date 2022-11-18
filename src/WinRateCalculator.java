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
        return "games: " + games + "\nwins: " + wins + "\nlosses: " + losses + "\nwin rate: " + percentWinRate() + "%";
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

    /**
     * The calculateWinRate method will calculate the win rate and round it to the nearest hundredths
     * @return returns the win rate that is calculated in terms of probability
     *
     */
    public double calculateWinRate()
    {
        double WinRate = ((double)((int)((((double)wins/(wins + losses))+.005)*100)))/100;
        return WinRate;
    }

    /**
     * The percentWinRate method will convert the win rate to percentage
     * @return returns the win rate in percentage
     */
    public int percentWinRate()
    {
        return (int)(WinRate*100);
    }

    /**
     * The simulateGames method will simulate the user's stats and tell them how they did, compared to the simulation
     * @return returns a string with a comparison of the user's stats to the simulation's stats
     */
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
        if (simWins > wins)
        {
            return "Unlucky, compared to a simulation of your win rate, you won " + (simWins-wins) + " less times.";
        }
        if (wins > simWins)
        {
            return "Wow you are lucky, compared to a simulation of your win rate, you won " + (wins-simWins) + " more times!";
        }
        else
        {
            return "You are average compared to a simulation of your stats, you won the same amount of times.";
        }
    }

    /**
     * The avgWinsOver method will calculate on average how more wins than losses over the next inputted games amount of games
     * @param games represents the amount of games to find on average how many more wins over losses
     * @return returns a string that compares the average amount of wins and losses over the next games amount of games.
     */
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
