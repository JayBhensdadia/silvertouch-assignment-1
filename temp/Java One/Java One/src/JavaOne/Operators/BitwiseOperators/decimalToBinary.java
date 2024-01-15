package JavaOne.Operators.BitwiseOperators;

import java.util.Scanner;

/**
 * convert binary to decimal
 */

public class decimalToBinary {

    static int toBinary(int n1){
        double binary = 0;
        int count = 0;
        while (n1>0) {

            //getting remainder one by one
            int rem = n1 % 2;

            //multiplying remainder with appropriate power of 10
            binary = binary + (rem * Math.pow(10, count));
            count++;
            n1 = n1 / 2;
        }


        return (int)binary;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("binary = "+ toBinary(n));
    }
}
