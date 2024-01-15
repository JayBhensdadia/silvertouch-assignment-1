package JavaOne.Operators.BitwiseOperators;

import java.util.Scanner;

public class sumOfDigits {

    static int digitSum(int n1){
        int sum = 0;

        while (n1>0) {
            int digit = n1 % 10;
            sum = sum + digit;
            n1 = n1 / 10;
        }


        return sum;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("sum of digits = "+digitSum(n));

    }
}
