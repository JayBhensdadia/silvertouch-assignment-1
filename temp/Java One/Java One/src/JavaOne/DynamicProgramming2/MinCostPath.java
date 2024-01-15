package JavaOne.DynamicProgramming2;

public class MinCostPath {

    //top - down approach
    public static int minCostPathHelperDPI2(int[][] arr){
        int[][] dp = new int[arr.length+1][arr[0].length+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length ; j++) {

                if(i==1&& j==1){
                    dp[i][j] = arr[i-1][j-1];
                    continue;
                }

                int op1 = dp[i][j-1];
                int op2 = dp[i-1][j-1];
                int op3 = dp[i-1][j];

                dp[i][j] = arr[i-1][j-1] + Math.min(op1, Math.min(op2, op3));
            }
        }

        return dp[arr.length][arr[0].length];
    }

    //bottom up approach
    public static int minCostPathHelperDPI(int[][] arr){
        int[][] dp = new int[arr.length+1][arr[0].length+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = arr[0].length-1; j >=0 ; j--) {

                if(i==arr.length-1 && j==arr[0].length-1){
                    dp[i][j] = arr[i][j];
                    continue;
                }

                int op1 = dp[i][j+1];
                int op2 = dp[i+1][j+1];
                int op3 = dp[i+1][j];

                dp[i][j] = arr[i][j] + Math.min(op1, Math.min(op2, op3));
            }
        }

        return dp[0][0];
    }


    public static int minCostPathHelperDPR(int[][] arr,int i ,int j, int[][] dp){
        if (i >= arr.length || j >= arr[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == arr.length - 1 && j == arr[0].length - 1) {
            return arr[arr.length - 1][arr[0].length - 1];
        }

        int ans1,ans2,ans3;

        //right
        if(dp[i][j+1]==Integer.MIN_VALUE){
            ans1 = minCostPathHelperDPR(arr, i, j + 1,dp);
            dp[i][j+1] = ans1;
        }else{
            ans1 = dp[i][j+1];
        }

        //diagonal
        if(dp[i+1][j+1]==Integer.MIN_VALUE){
            ans2 = minCostPathHelperDPR(arr, i+1, j + 1,dp);
            dp[i+1][j+1] = ans1;
        }else{
            ans2 = dp[i+1][j+1];
        }

        //down
        if(dp[i+1][j]==Integer.MIN_VALUE){
            ans3 = minCostPathHelperDPR(arr, i+1, j,dp);
            dp[i+1][j] = ans3;
        }else{
            ans3 = dp[i+1][j];
        }
        


        int min = Math.min(ans1, Math.min(ans2, ans3));

        return arr[i][j] + min;
    }


    //recursive Solution
    public static int minCostPathHelper(int[][] arr, int i, int j) {
        
        //base case
        if (i >= arr.length || j >= arr[0].length) {
            return Integer.MAX_VALUE;
        }

        //special case
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            return arr[arr.length - 1][arr[0].length - 1];
        }

        int ans1,ans2,ans3;

        //right
        ans1 = minCostPathHelper(arr, i, j + 1);

        //diagonal
        ans2 = minCostPathHelper(arr, i + 1, j + 1);

        //down
        ans3 = minCostPathHelper(arr, i + 1, j);

        int min = Math.min(ans1, Math.min(ans2, ans3));

        return arr[i][j] + min;
    }

    public static int minCostPath(int[][] input) {
        return minCostPathHelper(input, 0, 0);
    }

    public static void main(String[] args) {
        
        int arr[][] = { { 5, 7, 2, 4 }, { 1, 8, 1, 3 }, { 6, 2, 9, 5 }, { 1, 6, 2, 8 } };
        
        //dp intialized with -infinity
        int[][] dp = new int[arr.length+1][arr[0].length+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        //System.out.println(minCostPathHelperDPR(arr, 0, 0, dp));
        //System.out.println(minCostPath(arr));

        System.out.println(minCostPathHelperDPI(arr));
    }

}
