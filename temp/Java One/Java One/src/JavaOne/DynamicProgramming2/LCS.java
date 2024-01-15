package JavaOne.DynamicProgramming2;

public class LCS {

    public static int lcs(String str1, String str2, int i, int j) {

        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return 1 + lcs(str1, str2, i + 1, j + 1);
        } else {
            return Math.max(lcs(str1, str2, i, j + 1), lcs(str1, str2, i + 1, j));
        }

    }

    public static int lcsDPR(String str1, String str2, int i, int j, int[][] dp) {
        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            int ans;
            if (dp[i + 1][j + 1] == -1) {
                ans = lcsDPR(str1, str2, i + 1, j + 1, dp);
                dp[i + 1][j + 1] = ans;

            } else {
                ans = dp[i + 1][j + 1];
            }
            return 1 + ans;

        } else {
            int ans1, ans2;
            if (dp[i][j + 1] == -1) {
                ans1 = lcsDPR(str1, str2, i, j + 1, dp);
                dp[i][j + 1] = ans1;
            } else {
                ans1 = dp[i][j + 1];
            }

            if (dp[i + 1][j] == -1) {
                ans2 = lcsDPR(str1, str2, i + 1, j, dp);
                dp[i + 1][j] = ans2;
            } else {
                ans2 = dp[i + 1][j];
            }
            return Math.max(ans1, ans2);
        }
    }

    public static int lcsDPI(String str1, String str2) {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {

                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }

            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        String str1 = "bedgmc";
        String str2 = "abdfglc";

        System.out.println(lcs(str1, str2, 0, 0));

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(lcsDPR(str1, str2, 0, 0, dp));
        System.out.println(lcsDPI(str1, str2));
    }
}
