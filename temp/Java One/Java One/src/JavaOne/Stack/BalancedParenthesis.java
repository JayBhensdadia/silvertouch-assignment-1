package JavaOne.Stack;

import java.util.Stack;

public class BalancedParenthesis {
    
    public static boolean isBalanced(String exp){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if(exp.charAt(i)=='(' || exp.charAt(i)=='{' || exp.charAt(i)=='['){
                stack.push(exp.charAt(i));
            }else if(exp.charAt(i)==')' || exp.charAt(i)=='}' || exp.charAt(i)==']'){
                if(stack.isEmpty()){
                    return false;
                }
                char ch = stack.pop();
            }
        }
        return stack.isEmpty();

    }
    public static void main(String[] args) {
        String str = "}{[7-9+10]}(4+5{)";
        System.out.println(isBalanced(str));
    }

}
