package Stacks.balanced_parenthesis;

import Stacks.stack.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String str) {
        char incoming;
        Stack stack = new Stack();

        for (int i = 0; i < str.length(); i++) {
            incoming = str.charAt(i);
            if (i == 0) {
                stack.push(incoming);
            }

            // top -> opening
            // incoming -> closing
            // then pop other wise push
            else {
                
                if(stack.getLength()==0){return false;}
                char top = stack.get();
                if (incoming == ')' && top == '(') {
                    stack.pop();
                } else {
                    stack.push(incoming);
                }
            }

        }

        return stack.getLength() == 0;

    }

}
