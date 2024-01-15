package Stacks.infix_to_postfix;

/**
 * Runner
 */
public class Runner {

    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Prefix expression: " + InfixToPostfix.toPostfix(exp));
    }
}