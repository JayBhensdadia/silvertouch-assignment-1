/*
 * if sum of any row, any column or any diagonal is same then
 * matrix is magic matrix
 */
public class MagicSquare {


    public static boolean isMagicMatrix(int[][] mat){

        // let sum of diagonals be d1 and d2
        int d1 = 0, d2 = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            d1+=mat[i][i];
            d2+=mat[i][n-1-i];
        }

        //if they are not equal
        if(d1!=d2){return false;}

        
        //now check for row-sum and column-sum
        for (int i = 0; i < n; i++) {
            int rSum = 0, cSum = 0;
            
            for (int j = 0; j < n; j++) {
                rSum += mat[i][j];
                cSum += mat[j][i];
            }

            if(rSum!=cSum || cSum!=d1){ return false; }
        }

        return true;

    }    

    public static void main(String[] args) {
        int mat[][] = {{ 2, 7, 6 },
                       { 9, 5, 1 },
                       { 4, 3, 8 }};

        String ans = isMagicMatrix(mat) ? "Yes, given matrix is magic matrix":"No, given matrix is not magix matrix";

        System.out.println(ans);
    }
}
