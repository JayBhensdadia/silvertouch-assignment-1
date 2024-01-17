package Dynamic_Programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int longestIncreasingSubsequence(int[] arr, int i,int pi, int[][] dp){
        if(i>=arr.length){ return 0;}

        if(dp[i][pi+1]!=-1){ return dp[i][pi+1]; }


        int ans1 = longestIncreasingSubsequence(arr, i+1, pi,dp);
        int ans2 = 0;

        if(pi==-1 || arr[i] > arr[pi]){
            ans2 = 1 + longestIncreasingSubsequence(arr, i+1, i,dp);
        }
        
        int ans = Math.max(ans1, ans2);
        dp[i][pi+1] = ans;
        return ans;

    }



    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int[][] dp = new int[arr.length][arr.length+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }


        System.out.println(longestIncreasingSubsequence(arr, 0, -1, dp) );

    }
}
