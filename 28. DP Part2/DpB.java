public class DpB {
    public static int knapSack(int val[], int wt[], int W, int n, int dp[][]) {
        if(W == 0 || n == 0) {
            return 0;
        }

        if(dp[n][W] != -1) {
            return dp[n][W];
        }

        if(wt[n-1] <= W) { //valid
            //include
            int ans1 = val[n-1]+knapSack(val, wt, W-wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapSack(val, wt, W, n-1, dp);
            dp[n][W] =  Math.max(ans1, ans2);
            return dp[n][W];
        } else { //not valid
            dp[n][W] = knapSack(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static void inputA() {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int dp[][] = new int[val.length+1][W+1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapSack(val, wt, W, val.length, dp));
    }

    public static void print(int dp[][]) {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int knapSackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for(int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < W+1; j++) {
                int v = val[i-1]; //ith item val
                int w = wt[i-1]; //ith item wt
                if(w <= j) {
                    int inclProfit = v + dp[i-1][j-w];
                    int exclProfit = dp[i-1][j];
                    dp[i][j] = Math.max(inclProfit, exclProfit);
                } else {
                    int exclProfit = dp[i-1][j];
                    dp[i][j] = exclProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
    }

    public static void inputB() {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(knapSackTab(val, wt, W));
    }

    public static int unboundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }

        for(int j = 0; j < W+1; j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < W+1; j++) {
                if(wt[i-1] <= j) { //valid
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                } else { //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        System.out.println(unboundedKnapsack(val, wt, W));
    }
}