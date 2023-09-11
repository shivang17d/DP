/*
Recursion Method
Time Complexity : O(2^N)
Space Complexity : O(N)
*/
class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        
        return fib(n-1)+fib(n-2);  
    }
}


/*
Memoization Method
Time Complexity : O(N)
Space Complexity : O(N) + O(N) (Recursion Stack Space and Array) =  O(N)
*/

class Solution {
    public int solve(int n,int[] dp) {
        if(n<=1) return n;
        if(dp[n] != -1) return dp[n];

        dp[n] = solve(n-1,dp) + solve(n-2,dp);
        return dp[n];
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = solve(n,dp);
        return ans;  
    }
}


/*
Tabulation Method (Bottom-Up Approach)
Time Complexity : O(N)
Space Complexity : O(N)
*/

class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
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
    public int fib(int n) {
        if(n <= 1) return n;
        int prev2 = 0;
        int prev1 = 1;
        for(int i = 2 ; i <= n ; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
