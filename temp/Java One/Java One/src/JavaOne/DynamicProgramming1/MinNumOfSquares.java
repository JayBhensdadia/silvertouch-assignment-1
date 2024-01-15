package JavaOne.DynamicProgramming1;

public class MinNumOfSquares {

    public static void printArr(int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

    // iterative DP
    public static int countMinNumOfSquaresDPI(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        printArr(dp);
        for (int i = 2; i <= n; i++) {
            int j = 1;
            int ans = Integer.MAX_VALUE;
            while ((i - j * j) >= 0) {
                int temp = dp[i - j * j];
                if (temp < ans) {
                    ans = temp;
                }
                j++;
            }
            dp[i] = ans + 1;
            printArr(dp);
        }

        return dp[n];
    }

    // recursive DP
    public static int countMinNumOfSquaresDP(int n, int[] dp) {

        if (n == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        int i = 1;
        while ((n - (i * i)) >= 0) {
            int temp;
            if (dp[(n - (i * i))] == -1) {
                temp = countMinNumOfSquaresDP((n - (i * i)), dp);
                dp[(n - (i * i))] = temp;
            } else {
                temp = dp[(n - (i * i))];
            }

            if (temp < ans) {
                ans = temp;
            }
            i++;
        }

        return ans + 1;

    }

    // recursive
    public static int countMinNumOfSquares(int n) {
        if (n == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        int i = 1;
        while ((n - (i * i)) >= 0) {
            int temp = countMinNumOfSquares((n - (i * i)));
            if (temp < ans) {
                ans = temp;
            }
            i++;
        }

        return ans + 1;

    }

    public static void main(String[] args) {
        int n = 10;
        // System.out.println(countMinNumOfSquares(n));

        // int[] dp = new int[n + 1];
        // for (int i = 0; i <= n; i++) {
        // dp[i] = -1;
        // }

        // System.out.println(countMinNumOfSquaresDP(n, dp));
        System.out.println(countMinNumOfSquaresDPI(n));
    }

}
