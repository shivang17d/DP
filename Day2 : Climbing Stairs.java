/*
Recursion Method (TLE ERROR)
Time Complexity : O(2^N)
Space Complexity : O(N) (Recursion Stack Space)
*/
class Solution {
    public int climbStairs(int n) {
        if(n<=1) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}



/*
Memoization Method (Top-Down Approach)
Time Complexity : O(N)
Space Complexity : O(N) + O(N) (Recursion Stack Space and Array) =  O(N)
*/
class Solution {
    public int solve(int n, int[] dp) {
        if(n<=1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = solve(n-1,dp) + solve(n-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);   
    }
}



/*
Tabulation Method (Bottom-Up Approach)
Time Complexity : O(N)
Space Complexity : O(N)
*/
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}



/*
Tabulation Method (Bottom-Up Approach) with Space Optimization
Time Complexity : O(N)
Space Complexity : O(1)
*/
class Solution {
    public int climbStairs(int n) {
        int prev1 = 1;
        int prev2 = 1;
        for(int i = 2 ; i <= n ; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}



