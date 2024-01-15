package JavaOne.Recursion.Factorial;

public class Factorial {

    public static int fact(int n){
        //base case
        if(n==0){
            return 1;
        }

        
        int smallOutput = fact(n-1);
        //from I.H we assume that we already have (n-1)!
        
        //so we just need to multiply n to (n-1)!
        int output = n * smallOutput;
        return output;
    }

    public static void main(String[] args) {
        System.out.println(fact(5));

        //output : 120
    }
}
