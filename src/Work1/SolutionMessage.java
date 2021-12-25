package Work1;
public class SolutionMessage extends BaseMessage {

    private boolean mIsProblemSolved;

    public SolutionMessage(boolean isProblemSolved) {
        mIsProblemSolved = isProblemSolved;
    }


    public boolean isSolutionSolved() {
        return mIsProblemSolved;
    }
}
