package Stacks.balanced_parenthesis;

public class Runner {
    public static void main(String[] args) {
        String str = "(((()))";
        System.out.println(BalancedParentheses.isBalanced(str));
    }
}
