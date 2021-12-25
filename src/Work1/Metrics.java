package Work1;

import java.util.ArrayList;


public class Metrics {

    private int mChecks, mAssignments, mBackTracks;
    private final ArrayList<Integer> mSolution = new ArrayList<>();

    public void printResult(int N, double p2) {
        System.out.println("For p2 = " + p2 + ":");
        System.out.println("There were: " + (mBackTracks / N) + " backtracks on average");
        System.out.println("There were: " + (mAssignments / N) + " assignments on average");
        System.out.println("There were: " + (mChecks / N) + " checks on average");
        System.out.println();
    }

    public void incrementChecks() {
        this.mChecks++;
    }

    public void incrementBackTrack() {
        this.mBackTracks++;
    }

    public void clearSolution() {
        mSolution.clear();
    }

    public void printSolution() {
        if (mSolution.isEmpty()) {
            System.out.println("No solution");
        } else {
            System.out.println("Solution is:");
            for (Integer i : mSolution) {
                System.out.println(i);
            }
        }
        System.out.println();
    }

    public void setAssignments(int[] assignments) {
        mSolution.clear();
        for (int index : assignments) {
            mSolution.add(index);
        }
    }

    public void incrementAssigment() {
        this.mAssignments++;
    }
}
