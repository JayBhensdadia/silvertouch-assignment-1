package Stacks.infix_to_postfix;

import Stacks.stack.Stack;

public class InfixToPostfix {
    

    //function to return precedence of operators
    static int Prec(char ch) {
        switch (ch) {
        case '+':
        case '-':
          return 1;
    
        case '*':
        case '/':
          return 2;
    
        case '^':
          return 3;
        }
        return -1;
      }


    
    public static String toPostfix(String str){
    
        Stack stack = new Stack();
        String result = new String("");

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            //if scanned character is operand apend it to result

            if(Character.isLetterOrDigit(c)){ result+=c; }
            
            //if scanned character is '(' then push

            else if(c=='('){ stack.push(c);}


            //if scanned character is ')'
            else if(c==')'){
                while (stack.getLength()!=0 && stack.get()!='(') {
                    result+=stack.get();
                    stack.pop();
                }
                stack.pop();
            }else{
                while(stack.getLength()!=0 && Prec(c) <=
                Prec(stack.get())) {
                    result+=stack.get();
                    stack.pop();
                }
                stack.push(c);
            }
        }

        while (stack.getLength()!=0) {
            if (stack.get()=='(') {
                return "Invalid Expression";
            }
            result+=stack.get();
            stack.pop();
        }


        return result;

    }

}
