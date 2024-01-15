package JavaOne.Patterns.StarPatterns.Pattern1;

import java.util.Scanner;

/*
 
        *                   no of rows = n       
        **                  no of columns = row number
        ***                 what to print = *
        ****
        *****


 */

public class Pattern1 {

    static void pattern1(int n){

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        pattern1(n);
    }
}
