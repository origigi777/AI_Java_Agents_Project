package Work1;


import java.util.ArrayList;
import java.util.List;

public class FactoryAgents {

    public static List<AgentsBoards> generateAgentsAndBoards(int numberOfAgents, int gridSize) {
        List<AgentsBoards> agentsGameList = new ArrayList<>();
        for (int i = 0; i < numberOfAgents - 1; i++) {
            for (int j = i + 1; j < numberOfAgents; j++) {
                agentsGameList.add(new AgentsBoards(i, j, gridSize));
            }
        }
        return agentsGameList;

    }

    public static ArrayList<Thread> createRunnableAgents(int numberOfAgents, List<AgentsBoards> agentsBoards, Mailer mailer, Metrics result) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numberOfAgents; i++) {
            Problem problem = new Problem(agentsBoards, numberOfAgents);
            Thread t = new Thread(new Agent(i, agentsBoards.get(i).getGridSize(), problem, mailer, result));
            threads.add(t);
        }
        return threads;
    }
}
