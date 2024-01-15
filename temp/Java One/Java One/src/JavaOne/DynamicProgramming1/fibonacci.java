package JavaOne.DynamicProgramming1;

public class fibonacci {

    

    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static int fibDP(int n,int[] DP){

        //base case
        if(n==0 || n==1){
            return n;
        }

        int ans1,ans2;
        //checking if ans1 is already there in DP or not
        if(DP[n-1]==-1){
            //if not then calculate it
            ans1 = fibDP(n-1,DP);
            //and also store it for future use
            DP[n-1] = ans1;
        }else{
            //if it's already there; then just use it
            ans1 = DP[n-1];
        }

        //checking if ans2 is already there in DP or not
        if(DP[n-2]==-1){
            //if not then calculate it
            ans2 = fibDP(n-2,DP);
            //and also store it for future use
            DP[n-2] = ans2;
        }else{
            //if it's already there; then just use it
            ans2 = DP[n-2];
        }


        return ans1+ans2;
    }
    
    public static int fibI(int n){
        if(n==0 || n==1){
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <=n ;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        int[] DP = {-1,-1,-1,-1,-1,-1};
        System.out.println(fibDP(5, DP));

        System.out.println(fibI(10));
    }
}
