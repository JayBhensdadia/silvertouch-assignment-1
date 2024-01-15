package JavaOne.Patterns.StarPatterns.Pattern6;
import java.util.Scanner;

public class Pattern6 {

    static void pattern6(int n1){
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = n1-i+1; k >= 1; k--) {
                System.out.print("*");
            }
            for (int m = n1-i; m >= 1; m--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        pattern6(n);
    }
}
