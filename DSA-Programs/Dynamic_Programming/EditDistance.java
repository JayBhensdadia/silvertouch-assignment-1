package Dynamic_Programming;

import java.util.Arrays;

public class EditDistance {
    
    public static int editDistance(String s1, int i, String s2, int j, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;


        if(dp[i][j]!=-1){ return dp[i][j];}


        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] =  0 + editDistance(s1, i-1, s2, j-1,dp);
            return dp[i][j];
        }

        //insert
        int ans1 = 1 + editDistance(s1, i, s2, j-1,dp);

        //delete
        int ans2 = 1 + editDistance(s1, i-1, s2, j,dp);

        //replace
        int ans3 = 1 + editDistance(s1, i-1, s2, j-1,dp);

        dp[i][j] =  Math.min(ans1, Math.min(ans2, ans3));
        return dp[i][j];
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        int[][] dp = new int[s1.length()][s2.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(editDistance(s1, s1.length()-1, s2, s2.length()-1, dp));
    }
}
