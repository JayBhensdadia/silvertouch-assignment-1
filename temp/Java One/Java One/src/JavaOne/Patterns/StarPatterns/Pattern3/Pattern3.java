package JavaOne.Patterns.StarPatterns.Pattern3;
import java.util.Scanner;
public class Pattern3 {

    static void pattern3(int n){

        for (int i = 1; i <= n; i++) {
            for (int j = n-i+1; j >= 1 ; j--) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        pattern3(n);
    }
}
