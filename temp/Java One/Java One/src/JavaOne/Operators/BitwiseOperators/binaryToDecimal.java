package JavaOne.Operators.BitwiseOperators;

import java.util.Scanner;

/**
 * 
 * convert the binary number to decimal
 */

public class binaryToDecimal {

    static int toDecimal(int n1){

        double decimal = 0;
        int count = 0;
        while (n1>0) {

            //getting digits one by one from right end

            int digit = n1 % 10;

            // multiplying each digits by appropriate power of 2
            decimal = decimal + (digit * Math.pow(2, count));
            count++;
            
            n1 = n1 / 10;
        }


        return (int)decimal;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("decimal = " + toDecimal(n));
    }
}
