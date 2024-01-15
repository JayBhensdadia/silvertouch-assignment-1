package JavaOne.Patterns.StarPatterns.Pattern8;
import java.util.Scanner;

public class Pattern8 {

    static void pattern8(int n1){

        int total = 2*n1-1;
        int p1 = total/2+1;
        int p2 = total - p1;

        for (int i = 1; i <= p1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= p2; i++) {
            for (int j = p2-i+1; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        pattern8(n);
    }
}
