
public class MatrixMultiplication {
    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }

    //A = row1 x col1
    //B = row2 x col2
    //ans = row1 x col2
    static void multiplyMatrix(int row1, int col1, int A[][], int row2, int col2, int B[][]) {
        
        int i, j, k;

      
        System.out.println("\nMatrix A:");
        printMatrix(A);
        System.out.println("\nMatrix B:");
        printMatrix(B);

        // if multiplication is not possible
        if (row2 != col1) {

            System.out.println(
                    "\nMultiplication Not Possible");
            return;
        }

   
        // product matrix = row1 x col2
        int C[][] = new int[row1][col2];

        // Multiply the two matrices
        for (i = 0; i < row1; i++) {
            for (j = 0; j < col2; j++) {
                for (k = 0; k < row2; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }

        
        System.out.println("\nResultant Matrix:");
        printMatrix(C);
    }

    public static void main(String[] args) {
        int row1 = 4, col1 = 3, row2 = 3, col2 = 4;

        int A[][] = { { 1, 1, 1 },
                { 2, 2, 2 },
                { 3, 3, 3 },
                { 4, 4, 4 } };

        int B[][] = { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 } };

        multiplyMatrix(row1, col1, A, row2, col2, B);
    }
}
