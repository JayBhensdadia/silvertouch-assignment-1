package JavaOne.Patterns.StarPatterns.Pattern15;
import java.util.Scanner;

public class Pattern15 {

    static void pattern15(int n1){

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= i; j++) {

                if(j==1 || j==i || i==n1){
                    System.out.print("*");
                }
                else{
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

        pattern15(n);
    }
    
}
