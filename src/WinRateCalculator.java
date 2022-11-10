import java.awt.event.WindowStateListener;

public class WinRateCalculator {

    private int wins;
    private int losses;
    private double WinRate;
    private int games;
    public WinRateCalculator(int wins, int losses)
    {
        this.wins = wins;
        this.losses = losses;
        this.games = wins+losses;
    }

    public String process(String choice)
    {}

    public void updateWins(int wins)
    {
        this.wins = wins;
        this.games = wins+losses;
    }
    public void updateLosses(int losses)
    {
        this.losses = losses;
        this.games = wins+losses;
    }
    public void updateWinRate(double WinRate)
    {
        this.WinRate = WinRate;
    }
    public double calculateWinRate(int wins, int losses)
    {
        double WinRate = ((double)((int)((((double)wins/(wins + losses))+.005)*100)))/100;
        return WinRate;
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
        if (wins > avgWins)
        {
            return ")";
        }
        else {
            return "";
        }
    }
}
