package JavaOne.Patterns.StarPatterns.Pattern5;
import java.util.Scanner;

public class Pattern5 {

    static void pattern5(int n1){
        for (int i = 1; i <= n1; i++) {
            for (int j = n1-i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            for (int m = 1; m <= i-1; m++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        pattern5(n);
    }
}
