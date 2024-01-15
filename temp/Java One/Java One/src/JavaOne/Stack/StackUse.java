package JavaOne.Stack;

public class StackUse {
    public static void main(String[] args) throws StackFullException, StackEmptyExcepiton {
        StackUsingArray stack = new StackUsingArray();
        
        stack.push(5);
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        stack.push(6);
        System.out.println(stack.pop());
        //System.out.println("stack size: "+stack.size());
        //System.out.println("stack top: "+stack.top());
        
        // while(!stack.isEmpty()){
        //     System.out.print(stack.pop() + " ");
        // }
    }

}
