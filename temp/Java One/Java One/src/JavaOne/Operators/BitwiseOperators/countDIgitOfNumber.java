package JavaOne.Operators.BitwiseOperators;

import java.util.Scanner;

/**
    
    count the number of digits in given number

 */

public class countDIgitOfNumber {

    static int noOfDigits(int n1){

        int count = 0;

        while (n1>0) {
            //getting digits 
            int digit = n1 % 10;

            //incrementing counter
            count++;
            n1 = n1 / 10;
        }
        return count;

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("number of digits = "+noOfDigits(n));
    }
}
