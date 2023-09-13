/*
Method: Recursion(TLE Error)
Time Complexity: O(2^N)
Space Complexity: O(N)
*/
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int f(int ind,int[] heights) {
        if(ind==0) return 0;
    
        int jumpOne = f(ind-1,heights) + Math.abs(heights[ind]-heights[ind-1]);
        int jumpTwo = Integer.MAX_VALUE;
        if(ind>1) jumpTwo = f(ind-2,heights) + Math.abs(heights[ind]-heights[ind-2]);
        return Math.min(jumpOne,jumpTwo);
    }
    public static int frogJump(int n, int[] heights) {
        return f(n-1,heights);        
    }
}


/*
Method: Memoization (Top-Down Approach)
Time Complexity: O(N)
Space Complexity: O(N)
*/
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int f(int ind,int[] heights,int[] dp) {
        if(ind==0) return 0;
        if(dp[ind] != -1) return dp[ind];
    
        int jumpOne = f(ind-1,heights,dp) + Math.abs(heights[ind]-heights[ind-1]);
        int jumpTwo = Integer.MAX_VALUE;
        if(ind>1) jumpTwo = f(ind-2,heights,dp) + Math.abs(heights[ind]-heights[ind-2]);
        return dp[ind] = Math.min(jumpOne,jumpTwo);
    }
    public static int frogJump(int n, int[] heights) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(n-1,heights,dp);        
    }
}



/*
Method: Tabulation (Bottom-UP Approach)
Time Complexity: O(N)
Space Complexity: O(N)
*/
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i = 1 ; i < n ; i++) {
            int jumpOne = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int jumpTwo =  Integer.MAX_VALUE;
            if(i>1) jumpTwo = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            dp[i] = Math.min(jumpOne,jumpTwo);
        }
        return dp[n-1];    
    }
}



/*
Method: Tabulation (Bottom-UP Approach) with Space Optimization
Time Complexity: O(N)
Space Complexity: O(1)
*/
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int[] heights) {
        int prev1 = 0;
        int prev2 = 0;
        for(int i = 1 ; i < n ; i++) {
            int jumpOne = prev1 + Math.abs(heights[i] - heights[i-1]);
            int jumpTwo =  Integer.MAX_VALUE;
            if(i>1) jumpTwo = prev2 + Math.abs(heights[i] - heights[i-2]);
            int curr = Math.min(jumpOne,jumpTwo);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;    
    }
}
