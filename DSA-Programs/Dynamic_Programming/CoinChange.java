package Dynamic_Programming;

import java.util.Arrays;

public class CoinChange {
    
    public static int minCoins(int[] arr, int i, int target, int[][] dp){
        if(i==0){
            if(target % arr[i] == 0) { return target / arr[i];}
            else{ return Integer.MAX_VALUE;}
        }

        if(dp[i][target]!=-1){ return dp[i][target];}

        int notTake = 0 + minCoins(arr, i-1, target,dp);

        int take = Integer.MAX_VALUE;

        if(arr[i] <= target){
            take = 1 + minCoins(arr, i, target - arr[i],dp);
        }

        dp[i][target] = Math.min(notTake, take);
        return dp[i][target];
    }

    public static void main(String[] args) {
        int[] arr = { 1,2 ,3};
        int target = 7;
        int[][] dp = new int[arr.length][target+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(minCoins(arr, arr.length-1, target,dp));
    }
}
