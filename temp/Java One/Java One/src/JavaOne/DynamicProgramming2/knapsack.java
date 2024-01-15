package JavaOne.DynamicProgramming2;

public class knapsack {

    //iterative DP
    public static int solveKnapsack(int[] weights, int[] values, int maxWeight){
        int[][] dp = new int[values.length+1][maxWeight+1];

        for(int i = values.length-1; i >=0; i--){
            for (int w = 0; w <= maxWeight; w++) {
                int ans;
                if(weights[i] > w){
                    ans = dp[i+1][w];
                }else{
                    int ans1 = values[i]+dp[i+1][w-weights[i]];
                    int ans2 = dp[i+1][w];
                    ans = Math.max(ans1, ans2);
                }

                dp[i][w] = ans;
            }
        }

        return dp[0][maxWeight];
    }


    //recursive Solution
    public static int solveKnapsack(int[] weights, int[] values, int maxWeight, int i){
        if(i>=values.length){
            return 0;
        }
        
        if(weights[i] > maxWeight){
            return solveKnapsack(weights, values, maxWeight, i+1);
        }else{
            
            //case 1 : include
            int ans1 = values[i] + solveKnapsack(weights, values, maxWeight-weights[i], i+1);

            //case 2 : exclude
            int ans2 = solveKnapsack(weights, values, maxWeight, i+1);

            return Math.max(ans1, ans2);
            
        }
    }
    public static void main(String[] args) {
        int[] weights = {4,5,1};
        int[] values = {1,2,3};
        int maxWeight = 4;

        System.out.println(solveKnapsack(weights,values,maxWeight,0));
        System.out.println(solveKnapsack(weights, values, maxWeight));
    }
}
