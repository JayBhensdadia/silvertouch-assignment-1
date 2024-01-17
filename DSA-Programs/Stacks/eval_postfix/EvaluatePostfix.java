package Stacks.eval_postfix;

import Stacks.stack.Stack;


public class EvaluatePostfix {

    
    public static int eval(String str) {
        Stack stack = new Stack();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c);
            } else {
                

                int a = Integer.parseInt(String.valueOf(stack.get()));
                stack.pop();
                int b = Integer.parseInt(String.valueOf(stack.get()));
                stack.pop();

                switch (c) {
                    case '+':
                        stack.push(String.valueOf(a + b).charAt(0));
                        break;
                    case '-':
                        stack.push(String.valueOf(b - a).charAt(0));
                        break;
                    case '/':
                        stack.push(String.valueOf(b / a).charAt(0));
                        break;
                    case '*':
                        stack.push(String.valueOf(a * b).charAt(0));
                        break;
                }
            }
        }

        return stack.get();
    }
}