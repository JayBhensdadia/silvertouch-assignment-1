
/*
 * pascal's triangle
 * 
 * 
 * 
 * for n = 4
 * 
 * 
 *         0C0
        1C0   1C1
     2C0   2C1   2C2
  3C0   3C1   3C2   3C3
 
 
  nCr = n! / (n-r)! r!

  */

public class PascalTriangle {
    public static int factorial(int i) {
        if (i == 0)
            return 1;
        return i * factorial(i - 1);
    }

    public static void main(String[] args) {
        int n = 4, i, j;

        for (i = 0; i < n; i++) {

            //print space
            for (j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }

            //print number
            for (j = 0; j <= i; j++) {

                // nCr formula
                System.out.print(" "+ factorial(i)/ (factorial(i - j)* factorial(j)));
            }

            System.out.println();
        }
    }
}
