

public class MatrixAddition {
    public static int[][] matAddition(int[][] m1, int[][] m2){
        int[][] ans = new int[m1.length][m1[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                ans[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return ans;
    }

    public static void print2DArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m1 = {{1,2,3},{4,5,6}};
        int[][] m2 = {{6,7,8},{9,10,11}};

        int[][] ans = matAddition(m1, m2);
        print2DArray(ans);
    }
}
