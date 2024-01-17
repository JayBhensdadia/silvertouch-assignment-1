package Dynamic_Programming;

import java.util.Arrays;

public class Fibonacci {
    public static int nthFib(int n, int[] DP){
        if(n <= 1){ return n;}
        int a1,a2,ans;
        if (DP[n-1]!=-1) {a1 = DP[n-1];}
        else{ 
            a1 = nthFib(n-1, DP);
            DP[n-1] = a1;
        }
        if(DP[n-2]!=-1){ a2 = DP[n-2];}
        else{
            a2 = nthFib(n-2, DP);
            DP[n-2] = a2;
        }
    
        return a1+a2;

    }

    public static void main(String[] args) {
        int n = 9;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(nthFib(n,dp));
    }
}
