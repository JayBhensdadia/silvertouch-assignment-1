package JavaOne.Patterns.StarPatterns.Pattern20;
import java.util.Scanner;

public class Pattern20 {

    static void pattern20(int n1){

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = n1-i+1; k >= 1; k--) {
                if (i==1 || k==n1-i+1) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }
            for (int m = n1-i+2; m > 2; m--) {
                if (i==1 || m==3) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                //System.out.print("#");

            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        sc.close();
        pattern20(n);
    }
    
}
