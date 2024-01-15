package Stacks.reverse_string;

import Stacks.stack.Stack;

public class ReverseString {
    
    public static String reverseStr(String str){
        Stack stack = new Stack();

        String ans = new String();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);
        }


        for (int i = 0; i < str.length(); i++) {
            char c = stack.get();
            ans += c;
            stack.pop();
        }
        System.out.println(ans.toString());
        return ans.toString();
    }
}
