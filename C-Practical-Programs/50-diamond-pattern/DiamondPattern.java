
/* LOGIC
 * 
 * lines = 2*n-1
 * starts in each line = 2*i-1
 */

public class DiamondPattern {
    public static void main(String[] args) {
        

        int number = 7;

        int m, n;

        // Outer loop 1
        // prints the first half diamond
        for (m = 1; m <= number; m++) {

            // Inner loop 1 print whitespaces 
            for (n = 1; n <= number - m; n++) {
                System.out.print(" ");
            }

            // Inner loop 2 prints star
            for (n = 1; n <= m * 2 - 1; n++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // Outer loop 2
        // Prints the second half diamond
        for (m = number - 1; m > 0; m--) {

            // Inner loop 1 print whitespaces 
            for (n = 1; n <= number - m; n++) {
                System.out.print(" ");
            }

            // Inner loop 2 print star
            for (n = 1; n <= m * 2 - 1; n++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}