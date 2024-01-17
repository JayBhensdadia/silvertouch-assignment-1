package Dynamic_Programming;

import java.util.Arrays;

public class LCS {
    
    public static int lcs(String s1, int i, String s2, int j, int[][] dp){
        if(i<0 || j<0){ return 0;}

        if(dp[i][j]!=-1){ return dp[i][j];}


        if(s1.charAt(i)==s2.charAt(j)){ 
            dp[i][j] =  1 + lcs(s1, i-1, s2, j-1,dp);
            return dp[i][j];
        }
        dp[i][j] = 0 + Math.max(lcs(s1, i-1, s2, j,dp), lcs(s1, i, s2, j-1,dp));
        return dp[i][j];
    }

    public static void main(String[] args) {
        // String s1 = "AGGTAB";
        // String s2 = "GXTXAYB";

        String s1 = "acd";
        String s2 = "ced";
        
        int[][] dp = new int[s1.length()][s2.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(lcs(s1, s1.length()-1, s2, s2.length()-1, dp));
    }
}
