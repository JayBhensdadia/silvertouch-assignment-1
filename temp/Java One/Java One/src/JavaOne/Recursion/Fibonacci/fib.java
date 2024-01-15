package JavaOne.Recursion.Fibonacci;

public class fib {

    public static int fib(int n){
        //base case
        if(n==1 || n==2){
            return 1;
        }

        
        int smallOutput1 = fib(n-1);
        int smallOutput2 = fib(n-2);

        //assuming that we already have fib(n-1) & fib(n-2)

        //so we just need to add them in order to get our nth 
        //fibonacci number
        int output = smallOutput1 + smallOutput2;
        return output;
    }
    public static void main(String[] args) {

        System.out.println(6+"th fibonacci number is : "+fib(6));
        
    }
}
