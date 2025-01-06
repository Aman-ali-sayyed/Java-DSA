import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class Greedy {

    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void activitySelection() {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        int activities[][] = new int[start.length][3];
        //0th col => idx; 1st col => start[i]; 2nd col => end[i]k

        for(int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for(int i = 1; i < end.length; i++) {
            if(lastEnd <= activities[i][1]) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Maximum Activities = " + maxAct);

        for(int i = 0; i < ans.size(); i++) {
            System.out.print("A("+ans.get(i) + ") ");
        }
    }

    public static void fractionalKnapsack() {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;

        double ratio[][] = new double[value.length][2];
        //oth col => idx; 1st => ratio
        for(int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)(weight[i]);
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int finalVal = 0;
        int capacity = W;
        for(int i = value.length-1; i >= 0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) {
                finalVal += value[idx];
                capacity -= weight[idx];
            } else {
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("final Value = " + finalVal);
    }

    public static void minSumAbsDiffPairs() {
        int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for(int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i]-B[i]);
        }

        System.out.println("Minimum absolute difference of pairs = " + minDiff);
    }

    public static void maxLenChainOfPairs() {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        ArrayList<Integer> ans = new ArrayList<>();
        int chainLen = 1;
        int chainEnd = pairs[0][1];
        ans.add(0);

        for(int i = 1; i < pairs.length; i++) {
            if(chainEnd <= pairs[i][0]) {
                chainLen++;
                ans.add(i);
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("Maximum lenght of chain = " + chainLen);

        for(int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ans.get(i) + " ");
        }
    }

    public static void indianCoins() {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int count = 0;
        int amount = 888;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < coins.length; i++) {
            if(amount >= coins[i]) {
                while(amount >= coins[i]) {
                    count++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        System.out.println("Total count of coins  " + count);

        System.out.println("The coins which are given.");
        for(int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + ", ");
        }
    }

    public static void jobSequencingProblem() {
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit); // descending order, for ascending (a.profit - b.profit)

        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0;
        for(int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if(curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        //print
        System.out.println("Max jobs " + seq.size());
        for(int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i)+ " ");
        }
    }

    public static void chocolaProblem() {
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int vp = 1, hp = 1;
        int h = 0, v = 0;
        int cost = 0;

        while(h < costHor.length && v < costVer.length) {
            if(costVer[v] <= costHor[h]) {
                cost += (costHor[h]*vp);
                hp++;
                h++; 
            } else {
                cost += (costVer[v]*hp);
                vp++;
                v++;
            }
        }

        while(h < costHor.length) {
            cost += (costHor[h]*vp);
            hp++;
            h++; 
        }

        while(v < costVer.length) {
            cost += (costVer[v]*hp);
            vp++;
            v++;
        }

        System.out.println("minumum cost of cuts = " + cost);
    }

    public static int balancedPartition() {
        String str = "LLRRRLLRRL";
        int n = str.length();

        if(n == 0) {
            return 0;
        }

        int l = 0, r = 0, ans = 0;
        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == 'L') {
                l++;
            }

            if(str.charAt(i) == 'R') {
                r++;
            }

            if(r == l) {
                ans++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(balancedPartition());
    }
}   