package JavaOne.DynamicProgramming1;

public class MinStepToOne {


    // iterative DP solution
    public static int countMinStepsToOneHelperDPI(int n) {
        if (n == 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = -1;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {

            int ans1 = Integer.MAX_VALUE;
            int ans2 = Integer.MAX_VALUE;
            int ans3 = Integer.MAX_VALUE;

            ans1 = dp[i - 1];

            if (i % 2 == 0) {
                ans2 = dp[i / 2];
            }

            if (i % 3 == 0) {
                ans3 = dp[i / 3];
            }

            dp[i] = Math.min(ans1, Math.min(ans2, ans3)) + 1;

        }

        return dp[n];
    }

    
    //recursive DP solution
    public static int countMinStepsToOneDPR(int n, int[] dp) {
        if (n == 1) {
            return 0;
        }

        int ans3 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        int ans1 = Integer.MAX_VALUE;

        if (n % 3 == 0) {

            if (dp[n / 3] == -1) {
                ans3 = countMinStepsToOneDPR(n / 3, dp);
                dp[n / 3] = ans3;
            } else {
                ans3 = dp[n / 3];
            }

        }

        if (n % 2 == 0) {

            if (dp[n / 2] == -1) {

                ans2 = countMinStepsToOneDPR(n / 2, dp);
                dp[n / 2] = ans2;
            } else {
                ans2 = dp[n / 2];
            }

        }

        if (dp[n - 1] == -1) {
            ans1 = countMinStepsToOneDPR(n - 1, dp);
            dp[n - 1] = ans1;
        } else {
            ans1 = dp[n - 1];
        }

        return Math.min(ans1, Math.min(ans2, ans3)) + 1;

    }

    //recursive Solution
    public static int countMinStepsToOneR(int n) {
        if (n == 1) {
            return 0;
        }

        int ans3 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        int ans1 = Integer.MAX_VALUE;

        if (n % 3 == 0) {

            ans3 = countMinStepsToOneR(n / 3);

        }

        if (n % 2 == 0) {

            ans2 = countMinStepsToOneR(n / 2);

        }

        ans1 = countMinStepsToOneR(n - 1);

        return Math.min(ans1, Math.min(ans2, ans3)) + 1;

    }

    public static int countMinStepsToOne(int n) {
        // Your code goes here
        // int[] dp = new int[n+1];
        // for(int i = 0; i < dp.length; i++){
        // dp[i] = -1;
        // }
        // return countMinStepsToOneDPR(n,dp);

        return countMinStepsToOneHelperDPI(n);

    }

}
