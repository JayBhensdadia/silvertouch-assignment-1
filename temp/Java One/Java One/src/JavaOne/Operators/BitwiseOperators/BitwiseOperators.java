package JavaOne.Operators.BitwiseOperators;

/**
 * BitwiseOperators
 */
public class BitwiseOperators {

    public static void main(String[] args) {
        
        int a = 10;
        int b = 2;

        System.out.println("a & b : "+ (a&b));
        System.out.println("a | b : "+ (a|b));
        System.out.println("a ^ b : "+ (a^b));
        System.out.println("~a : "+ (~a));
        System.out.println("a << 2 : "+ (a << 2));
        System.out.println("a >> 1 : "+ (a >> 1));
        System.out.println("a >>> 1 : "+ (a>>>1));
    }
}