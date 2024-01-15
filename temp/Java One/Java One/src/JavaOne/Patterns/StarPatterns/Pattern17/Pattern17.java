package JavaOne.Patterns.StarPatterns.Pattern17;
import java.util.Scanner;

public class Pattern17 {
    
    static void pattern17(int n1){
        for (int i = 1; i <= n1; i++) {
            for (int j = n1-i+1; j >= 1; j--) {
                if (i==1 || j==1 || j==n1-i+1) {
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

        pattern17(n);
    }
}
