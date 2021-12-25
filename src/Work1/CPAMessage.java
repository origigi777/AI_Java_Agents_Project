package Work1;
public class CPAMessage extends BaseMessage {

    private String mTypeOfMsg = null;
    private final int[] mAssignments;

    public CPAMessage(int n) {
        mAssignments = new int[n];
        for (int i = 0; i < n; i++) {
            mAssignments[i] = -1;
        }
    }

    public int[] getAssignments() {
        return mAssignments;
    }

    public void assign(int id, int assignment) {
        mTypeOfMsg = "";
        mAssignments[id] = assignment;
    }

    public void backtrack(int id) {
        mTypeOfMsg = "backtrack";
        mAssignments[id] = -1;
    }


    public boolean isHeaderBackTrack() {
        return mTypeOfMsg != null && mTypeOfMsg.equals("backtrack");
    }

    public void print() {
        System.out.print("cpa is ");
        for (int mAssignment : mAssignments) {
            System.out.print(mAssignment + " ");
        }
        System.out.println();
    }
}
