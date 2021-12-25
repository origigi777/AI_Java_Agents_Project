package Work1;

public class AgentsBoards {
    private int mFirstAgent;
    private int mSecondAgent;
    private boolean[][] mGameTable;


    public AgentsBoards(int firstAgent, int secondAgent, int gridSize) {
        mFirstAgent = firstAgent;
        mSecondAgent = secondAgent;
        mGameTable = new boolean[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                mGameTable[i][j] = !(Math.random() > 0.5);
                // 0.5> false , <0.5 true
            }
        }
    }

    @Override
    public String toString() {
        return "Agent " + mFirstAgent + ", " + mSecondAgent + ":" + "\n" +
                getBoard();
    }


    public String getBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mGameTable.length; i++) {
            for (int j = 0; j < mGameTable.length; j++) {
                sb.append(mGameTable[i][j] ? "1 " : "0 ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getGridSize() {
        return mGameTable.length;
    }

    public boolean getIndex(int row, int column) {
        return mGameTable[row][column];
    }

    public int getFirstAgent() {
        return mFirstAgent;
    }

    public int getSecondAgent() {
        return mSecondAgent;
    }


}
