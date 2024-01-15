package JavaOne.Patterns.StarPatterns.Pattern19;
import java.util.Scanner;

public class Pattern19 {

    static void pattern19(int n1){
        for (int i = 1; i <= n1; i++) {
            for (int j = n1-i+1; j > 1; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                if (i==n1 || k==1) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                
            }
            for (int m = 2; m <= i; m++) {
                if (i==n1 || m==i) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        pattern19(n);
    }
    
}
