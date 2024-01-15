
// sum of diagonal elements
// if(i==j) then element is diagonal element
public class DiagonalSum {
    public static int diagonalSum(int[][] mat){
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(i==j){ sum+=mat[i][j];}
            }
        }

        return sum;
    }    

    public static void main(String[] args) {
        int[][] arr = {{1,0,0},{0,1,0},{0,0,1}};

        System.out.println("diagonal sum = " + diagonalSum(arr));
    }


}
