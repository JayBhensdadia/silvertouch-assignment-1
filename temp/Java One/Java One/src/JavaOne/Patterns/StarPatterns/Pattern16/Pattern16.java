package JavaOne.Patterns.StarPatterns.Pattern16;
import java.util.Scanner;



public class Pattern16 {
    
    static void pattern16(int n1){
        for (int i = 1; i <= n1; i++) {
            for (int j = n1-i+1; j > 1; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                if (k==1 || k==i || i==n1) {
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


        pattern16(n);
    }
    
}
