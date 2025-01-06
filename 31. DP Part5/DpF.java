import java.util.*;
public class DpF {

    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        //initialize
        dp[0][0] = true;
        //pattern = " "
        for(int i = 1; i < n+1; i++) {
            dp[i][0] = false;
        }

        //s = " "
        for(int j = 1; j < m+1; j++) {
            if(p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        //bottom-up
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                //case -> ith char == jth char || jth char == ?
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];

    }

    public static void inputA() {
        // String s = "baaabab";
        // String p = "*****ba*****ab"; //true

        String s = "abc";
        String p = "**d";

        System.out.println(isMatch(s, p));
    }

    public static int catalanRec(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += catalanRec(i) * catalanRec(n-i-1);
        }

        return ans; 
    }

    public static int catalanMemo(int n, int dp[]) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        }

        return dp[n] = ans;
    }

    public static void inputB() {
        int n = 5;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(catalanMemo(n, dp));
    }

    public static int catalanTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
    
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
        
    }

    public static int countBST(int n) {
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                int left =  dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }
        }

        return dp[n];
    }

    public static int mountainRanges(int n) {
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside * outside; 
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(mountainRanges(n));
        
    }
}
