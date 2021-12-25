package Work1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem {

    private final List<AgentsBoards> mGames;
    private final int mNumberOfAgents;
    private final HashMap<Integer, List<Integer>> mNeighbors = new HashMap<>();

    public Problem(List<AgentsBoards> games, int numberOfAgents) {
        this.mGames = games;
        mNumberOfAgents = numberOfAgents;
    }

    public int getNumberOfAgents() {
        return mNumberOfAgents;
    }

    public List<Integer> getNeighbors(int id) {
        if (mNeighbors.containsKey(id)) {
            return mNeighbors.get(id);
        } else {
            List<Integer> neighbors = new ArrayList<>();
            for (AgentsBoards agentsBoards : mGames) {
                if (agentsBoards.getFirstAgent() == id) {
                    neighbors.add(agentsBoards.getSecondAgent());
                } else if (agentsBoards.getSecondAgent() == id) {
                    neighbors.add(agentsBoards.getFirstAgent());
                }
            }
            mNeighbors.put(id, neighbors);
            return neighbors;
        }

    }

    //This is the problem
    public boolean isOK(int firstAgent, int secondAgent, int firstAgentAssigment, int secondAgentAssigment) {
        for (AgentsBoards agentsBoards : mGames) {
            if (agentsBoards.getFirstAgent() == firstAgent && agentsBoards.getSecondAgent() == secondAgent) {
                return agentsBoards.getIndex(firstAgentAssigment, secondAgentAssigment);
            } else if (agentsBoards.getSecondAgent() == firstAgent && agentsBoards.getFirstAgent() == secondAgent) {
                return agentsBoards.getIndex(secondAgentAssigment, firstAgentAssigment);
            }
        }
        return false;
    }

}
