package Stacks.eval_postfix;

public class Runner {
    public static void main(String[] args) {
        String exp = "231*+8-";
       
        
        System.out.println("evaluation: " + EvaluatePostfix.eval(exp));
    }
}
