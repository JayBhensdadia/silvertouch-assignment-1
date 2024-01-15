package JavaOne.Patterns.StarPatterns.Pattern4;
import java.util.Scanner;

public class Pattern4 {

    static void pattern4(int n1){

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = n1-i+1; k >= 1 ; k--) {
                System.out.print("*");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        pattern4(n);
    }
}
