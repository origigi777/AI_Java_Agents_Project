package Work1;


public class Agent implements Runnable {

    private final Metrics mMetrics;
    private final Problem mProblem;
    private int mAgentNumber, mAssigment = -1, mGridSize;
    private final Mailer mMailer;
    private boolean mIsAlive = true;

    public Agent(int id, int gridSize, Problem p, Mailer mailer, Metrics metrics) {
        this.mAgentNumber = id;
        this.mGridSize = gridSize;
        this.mProblem = p;
        this.mMailer = mailer;
        this.mMetrics = metrics;
    }

    private boolean isProblemSolved(CPAMessage cpa, int i) {
        for (int neighbour : mProblem.getNeighbors(mAgentNumber)) {
            if (cpa.getAssignments()[neighbour] == -1) {
                continue;
            }
            if (!mProblem.isOK(mAgentNumber, neighbour, i, cpa.getAssignments()[neighbour])) {
                System.out.println("Problem not solved");
                return false;
            }
        }
        System.out.println("Problem solved");
        return true;
    }

    private void handleFirstAgent() {
        mAssigment = 0;
        CPAMessage cpa = new CPAMessage(mProblem.getNumberOfAgents());
        cpa.assign(mAgentNumber, 0);
        mMetrics.incrementAssigment();
        mMailer.sendMessage(1, cpa);
    }


    private void killAgent() {
        mIsAlive = false;
    }

    @Override
    public void run() {
        if (mAgentNumber == 0) {
            handleFirstAgent();
        }
        while (mIsAlive) {
            BaseMessage msg = this.mMailer.readMessage(this.mAgentNumber);
            if (msg instanceof SolutionMessage) {
                if (((SolutionMessage) msg).isSolutionSolved()) {
                    System.out.println(this.mAgentNumber + " has solution");
                } else {
                    System.out.println(this.mAgentNumber + " has not solution");
                }
                killAgent();
                break;
            } else if (msg instanceof CPAMessage) {
                System.out.println("i got a cpa. my id is " + mAgentNumber);
                CPAMessage cpa = (CPAMessage) msg;
                cpa.print();
                boolean hasValidSolution = false;
                if (cpa.isHeaderBackTrack()) {
                    mAssigment++;
                } else {
                    mAssigment = 0;
                }
                for (int i = mAssigment; i < mGridSize; i++) {
                    mMetrics.incrementChecks();
                    if (isProblemSolved(cpa, i)) {
                        hasValidSolution = true;
                        mAssigment = i;
                        break;
                    }
                }

                if (!hasValidSolution) {
                    if (mAgentNumber == 0) {
                        noSolution();
                        return;
                    } else {
                        mAssigment = -1;
                        backtrack(cpa);
                        mMetrics.incrementBackTrack();
                    }
                } else {
                    cpa.assign(mAgentNumber, mAssigment);
                    mMetrics.incrementAssigment();
                    if (mAgentNumber == mProblem.getNumberOfAgents() - 1) {
                        hasSolution(cpa);
                        return;
                    } else {
                        mMailer.sendMessage((mAgentNumber + 1) % mProblem.getNumberOfAgents(), cpa);
                    }
                }
            }
        }
    }

    public void backtrack(CPAMessage cpa) {
        cpa.backtrack(mAgentNumber);
        mMailer.sendMessage((mAgentNumber - 1) % mProblem.getNumberOfAgents(), cpa);
    }

    public void hasSolution(CPAMessage cpa) {
        SolutionMessage s = new SolutionMessage(true);
        for (int i = 0; i < mProblem.getNumberOfAgents(); i++) {
            mMailer.sendMessage(i, s);
        }
        mMetrics.setAssignments(cpa.getAssignments());
    }

    public void noSolution() {
        SolutionMessage ns = new SolutionMessage(false);
        for (int i = 0; i < mProblem.getNumberOfAgents(); i++) {
            mMailer.sendMessage(i, ns);
        }
    }
}
