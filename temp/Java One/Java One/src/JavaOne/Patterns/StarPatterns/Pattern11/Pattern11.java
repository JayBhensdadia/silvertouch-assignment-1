package JavaOne.Patterns.StarPatterns.Pattern11;
import java.util.Scanner;

public class Pattern11 {

    static void pattern11(int n1){
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= n1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        pattern11(n);
    }
    
}
