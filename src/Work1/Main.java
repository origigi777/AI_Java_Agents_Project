package Work1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws InterruptedException {
        final Metrics result = new Metrics();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of (n)  agents:");
        int numberOfAgents = scanner.nextInt();
        System.out.println("Enter number of Grid Size board:");
        int gridSizeBoard = scanner.nextInt();
        System.out.println("Enter number of Rounds");
        int rounds = scanner.nextInt();
        for (int i = 0; i < rounds; i++) {
            printRoundNumber(i);
            result.clearSolution();
            List<AgentsBoards> agentsBoards = FactoryAgents.generateAgentsAndBoards(numberOfAgents, gridSizeBoard);
            for (AgentsBoards board : agentsBoards) {
                System.out.println(board.toString());
            }
            Mailer mailer = new Mailer(numberOfAgents);

            ArrayList<Thread> threads = FactoryAgents.createRunnableAgents(numberOfAgents, agentsBoards, mailer, result);

            //=================HERE ALL HAPPEN=====================
            for (Thread t : threads) {
                t.start();
            }
            //=================HERE ALL HAPPEN=====================
            for (Thread t : threads) {
                t.join(); // Wait for all threads to complete/finish
            }
            result.printSolution();
        }
        result.printResult(rounds, numberOfAgents);
    }

    private static void printRoundNumber(int roundNumber) {
        System.out.println("========================");
        System.out.println("Round Number " + (roundNumber + 1));
        System.out.println("========================");
    }

}