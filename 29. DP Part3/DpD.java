public class DpD {
    public static int coinChange(int coins[], int sum) {
        int n = coins.length; 
        int dp[][] = new int[n+1][sum+1];

        //initialize - sum is 0
        //i -> coins; j -> sum/change
        for(int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }

        for(int j = 1; j < sum+1; j++) {
            dp[0][j] = 0;
        }

        //O(N*SUM)
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < sum+1; j++) {
                if(coins[i-1] <= j) { //valid
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void inputA() {
        int coins[] = {1, 2, 3};
        int sum = 4;

        System.out.println(coinChange(coins, sum));
    }

    public static int rodCutting(int length[], int price[], int totRod) {
        int n = price.length;
        int dp[][] = new int[n+1][totRod+1];

        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < totRod+1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < totRod+1; j++) {
                if(length[i-1] <= j) {
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][totRod];
    }

    public static void inputB() {
       int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
       int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
       int totRod = 8;

       System.out.println(rodCutting(length, price, totRod));
    }

    //Recursion
    public static int lcs(String str1, String str2, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return lcs(str1, str2, n-1, m-1)+1;
        } else {
            int ans1 = lcs(str1, str2, n-1, m);
            int ans2 = lcs(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    //memoization
    public static int lcs2(String str1, String str2, int n, int m, int dp[][]) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return dp[n][m] = lcs2(str1, str2, n-1, m-1, dp) + 1;
        } else {
            int ans1 = lcs2(str1, str2, n-1, m, dp);
            int ans2 = lcs2(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static void inputC() {
        String str1 = "abcdge";
        String str2 = "abedg";
 
        int n = str1.length();
        int m = str2.length();
 
        int dp[][] = new int[n+1][m+1];
 
        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < m+1; j++) {
                dp[i][j] = -1;
            }
        }
 
        System.out.println(lcs2(str1, str2, n, m, dp));
    }

    public static int lcsTab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < m+1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] =  Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
       String str1 = "abcdge";
       String str2 = "abedg";

       System.out.println(lcsTab(str1, str2));
    }
}
