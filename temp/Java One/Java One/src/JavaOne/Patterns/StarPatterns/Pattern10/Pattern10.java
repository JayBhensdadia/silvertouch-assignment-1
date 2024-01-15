package JavaOne.Patterns.StarPatterns.Pattern10;
import java.util.Scanner;

public class Pattern10 {

    static void pattern10(int n1){
        for (int i = 1; i <= n1; i++) {
            for (int j = n1-i+1; j > 1; j--) {
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

        pattern10(n);
    }
    
}
