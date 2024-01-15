package JavaOne.Input;

import java.util.Scanner;

public class cautionInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        double d = sc.nextDouble();
        long l = sc.nextLong();
        float f = sc.nextFloat();
        String str = sc.nextLine();

        System.out.println(str);

        // here the output is empty string 

        /**
         
        because you can not use nextLine() method immediately 
        after nextInt() or nextDouble() or nextLong() or
        nextFLoat() 

        because after taking input these methods points to 
        next line and when we use nextInt() then nextLine()

        so what happens is nextInt() points towards next line of 
        input after taking integer input so our nextLine() method 
        points towards next line (next of our actual input) which
        is empty in our case 
         */

         /**
          * 

            SOLUTION:

            you shoud clear the buffer by putting 
            sc.nextLine() after integral or decimal input

            or you can

            always take input as string and then parse it to 
            whatever type you want
          */

          int solution = Integer.parseInt(sc.nextLine());
    }


}
