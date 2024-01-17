package Application_Based;

import java.util.Stack;

public class PostfixEvaluator {

    public static int evaluatePostfix(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : postfixExpression.toCharArray()) {
            if (Character.isDigit(ch)) {
                
                stack.push(Character.getNumericValue(ch));
            } else {
                
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }
            }
        }

        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        
        String postfixExpression = "34+";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);

        
        postfixExpression = "523*+";
        result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);
    }
}

