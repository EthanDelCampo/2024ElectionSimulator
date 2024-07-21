/**
 * ElectionSimulator class runs simulations of the 2024 US Presidential election.
 * It simulates 10,000 possible outcomes and calculates the probability of each party winning.
 */
public class ElectionSimulator {

    public static void main(String[] args) {
        final int TOTAL_SIMULATIONS = 10000;
        final int WIN_THRESHOLD = 270;
        
        int gopVictories = 0;
        int demVictories = 0;
        int ties = 0;

        System.out.println("Welcome to the 2024 US Presidential election simulator!");
        System.out.println();
        System.out.println("This program will be simulating " + TOTAL_SIMULATIONS + " possible results for the 2024 US Presidential Election");
        System.out.println("and will output how many times each party won the election!");

        for (int i = 0; i < TOTAL_SIMULATIONS; i++) {
            Simulation s = new Simulation();
            s.simulateTheElection();

            if (s.returnGOPVotes() == 269 && s.returnDemVotes() == 269) {
                ties++;
            } else if (s.returnGOPVotes() >= WIN_THRESHOLD) {
                gopVictories++;
            } else {
                demVictories++;
            }
        }

        System.out.println();
        System.out.println("Republican Victories: " + gopVictories);
        System.out.println("Democratic Victories: " + demVictories);
        System.out.println("Ties: " + ties);
        System.out.println();
    }
}
