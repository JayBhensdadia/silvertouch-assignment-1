package JavaOne.Operators.BitwiseOperators;

import java.util.Scanner;


/**
 *    123 --> 321
 *    1*100 + 2*20 + 3*1 ---> 3*100 + 2*20 + 1*1
 * 
 *    idea : getting digit from right end multiply it with 
 *           10 ^total number of digits - 1 
 *           then count--;
 */

public class reverseTheNumber {

    static int reverseNum(int n1, int count){

        double rev = 0;

        while (n1>0) {
            int digit = n1 % 10;
            rev = rev + (digit * Math.pow(10, count-1));
            count--;
            n1 = n1 / 10;
        }


        return (int)rev;
    }
    public static void main(String[] args) {
        countDIgitOfNumber ob = new countDIgitOfNumber();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = ob.noOfDigits(n);

        System.out.println("reverse number = "+ reverseNum(n, count));
    }
}
