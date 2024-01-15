
/**
 * all elements above principle diagonal should be zero
 */
public class LowerTriangularMatrix {
    public static final int N = 4;
 

    public static boolean isLowerTriangularMatrix(int mat[][])
    {
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                if (mat[i][j] != 0)
                    return false;
 
        return true;
    }
 

    public static void main(String args[])
    {
       
        int mat[][] = { { 1, 0, 0, 0 },
                        { 1, 4, 0, 0 },
                        { 4, 6, 2, 0 },
                        { 0, 4, 7, 6 } };
                         

        if (isLowerTriangularMatrix(mat))
            System.out.println("Yes");
        else
            System.out.println("No");
    }    
}
