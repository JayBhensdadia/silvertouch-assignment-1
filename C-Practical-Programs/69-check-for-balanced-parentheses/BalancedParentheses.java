import java.util.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else if (isClosingBracket(ch)) {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); 
    }

    private static boolean isOpeningBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private static boolean isClosingBracket(char ch) {
        return ch == ')' || ch == '}' || ch == ']';
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }

    public static void main(String[] args) {
        String expression1 = "{[()]()}";
        String expression2 = "([)]";
        String expression3 = "((()";

        System.out.println("is  \"" + expression1 + "\" balanced? " + isBalanced(expression1));
        System.out.println("is  \"" + expression2 + "\" balanced? " + isBalanced(expression2));
        System.out.println("is  \"" + expression3 + "\" balanced? " + isBalanced(expression3));
    }
}
