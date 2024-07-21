import java.util.Random;

/**
 * Simulation class simulates the outcome of the 2024 US Presidential election.
 * It uses electoral vote counts and probabilities to determine the winner for each state.
 */
public class Simulation {

    // Safe electoral votes
    private int demVotes = 85;
    private int gopVotes = 65;

    // Random national swing for this simulation
    private double randomSwing;

    /**
     * Constructor for the Simulation class.
     * Initializes the random swing value.
     */
    public Simulation() {
        randomSwing = generateRandomIndex();
    }

    /**
     * Generates a random swing value from a normal distribution between -10.0 and 10.0.
     * 
     * @return A random double value representing the national swing.
     */
    private double generateRandomIndex() {
        Random random = new Random();
        double standardDeviation = 100.0 / 3.0;
        return random.nextGaussian() * standardDeviation;
    }

    /**
     * Returns the average of the GOP odds predicted by FiveThirtyEight and the Economist.
     * 
     * @param fiveThirtyEightGOPOdds Odds from FiveThirtyEight.
     * @param theEconomistGOPOdds Odds from The Economist.
     * @return The average GOP odds.
     */
    private double returnAverageGOPOdd(double fiveThirtyEightGOPOdds, double theEconomistGOPOdds) {
        return (fiveThirtyEightGOPOdds + theEconomistGOPOdds) / 2.0;
    }

    /**
     * Simulates the outcome of one particular state.
     * 
     * @param gopOdds GOP odds for the state.
     * @param electoralVoteCount Electoral votes for the state.
     */
    private void simulateAState(double gopOdds, int electoralVoteCount) {
        double trueGOPOdds = gopOdds + randomSwing;

        if (trueGOPOdds >= 100) {
            gopVotes += electoralVoteCount;
            return;
        } else if (trueGOPOdds <= 0) {
            demVotes += electoralVoteCount;
            return;
        }

        double temp = trueGOPOdds * 10;
        int cutoffIndex = (int) temp;
        int randomVal = (int) (Math.random() * 1000) + 1;

        if (randomVal <= cutoffIndex) {
            gopVotes += electoralVoteCount;
        } else {
            demVotes += electoralVoteCount;
        }
    }

    /**
     * Simulates the entire election by simulating each state's outcome.
     */
    public void simulateTheElection() {
        simulateAState(returnAverageGOPOdd(90, 99), 3);  // Alaska
        simulateAState(returnAverageGOPOdd(61, 83), 11);  // Arizona
        simulateAState(returnAverageGOPOdd(13, 17), 10);  // Colorado
        simulateAState(returnAverageGOPOdd(3, 4), 7);  // Connecticut
        simulateAState(returnAverageGOPOdd(4, 10), 3);  // Delaware
        simulateAState(returnAverageGOPOdd(73, 97), 30);  // Florida
        simulateAState(returnAverageGOPOdd(60, 83), 16);  // Georgia
        simulateAState(returnAverageGOPOdd(6, 19), 19);  // Illinois
        simulateAState(returnAverageGOPOdd(97, 99), 11);  // Indiana
        simulateAState(returnAverageGOPOdd(89, 99), 6);  // Iowa
        simulateAState(returnAverageGOPOdd(96, 99), 6);  // Kansas
        simulateAState(returnAverageGOPOdd(97, 99), 8);  // Louisiana
        simulateAState(returnAverageGOPOdd(23, 39), 2);  // Maine (at large)
        simulateAState(returnAverageGOPOdd(1, 1), 1);  // Maine's 1st Congressional District
        simulateAState(returnAverageGOPOdd(85, 97), 1);  // Maine's 2nd Congressional District
        simulateAState(returnAverageGOPOdd(43, 72), 15);  // Michigan
        simulateAState(returnAverageGOPOdd(30, 49), 10);  // Minnesota
        simulateAState(returnAverageGOPOdd(98, 99), 6);  // Mississippi
        simulateAState(returnAverageGOPOdd(96, 99), 10);  // Missouri
        simulateAState(returnAverageGOPOdd(96, 99), 4);  // Montana
        simulateAState(returnAverageGOPOdd(98, 99), 2);  // Nebraska (at large)
        simulateAState(returnAverageGOPOdd(3, 4), 1);  // Nebraska's 1st Congressional District
        simulateAState(returnAverageGOPOdd(32, 48), 1);  // Nebraska's 2nd Congressional District
        simulateAState(returnAverageGOPOdd(57, 75), 6);  // Nevada
        simulateAState(returnAverageGOPOdd(31, 47), 4);  // New Hampshire
        simulateAState(returnAverageGOPOdd(13, 17), 14);  // New Jersey
        simulateAState(returnAverageGOPOdd(18, 26), 5);  // New Mexico
        simulateAState(returnAverageGOPOdd(3, 1), 28);  // New York
        simulateAState(returnAverageGOPOdd(66, 87), 16);  // North Carolina
        simulateAState(returnAverageGOPOdd(81, 99), 17);  // Ohio
        simulateAState(returnAverageGOPOdd(7, 6), 8);  // Oregon
        simulateAState(returnAverageGOPOdd(52, 81), 19);  // Pennsylvania
        simulateAState(returnAverageGOPOdd(3, 4), 4);  // Rhode Island
        simulateAState(returnAverageGOPOdd(92, 99), 9);  // South Carolina
        simulateAState(returnAverageGOPOdd(76, 96), 40);  // Texas
        simulateAState(returnAverageGOPOdd(26, 38), 13);  // Virginia
        simulateAState(returnAverageGOPOdd(3, 3), 12);  // Washington
        simulateAState(returnAverageGOPOdd(46, 76), 10);  // Wisconsin
    }

    /**
     * Returns the number of Republican Electoral Votes.
     * 
     * @return The GOP vote count.
     */
    public int returnGOPVotes() {
        return gopVotes;
    }

    /**
     * Returns the number of Democratic Electoral Votes.
     * 
     * @return The Democratic vote count.
     */
    public int returnDemVotes() {
        return demVotes;
    }
}

