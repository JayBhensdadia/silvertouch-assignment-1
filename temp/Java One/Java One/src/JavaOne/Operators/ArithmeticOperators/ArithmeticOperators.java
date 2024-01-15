package JavaOne.Operators.ArithmeticOperators;

public class ArithmeticOperators {
    public static void main(String[] args) {
        System.out.println("10 + 2 = "+(10+2));
        System.out.println("10 - 2 = "+(10-2));
        System.out.println("10 * 2 = "+(10*2));
        System.out.println("10 / 2 = "+(10/2));
        System.out.println("10 % 2 = "+(10%2));

        System.out.println("10 + 2 * 4 / 8 = "+(10+2*4/8));

        System.out.println("10/2 + 2 * 4 / 8 = "+(10/2+2*4/8));

        System.out.println("10 + 2 * (4 / 8) = "+(10+2*(4.0/8)));
    }
}
