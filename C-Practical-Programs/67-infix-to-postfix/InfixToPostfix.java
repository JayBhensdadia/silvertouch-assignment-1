import java.util.Stack;

public class InfixToPostfix {

    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfixExpression.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpression.append(stack.pop());
                }
                stack.pop(); 
            } else {
               
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfixExpression.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop());
        }

        return postfixExpression.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
