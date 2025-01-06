import java.util.Arrays;

public class DpA {

    public static int fibo(int n, int fb[]) {
        if(n == 0 || n == 1) {
            return n;
        }

        int nm1 = fibo(n-1, fb);
        int nm2 = fibo(n-2, fb);

        if(fb[n] != 0) {
            return fb[n];
        }

        fb[n] =  nm1+nm2;
        return fb[n];
    }

    public static void fibTabulation(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0; dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
    }

    public static int countWays(int n, int ways[]) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(ways[n] != -1) {
            return ways[n];
        }

        ways[n] = countWays(n-1, ways) + countWays(n-2, ways);
        return ways[n];
    }

    public static int countWaysTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        
        for(int i = 1; i <= n; i++) {
            if(i == 1) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        System.out.println(countWays(n, ways));

        System.out.println(countWaysTab(n));
    }
}